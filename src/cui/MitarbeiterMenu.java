package cui;

import Verwaltungen.ArtikelVerwaltung;
import Verwaltungen.EreignisVerwaltung;
import Verwaltungen.NutzerVerwaltung;
import entities.Artikel;
import entities.Mitarbeiter;

import java.util.Scanner;

public class MitarbeiterMenu {
    private ArtikelVerwaltung artikelVerwaltung;
    private NutzerVerwaltung nutzerVerwaltung;
    private EreignisVerwaltung ereignisVerwaltung;

    public MitarbeiterMenu(ArtikelVerwaltung artikelVerwaltung, NutzerVerwaltung nutzerVerwaltung, EreignisVerwaltung ereignisVerwaltung) {
        this.artikelVerwaltung = artikelVerwaltung;
        this.nutzerVerwaltung = nutzerVerwaltung;
        this.ereignisVerwaltung = ereignisVerwaltung;
    }

    public void start(Mitarbeiter mitarbeiter, Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Willkommen, " + mitarbeiter.getName() + "! Was möchten Sie tun?");
            System.out.println("1. Lagerbestand verwalten");
            System.out.println("2. Produkt hinzufügen");
            System.out.println("3. Produkt entfernen");
            System.out.println("4. Mitarbeiter registrieren");
            System.out.println("5. Logout");
            System.out.print("Bitte wählen Sie eine Option: ");
            int auswahl = scanner.nextInt();
            scanner.nextLine(); // Konsumiere den Zeilenumbruch nach der Zahleneingabe

            switch (auswahl) {
                case 1:
                    lagerbestandVerwalten(scanner, mitarbeiter);
                    break;
                case 2:
                    produktHinzufuegen(scanner, mitarbeiter);
                    break;
                case 3:
                    produktEntfernen(scanner, mitarbeiter);
                    break;
                case 4:
                    mitarbeiterRegistrieren(scanner);
                    break;
                case 5:
                    System.out.println("Sie haben sich ausgeloggt.");
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
                    break;
            }
        }
    }

    private void lagerbestandVerwalten(Scanner scanner, Mitarbeiter mitarbeiter) {
        System.out.print("Artikelname eingeben: ");
        String artikelName = scanner.nextLine();
        System.out.print("Neuer Bestand: ");
        int bestand = scanner.nextInt();
        scanner.nextLine(); // Konsumiere den Zeilenumbruch

        Artikel artikel = artikelVerwaltung.artikelSuchen(artikelName);
        if (artikel != null) {
            int alterBestand = artikel.getBestand();
            artikel.setBestand(bestand);
            String beschreibung = bestand > alterBestand ? "Einlagern" : "Auslagern";
            ereignisVerwaltung.ereignisHinzufuegen(new java.util.Date(), beschreibung + ": " + Math.abs(bestand - alterBestand) + " Stück von Artikel " + artikelName, mitarbeiter);
            System.out.println("Lagerbestand aktualisiert.");
        } else {
            System.out.println("Artikel nicht gefunden.");
        }
    }

    private void produktHinzufuegen(Scanner scanner, Mitarbeiter mitarbeiter) {
        System.out.print("Artikel Bezeichnung: ");
        String bezeichnung = scanner.nextLine();
        System.out.print("Startbestand: ");
        int bestand = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Preis: ");
        double preis = scanner.nextDouble();
        scanner.nextLine(); // Konsumiere den Zeilenumbruch

        artikelVerwaltung.artikelHinzufuegen(bezeichnung, bestand, preis);
        ereignisVerwaltung.ereignisHinzufuegen(new java.util.Date(), "Neuer Artikel angelegt: " + bezeichnung, mitarbeiter);
        System.out.println("Artikel erfolgreich hinzugefügt.");
    }

    private void produktEntfernen(Scanner scanner, Mitarbeiter mitarbeiter) {
        System.out.print("Artikelname eingeben: ");
        String bezeichnung = scanner.nextLine();
        scanner.nextLine(); // Konsumiere den Zeilenumbruch

        Artikel artikel = artikelVerwaltung.artikelSuchen(bezeichnung);
        if (artikel != null) {
            artikelVerwaltung.artikelEntfernen(bezeichnung);
            ereignisVerwaltung.ereignisHinzufuegen(new java.util.Date(), "Artikel entfernt: " + bezeichnung, mitarbeiter);
            System.out.println("Artikel erfolgreich entfernt.");
        } else {
            System.out.println("Artikel nicht gefunden.");
        }
    }

    private void mitarbeiterRegistrieren(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("E-Mail: ");
        String email = scanner.nextLine();
        System.out.print("Passwort: ");
        String passwort = scanner.nextLine();

        nutzerVerwaltung.mitarbeiterRegistrieren(name, email, passwort);
        System.out.println("Mitarbeiter erfolgreich registriert.");
    }
}
