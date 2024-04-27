import javax.swing.*;

public class Artikel {

    public static void main(String[] args) {

    }

    private int artikelnummer;
    private int bestand = 0;
    private String bezeichnung = "";
    private double preis = 0.0;

    public Artikel(int artikelnummer, int bestand, String bezeichnung, float preis) {
        this.artikelnummer = artikelnummer;
        this.bestand = bestand;
        this.bezeichnung = bezeichnung;
        this.preis = preis;
    }

    public int getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(int artikelnummer) {
        this.artikelnummer = artikelnummer;
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
}
