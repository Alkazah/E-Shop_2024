package Verwaltungen;

import entities.Artikel;
import entities.Nutzer;

import java.util.ArrayList;
import java.util.List;

public class ArtikelVerwaltung {
    private List<Artikel> artikelListe;

    public ArtikelVerwaltung() {
        this.artikelListe = new ArrayList<>();
    }

    // Artikel hinzufügen (nur von Mitarbeitern ausführbar)
    public void artikelHinzufuegen(int artikelNr, int bestand, String bezeichnung, double preis, Nutzer nutzer) {
        if (nutzer.istMitarbeiter()) {
            Artikel neuerArtikel = new Artikel(artikelNr, bestand, bezeichnung, preis);
            artikelListe.add(neuerArtikel);
            System.out.println("Artikel hinzugefügt: " + neuerArtikel);
        } else {
            System.out.println("Zugriff verweigert: Nur Mitarbeiter dürfen Artikel hinzufügen.");
        }
    }

    // Artikel entfernen (nur von Mitarbeitern ausführbar)
    public void artikelEntfernen(int artikelNr, Nutzer nutzer) {
        if (nutzer.istMitarbeiter()) {
            Artikel artikelZumEntfernen = artikelSuchen(artikelNr);
            if (artikelZumEntfernen != null) {
                artikelListe.remove(artikelZumEntfernen);
                System.out.println("Artikel entfernt: " + artikelZumEntfernen);
            } else {
                System.out.println("Artikel nicht gefunden.");
            }
        } else {
            System.out.println("Zugriff verweigert: Nur Mitarbeiter dürfen Artikel entfernen.");
        }
    }

    // Bestand eines Artikels aktualisieren (nur von Mitarbeitern ausführbar)
    public void bestandAktualisieren(int artikelNr, int neuerBestand, Nutzer nutzer) {
        if (nutzer.istMitarbeiter()) {
            Artikel artikel = artikelSuchen(artikelNr);
            if (artikel != null) {
                artikel.setBestand(neuerBestand);
                System.out.println("Bestand aktualisiert: " + artikel);
            } else {
                System.out.println("Artikel nicht gefunden.");
            }
        } else {
            System.out.println("Zugriff verweigert: Nur Mitarbeiter dürfen den Bestand aktualisieren.");
        }
    }

    // Artikel nach Artikelnummer suchen
    private Artikel artikelSuchen(int artikelNr) {
        for (Artikel artikel : artikelListe) {
            if (artikel.getArtikelNr() == artikelNr) {
                return artikel;
            }
        }
        return null;
    }

    // Alle Artikel auflisten
    public List<Artikel> getAlleArtikel() {
        return new ArrayList<>(artikelListe);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Alle Artikel:\n");
        for (Artikel artikel : artikelListe) {
            sb.append(artikel).append("\n");
        }
        return sb.toString();
    }
}

