package cui;

import Verwaltungen.*;
import entities.Kunde;
import entities.Mitarbeiter;
import entities.Nutzer;

import java.util.Scanner;

public class HauptseiteCUI {
    private NutzerVerwaltung nutzerVerwaltung;
    private ArtikelVerwaltung artikelVerwaltung;
    private WarenkorbVerwaltung warenkorbVerwaltung;
    private RechnungsVerwaltung rechnungsVerwaltung;
    private EreignisVerwaltung ereignisVerwaltung;
    private Scanner scanner;

    public HauptseiteCUI(NutzerVerwaltung nutzerVerwaltung, ArtikelVerwaltung artikelVerwaltung, WarenkorbVerwaltung warenkorbVerwaltung, RechnungsVerwaltung rechnungsVerwaltung, EreignisVerwaltung ereignisVerwaltung, Scanner scanner) {
        this.nutzerVerwaltung = nutzerVerwaltung;
        this.artikelVerwaltung = artikelVerwaltung;
        this.warenkorbVerwaltung = warenkorbVerwaltung;
        this.rechnungsVerwaltung = rechnungsVerwaltung;
        this.ereignisVerwaltung = ereignisVerwaltung;
        this.scanner = scanner;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Willkommen beim E-Shop!");
            System.out.println("1. Anmelden");
            System.out.println("2. Registrieren");
            System.out.println("3. Beenden");
            System.out.print("Bitte wählen Sie eine Option: ");

            int auswahl = scanner.nextInt();
            scanner.nextLine();
            switch (auswahl) {
                case 1:
                    anmelden();
                    break;
                case 2:
                    registrieren();
                    break;
                case 3:
                    System.out.println("Danke für Ihren Besuch.");
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                    break;
            }
        }
    }

    private void anmelden() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie Ihre E-Mail ein: ");
        String email = scanner.nextLine();
        System.out.print("Bitte geben Sie Ihr Passwort ein: ");
        String passwort = scanner.nextLine();

        Nutzer nutzer = nutzerVerwaltung.anmelden(email, passwort);
        if (nutzer != null) {
            if (nutzer instanceof Kunde) {
                KundenMenu kundenMenu = new KundenMenu(artikelVerwaltung, warenkorbVerwaltung, rechnungsVerwaltung, ereignisVerwaltung);
                kundenMenu.start((Kunde) nutzer, scanner);
            } else if (nutzer instanceof Mitarbeiter) {
                MitarbeiterMenu mitarbeiterMenu = new MitarbeiterMenu(artikelVerwaltung, nutzerVerwaltung, ereignisVerwaltung);
                mitarbeiterMenu.start((Mitarbeiter) nutzer, scanner);
            }
        } else {
            System.out.println("Anmeldung fehlgeschlagen. Überprüfen Sie Ihre Eingaben.");
        }
    }

    private void registrieren() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte geben Sie Ihren Namen ein: ");
        String name = scanner.nextLine();
        System.out.print("Bitte geben Sie Ihre E-Mail ein: ");
        String email = scanner.nextLine();
        System.out.print("Bitte geben Sie Ihr Passwort ein: ");
        String passwort = scanner.nextLine();
        System.out.print("Bitte geben Sie Ihre Straße ein: ");
        String strasse = scanner.nextLine();
        System.out.print("Bitte geben Sie Ihre PLZ ein: ");
        String plz = scanner.nextLine();
        System.out.print("Bitte geben Sie Ihren Wohnort ein: ");
        String wohnort = scanner.nextLine();
        nutzerVerwaltung.kundeRegistrieren(name, email, passwort, strasse, plz, wohnort);
    }
}