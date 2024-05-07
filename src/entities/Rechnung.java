package entities;

import java.util.Date;
import java.util.List;

public class Rechnung {
    private static int nextRechnungNr = 1;
    private int rechnungNr;
    private Kunde kunde;
    private Date datum;
    private List<Artikel> gekaufteArtikel;
    private double gesamtpreis;

    public Rechnung(int rechnungNr, Kunde kunde, Date datum, List<Artikel> gekaufteArtikel, double gesamtpreis) {
        this.rechnungNr = rechnungNr;
        this.kunde = kunde;
        this.datum = datum;
        this.gekaufteArtikel = gekaufteArtikel;
        this.gesamtpreis = gesamtpreis;
    }

    public Rechnung(Kunde kunde, Date datum, List<Artikel> gekaufteArtikel, double gesamtpreis) {
        this.rechnungNr = nextRechnungNr++;
        this.kunde = kunde;
        this.datum = datum;
        this.gekaufteArtikel = gekaufteArtikel;
        this.gesamtpreis = gesamtpreis;
    }

    public int getRechnungNr() {
        return rechnungNr;
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
        return "RechnungNr: " + rechnungNr + ", Kunde: " + kunde.getName() +
                ", Datum: " + datum + ", Gesamtpreis: " + gesamtpreis;
    }
}