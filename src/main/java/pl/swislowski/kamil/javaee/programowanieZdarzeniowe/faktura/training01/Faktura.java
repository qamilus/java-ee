package pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.training01;

import pl.swislowski.kamil.javaee.programowanieZdarzeniowe.faktura.Kontrahent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Faktura {
// ----------------------------------------------- POLA FAKTURY
	//dla kogo to jest faktura
	private Kontrahent klient;
	// kiedy zosta�a wystawiona
	private LocalDate dataWystawienia;

// ----------------------------------------------- IDENTYFIKATOR FAKTURY
	// identyfikator, numer faktury
	private String nr;
	// klasa do sporz�dzania identyfikatora: jest statyczna, bo nie potrzebuje obiketu Faktury by dzia�a�
	private static class Identyfikator{
		// ma statyczne pola
		static int aktualnyNumer = 0;
		static int aktualnyMiesiac = 0;
		static int aktualnyRok = 0;

		// i metod� do generowania numeru
		// kt�ra dzia�a niezale�nie od liczby ju� wystawionych faktur
		static String generateNr(){
			LocalDate ld = LocalDate.now();

			// aktualizacja roku
			int year = ld.getYear();
			int month = ld.getMonthValue();
			if(year > aktualnyRok){
				aktualnyRok = year;
				aktualnyMiesiac = ld.getMonthValue();
				aktualnyNumer = 0;
			}
			//aktualizacja miesi�ca
			else if(month > aktualnyMiesiac){
				aktualnyMiesiac = month;
				aktualnyNumer = 0;
			}
			// zwracamy tekst sk�adaj�cy si� z numeru dokumentu w danym miesi�cu, miesi�ca i roku
			return (++aktualnyNumer)+"/"+aktualnyMiesiac+"/"+aktualnyRok;

		}
	}


// ----------------------------------------------- POZYCJE FAKTURY
	// typy wyliczeniowe potrzebne przy obs�udze pozycji fakturowej
	public enum Miara{SZT,M,L,KG,M2} // typ okre�laj�cy rodzaje jednostki
	public enum VAT{ // typ okre�lj�cy warto�ci podatku
		s23(.23), s08(.08), s05(.05), s00(.0);
		// opr�cz identyfikatora (np. s23) podajemy r�wnie� jego odpowiednik typu double(stawka) by m�c z niego korzysta� przy wyznaczaniu warto�ci brutto
		// oraz wyznaczamy reprezentacj� znakow� tej stawki( w formie np 23%)
		public double stawka;
		public String str;
		VAT(double stawka){ // konstruktor ustawaj�cy pola
			this.stawka = stawka;
			this.str = String.format("%.0f%%",100*stawka); // przeliczenie doubla na warto�� ca�kowit� ze znakiem %
		}
	}
	// prywatna klasa wewn�trzna opisuj�ca pojedyncz� pozycj� na fakturze
	public class Pozycja{
		private int pozycja;
		private String nazwa;
		private Miara miara;
		private double ilosc;
		private double cenaJednostkowaNetto;
		private VAT podatek;

		public Pozycja(String nazwa, Miara miara, double ilosc, double cena, VAT podatek) {
			this.nazwa = nazwa;
			this.miara = miara;
			this.ilosc = ilosc;
			this.cenaJednostkowaNetto = cena;
			this.podatek = podatek;
			this.pozycja = pozycje.size()+1; // klasa Pozycja nie mo�e by� statyczna poniewa� odwo�uje si� do niestatycznego pola klasy zewn�trznej
		}
		public double getWartosc(){return ilosc*cenaJednostkowaNetto;}
		public double getPodatek(){
			double d = ilosc*cenaJednostkowaNetto*podatek.stawka; //tworz� obiekt d i ustawiam warto��
			// zaokr�glanie liczby do dw�ch miejsc po przecinku
			d = Math.round(d*100)/100.;
			return d;
		}
		@Override
		public String toString(){
			return String.format("%5d | %30s | %10s | %10s | %10s | %10s | %10.2f",pozycja,nazwa,miara,ilosc,cenaJednostkowaNetto,podatek.str,getWartosc()+getPodatek());
		}
	}
	// metoda naglowek() nie mo�e by� (jako statyczna) w klasie Pozycja poniewa� klasa Pozycja nie jest statyczna
	// mo�na by t� metod� wstawi� do klasy Pozycja, ale jako niestatyczn�
	// - niestety wtedy nie b�dziemy w stanie wydrukowa� nag��wka pustej faktury(w trakcie tworzenia)
	// poniewa� nie b�dzie �adnego obiektu typu Pozycja kt�ry by t� metod� wywo�a�.
	public static String naglowek(){
		return String.format("%5s | %30s | %10s | %10s | %10s | %10s | %10s","LP.","NAZWA","MIARA","ILOSC","CENA JEDN.","PODATEK","WARTOSC BRUTTO");
	}
	// pole zawieraj�ce list� pozycji
	private ArrayList<Pozycja> pozycje = new ArrayList<Pozycja>();
	// metoda dodaj�ca kolejn� pozycj� do faktury
	public void addPozycja(String nazwa,Miara m, double ilosc, double cena, VAT podatek ){
		if(zamknieta) return; // wyjd� je�li faktury nie mo�na edytowa�

		Pozycja p = new Pozycja(nazwa, m, ilosc, cena, podatek);
		pozycje.add(p);
		// oblicznie podatku od tej pozycji i dodanie go do podsumy
		double d = podsumy.get(podatek);
		d += p.getPodatek();
		podsumy.put(podatek,d);
		// dodanie do sumy netto
		sumaNetto += p.getWartosc();
		// dodanie do sumy brutto
		sumaDoZaplaty += p.getWartosc()+ p.getPodatek();
	}

// ----------------------------------------------- DODATKOWE W�ASNO�CI FAKTURY	

	// czy faktur� mo�na jeszcze edytowa�
	private boolean zamknieta = false;
	//metoda zamykaj�ca faktur�, co zabrania j� edytowa�
	public void zamknij(){
		zamknieta = true;
	}
	// sumy w poszczeg�lnych stawkach
	private HashMap<VAT, Double> podsumy = new HashMap<>();
	private double sumaNetto = 0;
	private double sumaDoZaplaty = 0;

// ----------------------------------------------- KONSTUKTOR	

	public Faktura(Kontrahent k){
		nr = Identyfikator.generateNr();
		klient = k;
		dataWystawienia = LocalDate.now();

		//inicjowanie podsum stawkami VAT
		for(VAT v: VAT.values()){
			podsumy.put(v, 0.);
		}
	}

	public Kontrahent getKlient() {
		return klient;
	}

	public LocalDate getDataWystawienia() {
		return dataWystawienia;
	}

	public String getNr() {
		return nr;
	}

	public ArrayList<Pozycja> getPozycje() {
		return pozycje;
	}

	public boolean isZamknieta() {
		return zamknieta;
	}
	// ----------------------------------------------- WYPASANIE

	@Override
	public String toString(){
		String faktura = "---------------------------------------------\n";
		faktura += (zamknieta?"Z-":"O-")+"Faktura nr."+ nr +"\n";
		faktura += "z dnia " + dataWystawienia.format(DateTimeFormatter.ofPattern("d-M-y")) + "\n";
		faktura += "\nDLA: \n"+klient +"\n\n";
		faktura += naglowek() +"\n";
		for(Pozycja p:pozycje){
			faktura += p.toString()+"\n";
		}
		faktura += "\n";
		faktura += String.format("%-15s: %10.2f\n", "SUMA NETTO", sumaNetto);
		for(HashMap.Entry<VAT,Double> e : podsumy.entrySet()){
			if(e.getValue()>0)
				faktura += String.format("%-15s: %10.2f\n", "SUMA "+e.getKey().str, e.getValue());
		}
		faktura += String.format("%27s\n", "+ ----------");
		faktura += String.format("%-15s: %10.2f\n", "SUMA DO ZAP�ATY", sumaDoZaplaty);
		faktura += "---------------------------------------------\n";
		return faktura;
	}

}
