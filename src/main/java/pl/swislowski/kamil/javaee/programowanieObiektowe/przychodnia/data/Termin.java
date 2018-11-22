package pl.swislowski.kamil.javaee.programowanieObiektowe.przychodnia.data;

import java.time.LocalDateTime;

public class Termin {
    private Pacjent pacjent;
    private Lekarz lekarz;
    private LocalDateTime dataGodzina;
    private StatusTerminu statusTerminu = StatusTerminu.WOLNY;   // getter setter i podczas rezerwacji wizyty zmieniamy status na zarezerowowana, a przy tworzeniu terminu dodajemy status wolny.


    public Termin(Lekarz lekarz, LocalDateTime dataGodzina) {
        this.lekarz = lekarz;
        this.dataGodzina = dataGodzina;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
    }

    public Lekarz getLekarz() {
        return lekarz;
    }

    public void setLekarz(Lekarz lekarz) {
        this.lekarz = lekarz;
    }

    public LocalDateTime getDataGodzina() {
        return dataGodzina;
    }

    public void setDataGodzina(LocalDateTime dataGodzina) {
        this.dataGodzina = dataGodzina;
    }

    public StatusTerminu getStatusTerminu() {
        return statusTerminu;
    }

    public void setStatusTerminu(StatusTerminu statusTerminu) {
        this.statusTerminu = statusTerminu;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "pacjent=" + pacjent +
                ", lekarz=" + lekarz +
                ", dataGodzina=" + dataGodzina +
                ", statusTerminu=" + statusTerminu +
                '}';
    }
}
