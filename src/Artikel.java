import javax.swing.*;

public class Artikel {

    public static void main(String[] args) {

    }

    int artikelnummer;
    int bestand;
    String bezeichnung;
    float preis;

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

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }
}
