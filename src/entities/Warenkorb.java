package entities;

import java.util.HashMap;
import java.util.Map;

public class Warenkorb {
    private Map<Artikel, Integer> artikelImWarenkorb;
    private String artikelBezeichnung = "";
    private int artikelAnzahl = 0;
    private double gesamtPreis = 0;

    public Warenkorb(String artikelBezeichnung, int artikelAnzahl, int gesamtPreis){
        this.artikelBezeichnung = artikelBezeichnung;
        this.artikelAnzahl = artikelAnzahl;
        this.gesamtPreis = gesamtPreis;
    }


    public void setArtikelBezeichnung(String artikelBezeichnung) {
        this.artikelBezeichnung = artikelBezeichnung;
    }

    public String getArtikelBezeichnung() {
        return artikelBezeichnung;
    }

    public void setArtikelAnzahl(int artikelAnzahl) {
        this.artikelAnzahl = artikelAnzahl;
    }

    public int getArtikelAnzahl() {
        return artikelAnzahl;
    }

    public void setGesamtPreis(double gesamtPreis) {
        this.gesamtPreis = gesamtPreis;
    }

    public double getGesamtPreis() {
        return gesamtPreis;
    }
}
