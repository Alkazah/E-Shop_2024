package cui;

import Verwaltungen.NutzerVerwaltung;
import entities.Nutzer;

import java.util.Scanner;

public class HauptseiteCUI {
    private NutzerVerwaltung nutzerVerwaltung;

    public HauptseiteCUI(NutzerVerwaltung nutzerVerwaltung) {
        this.nutzerVerwaltung = nutzerVerwaltung;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Willkommen beim E-Shop!");
            System.out.println("1. Anmelden");
            System.out.println("2. Registrieren");
            System.out.println("3. Beenden");
            System.out.print("Bitte wählen Sie eine Option: ");

            int auswahl = scanner.nextInt();
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
        scanner.close();
    }

    private void anmelden() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bitte geben Sie Ihre E-Mail ein: ");
        String email = scanner.nextLine();
        System.out.print("Bitte geben Sie Ihr Passwort ein: ");
        String passwort = scanner.nextLine();

        Nutzer nutzer = nutzerVerwaltung.anmelden(email, passwort);
        if (nutzer != null) {
            System.out.println("Anmeldung erfolgreich! Willkommen zurück, " + nutzer.getName() + ".");
            // Weiterleitung zu weiteren Funktionen je nach Nutzerart könnte hier implementiert werden
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
        nutzerVerwaltung.registriereNutzer(name, email, passwort, strasse, plz, wohnort);
    }

    public static void main(String[] args) {
        NutzerVerwaltung nutzerVerwaltung = new NutzerVerwaltung(); // Diese sollte mit echten Daten initialisiert werden
        HauptseiteCUI cui = new HauptseiteCUI(nutzerVerwaltung);
        cui.start();
    }
}