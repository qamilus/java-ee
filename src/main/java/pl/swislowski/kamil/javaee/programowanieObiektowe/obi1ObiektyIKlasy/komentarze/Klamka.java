package pl.swislowski.kamil.javaee.programowanieObiektowe.obi1ObiektyIKlasy.komentarze;

public class Klamka {
	// Deklaracja pola/atrybutu w klasie z inicjalizacją wartości. Pole czyKluczyk typu boolean.
	// Pole prywatne, może być zmienione tylko za pomocą metod dostępowych.
	private boolean czyKluczyk = false;
	// Metoda pobierająca wartość pola czyKluczyk.
	public boolean isCzyKluczyk() {
		return czyKluczyk;
	}
	//Metoda ustawiająca wartość.
	public void setCzyKluczyk(boolean czyKluczyk) {
		this.czyKluczyk = czyKluczyk;
	}
	//Metoda sprawdzająca stan, zawierająca warunek sprawdzający.
	// Warunek ? prawda : fałsz - ternary operator.
	public String stan() {
		return czyKluczyk ? "z kluczem": "bez klucza";
	}
}
