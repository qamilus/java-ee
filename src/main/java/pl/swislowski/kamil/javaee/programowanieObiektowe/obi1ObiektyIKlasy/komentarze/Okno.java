package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.komentarze;

public class Okno {
	// Ponieżej znajduje się deklaracja pól/atrybutów prywatnych, które są dostępne tylko w ramach klasy.
	// Pola są typu int i tablica obiektów Skrzydło.
	private int dlugosc;
	private int wysokosc;
	private int liczbaSkrzydel;
	private Skrzydlo[] skrzydla;

	// Konstruktor z argumentami ustawiający wartość pól/atrybutów w klasie.
	public Okno(int d, int w, int lSkrzydel){
		dlugosc = d;
		wysokosc = w;
		liczbaSkrzydel = lSkrzydel;
		skrzydla = new Skrzydlo[lSkrzydel];
		for(int i=0;i<lSkrzydel;i++){
			skrzydla[i] = new Skrzydlo(d/lSkrzydel,w, new Klamka());
		}
	}
	// Konstruktor z argumentami ustawiający wartość pól/atrybutów w klasie.
	public Okno(int d, int w, Skrzydlo[] sk){
		dlugosc = d;
		wysokosc = w;
		liczbaSkrzydel = sk.length;
		skrzydla = sk;
	}
//	Konstruktor z argumentami ustawiający wartość pól/atrybutów w klasie.
	public Okno(int d, int w){
		this(d,w,1);
	}	
	public Okno(){
		this(1200,1500,1);
	}

	// Metoda pobierająca wartość pola czyKluczyk.
	public int getDlugosc() {
		return dlugosc;
	}
	//Metoda ustawiająca wartość.
	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
		for(int i=0;i<liczbaSkrzydel;i++){
			skrzydla[i].setDlugosc(dlugosc/liczbaSkrzydel);
		}
	}
	// Metoda pobierająca wartość pola czyKluczyk.
	public int getWysokosc() {
		return wysokosc;
	}
	//Metoda ustawiająca wartość.
	public void setWysokosc(int wysokosc) {
		this.wysokosc = wysokosc;
		for(int i=0;i<liczbaSkrzydel;i++){
			skrzydla[i].setWysokosc(wysokosc);
		}
	}
	// Metoda pobierająca wartość pola czyKluczyk.
	public int getLiczbaSkrzydel() {
		return liczbaSkrzydel;
	}
	// Metoda pobierająca wartość pola czyKluczyk.
	public Skrzydlo[] getSkrzydla() {
		return skrzydla;
	}


	// Metody zawierające kod operujący na polach/atrybutach w klasie.
	public void otworz(){
		for(int i=0;i<liczbaSkrzydel;i++){
			skrzydla[i].setOtwarte(true);
		}
	}
	// Metody zawierające kod operujący na polach/atrybutach w klasie.
	public void otworz(int nrSkrzydla){
		if(nrSkrzydla > skrzydla.length) return;
		
		skrzydla[nrSkrzydla].setOtwarte(true);
		
	}
	// Metody zawierające kod operujący na polach/atrybutach w klasie.
	public void zamknij(){
		for(int i=0;i<liczbaSkrzydel;i++){
			skrzydla[i].setOtwarte(false);
		}
	}
	// Metody zawierające kod operujący na polach/atrybutach w klasie.
	public void zamknij(int nrSkrzydla){
		if(nrSkrzydla > skrzydla.length) return;
		
		skrzydla[nrSkrzydla].setOtwarte(false);
		
	}
	// Metody zawierające kod operujący na polach/atrybutach w klasie.
	public void wypiszStan() {
		String tekst = "";
		for(int i=0;i<liczbaSkrzydel;i++){
			tekst += "["+skrzydla[i].stan()+"]";
		}
		System.out.println(tekst);
		
	}
	
}
