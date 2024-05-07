package cui;

import Verwaltungen.*;

import java.util.Scanner;

public class Hauptklasse {

    public static void main(String[] args) {
        NutzerVerwaltung nutzerVerwaltung = new NutzerVerwaltung();
        ArtikelVerwaltung artikelVerwaltung = new ArtikelVerwaltung();
        WarenkorbVerwaltung warenkorbVerwaltung = new WarenkorbVerwaltung();
        RechnungsVerwaltung rechnungsVerwaltung = new RechnungsVerwaltung();
        EreignisVerwaltung ereignisVerwaltung = new EreignisVerwaltung();
        initialisiereDaten(nutzerVerwaltung, artikelVerwaltung);

        Scanner scanner = new Scanner(System.in);
        HauptseiteCUI hauptseiteCUI = new HauptseiteCUI(nutzerVerwaltung, artikelVerwaltung, warenkorbVerwaltung, rechnungsVerwaltung, ereignisVerwaltung, scanner);
        hauptseiteCUI.start();
        scanner.close();
    }

    private static void initialisiereDaten(NutzerVerwaltung nutzerVerwaltung, ArtikelVerwaltung artikelVerwaltung) {
        // Erstellen von Mitarbeitern
        nutzerVerwaltung.mitarbeiterRegistrieren("Alkazah", "Alkazah.com", "123");
        nutzerVerwaltung.mitarbeiterRegistrieren("Joud", "Joud.com", "123");
        nutzerVerwaltung.kundeRegistrieren("Kunde", "Kunde.com", "123", "KundenStraße 15", "28222", "Bremen");

        // Erstellen von Artikeln
        artikelVerwaltung.artikelHinzufuegen("Laptop", 50, 999.99);
        artikelVerwaltung.artikelHinzufuegen("Smartphone", 102, 599.99);
        artikelVerwaltung.artikelHinzufuegen("Kopfhörer", 230, 60.99);
        artikelVerwaltung.artikelHinzufuegen("Tastatur", 143, 78.99);
        artikelVerwaltung.artikelHinzufuegen("Maus", 315, 15.99);
    }
}
