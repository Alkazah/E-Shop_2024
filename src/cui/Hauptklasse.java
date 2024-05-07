package cui;

import Verwaltungen.ArtikelVerwaltung;
import Verwaltungen.NutzerVerwaltung;

public class Hauptklasse {

    public static void main(String[] args) {
        NutzerVerwaltung nutzerVerwaltung = new NutzerVerwaltung();
        ArtikelVerwaltung artikelVerwaltung = new ArtikelVerwaltung();
        initialisiereDaten(nutzerVerwaltung, artikelVerwaltung);

        HauptseiteCUI cui = new HauptseiteCUI(nutzerVerwaltung);
        cui.start();
    }

    private static void initialisiereDaten(NutzerVerwaltung nutzerVerwaltung, ArtikelVerwaltung artikelVerwaltung) {
        // Erstellen von Mitarbeitern
        nutzerVerwaltung.registriereNutzer("Alkazah", "Alkazah.com", "123");
        nutzerVerwaltung.registriereNutzer("Joud", "Joud.com", "123");

        // Erstellen von Artikeln
        artikelVerwaltung.artikelHinzufuegen("Laptop", 50, 999.99);
        artikelVerwaltung.artikelHinzufuegen("Smartphone", 102, 599.99);
    }
}
