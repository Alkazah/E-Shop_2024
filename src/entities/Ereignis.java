package entities;

import java.util.Date;

public class Ereignis {
    private Date datum;
    private String beschreibung;
    private Nutzer beteiligter;

    public Ereignis(Date datum, String beschreibung, Nutzer beteiligter) {
        this.datum = datum;
        this.beschreibung = beschreibung;
        this.beteiligter = beteiligter;
    }

    public Date getDatum() {
        return datum;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public Nutzer getBeteiligter() {
        return beteiligter;
    }

    @Override
    public String toString() {
        return "Datum: " + datum + ", Beschreibung: " + beschreibung + ", Beteiligter: " + beteiligter.getName();
    }
}