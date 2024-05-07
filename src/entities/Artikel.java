package entities;

import javax.swing.*;

public class Artikel {
    private int artikelNr;
    private String bezeichnung = "";
    private int bestand = 0;
    private double preis = 0.0;

    public Artikel(int artikelNr, String bezeichnung, int bestand,  double preis) {
        this.artikelNr = artikelNr;
        this.bezeichnung = bezeichnung;
        this.bestand = bestand;
        this.preis = preis;
    }

    public Artikel(String bezeichnung, int bestand, double preis) {
        this.bezeichnung = bezeichnung;
        this.bestand = bestand;
        this.preis = preis;
    }

    public int getArtikelNr() {
        return artikelNr;
    }

    public void setArtikelNr(int artikelnummer) {
        this.artikelNr = artikelnummer;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String toString() {
        return "ArtikelNr: " + artikelNr + ", Bezeichnung: " + bezeichnung +
                ", Der aktuelle Bestand ist: " + bestand + ", Preis: " + preis;
    }
}
