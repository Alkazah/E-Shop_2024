package cui;

import Verwaltungen.ArtikelVerwaltung;
import Verwaltungen.EreignisVerwaltung;
import Verwaltungen.RechnungsVerwaltung;
import Verwaltungen.WarenkorbVerwaltung;
import entities.Artikel;
import entities.Kunde;
import entities.Rechnung;
import entities.Warenkorb;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

public class KundenMenu {
    private ArtikelVerwaltung artikelVerwaltung;
    private WarenkorbVerwaltung warenkorbVerwaltung;
    private RechnungsVerwaltung rechnungsVerwaltung;
    private EreignisVerwaltung ereignisVerwaltung;
    private Warenkorb warenkorb;

    public KundenMenu(ArtikelVerwaltung artikelVerwaltung, WarenkorbVerwaltung warenkorbVerwaltung, RechnungsVerwaltung rechnungsVerwaltung, EreignisVerwaltung ereignisVerwaltung) {
        this.artikelVerwaltung = artikelVerwaltung;
        this.warenkorbVerwaltung = warenkorbVerwaltung;
        this.rechnungsVerwaltung = rechnungsVerwaltung;
        this.ereignisVerwaltung = ereignisVerwaltung;
    }

    public void start(Kunde kunde, Scanner scanner) {
        this.warenkorb = warenkorbVerwaltung.erstelleWarenkorb(kunde);
        boolean running = true;

        while (running) {
            System.out.println("Willkommen, " + kunde.getName() + "! Was möchten Sie tun?");
            System.out.println("1. Produkte anzeigen");
            System.out.println("2. Warenkorb anzeigen");
            System.out.println("3. Bestellung aufgeben");
            System.out.println("4. Logout");
            System.out.print("Bitte wählen Sie eine Option: ");
            int auswahl = scanner.nextInt();
            scanner.nextLine(); // Liest den restlichen Zeilenumbruch

            switch (auswahl) {
                case 1:
                    produkteAnzeigen(scanner, kunde);
                    break;
                case 2:
                    warenkorbAnzeigen(scanner, kunde);
                    break;
                case 3:
                    bestellungAufgeben(kunde);
                    break;
                case 4:
                    System.out.println("Sie haben sich ausgeloggt.");
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
                    break;
            }
        }
    }

    private void produkteAnzeigen(Scanner scanner, Kunde kunde) {
        List<Artikel> artikelListe = artikelVerwaltung.getAlleArtikel();
        System.out.println("Verfügbare Produkte:");
        for (Artikel artikel : artikelListe) {
            System.out.println(artikel);
        }
        System.out.println("Möchten Sie einen Artikel zum Warenkorb hinzufügen? (ja/nein)");
        String antwort = scanner.nextLine();
        if (antwort.equalsIgnoreCase("ja")) {
            System.out.print("Artikelname: ");
            String artikelName = scanner.nextLine();
            System.out.print("Menge: ");
            int menge = scanner.nextInt();
            scanner.nextLine();
            warenkorbVerwaltung.artikelZumWarenkorbHinzufuegen(kunde, artikelVerwaltung.artikelSuchen(artikelName), menge);
        }
    }

    private void warenkorbAnzeigen(Scanner scanner, Kunde kunde) {
        if (!warenkorb.getArtikel().isEmpty()) {
            System.out.println("Ihr Warenkorb:");
            System.out.println(warenkorb);
            System.out.println("Möchten Sie Artikel entfernen? (ja/nein)");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                System.out.print("Artikelname: ");
                String artikelName = scanner.nextLine();
                System.out.print("Menge zum Entfernen: ");
                int menge = scanner.nextInt();
                scanner.nextLine(); // Liest den restlichen Zeilenumbruch
                Artikel artikel = artikelVerwaltung.artikelSuchen(artikelName);
                if (artikel != null) {
                    warenkorbVerwaltung.artikelAusWarenkorbEntfernen(kunde, artikel, menge);
                    System.out.println("Artikel entfernt.");
                } else {
                    System.out.println("Artikel nicht gefunden.");
                }
            }
        } else {
            System.out.println("Ihr Warenkorb ist leer.");
            System.out.println("Möchten Sie Produkte hinzufügen? (ja/nein)");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                produkteAnzeigen(scanner, kunde);
            }
        }
    }

    private void bestellungAufgeben(Kunde kunde) {
        if (!warenkorb.getArtikel().isEmpty()) {
            Rechnung neueRechnung = new Rechnung(kunde, new java.util.Date(), new ArrayList<>(warenkorb.getArtikel().keySet()), warenkorb.getGesamtpreis());
            rechnungsVerwaltung.rechnungErstellen(kunde, neueRechnung.getDatum(), new ArrayList<>(warenkorb.getArtikel().keySet()), neueRechnung.getGesamtpreis());
            // Artikel aus dem Bestand auslagern und Ereignisse protokollieren
            warenkorb.getArtikel().forEach((artikel, menge) -> {
                artikel.setBestand(artikel.getBestand() - menge);  // Bestand reduzieren
                ereignisVerwaltung.ereignisHinzufuegen(new java.util.Date(), "Auslagern: " + menge + " Stück von " + artikel.getBezeichnung(), kunde);  // Ereignis protokollieren
            });

            // Warenkorb leeren nach der Bestellung
            warenkorb.warenkorbLeeren(); // Warenkorb leeren
            System.out.println("Ihre Bestellung wurde aufgegeben: " + neueRechnung);
        } else {
            System.out.println("Ihr Warenkorb ist leer.");
        }
    }
}


