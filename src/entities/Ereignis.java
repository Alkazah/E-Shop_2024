package entities;

import java.util.Date;

public class Ereignis {
    private static int nextEreignisNr = 1;
    private int ereignisNr;
    private Date datum;
    private String beschreibung;
    private Nutzer beteiligter;

    public Ereignis(int ereignisNr, Date datum, String beschreibung, Nutzer beteiligter) {
        this.ereignisNr = ereignisNr;
        this.datum = datum;
        this.beschreibung = beschreibung;
        this.beteiligter = beteiligter;
    }

    public Ereignis(Date datum, String beschreibung, Nutzer beteiligter) {
        this.ereignisNr = nextEreignisNr++;
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