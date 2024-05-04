package entities;

import java.util.Date;
import java.util.List;

public class Rechnung {
    private int bestellNr;
    private Kunde kunde;
    private Date datum;
    private List<Artikel> gekaufteArtikel;
    private double gesamtpreis;

    public Rechnung(int bestellNr, Kunde kunde, Date datum, List<Artikel> gekaufteArtikel, double gesamtpreis) {
        this.bestellNr = bestellNr;
        this.kunde = kunde;
        this.datum = datum;
        this.gekaufteArtikel = gekaufteArtikel;
        this.gesamtpreis = gesamtpreis;
    }

    public int getBestellNr() {
        return bestellNr;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public Date getDatum() {
        return datum;
    }

    public List<Artikel> getGekaufteArtikel() {
        return gekaufteArtikel;
    }

    public double getGesamtpreis() {
        return gesamtpreis;
    }

    @Override
    public String toString() {
        return "BestellNr: " + bestellNr + ", Kunde: " + kunde.getName() +
                ", Datum: " + datum + ", Gesamtpreis: " + gesamtpreis;
    }
}