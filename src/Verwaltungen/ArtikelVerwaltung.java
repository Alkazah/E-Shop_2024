package Verwaltungen;

import entities.Artikel;

import java.util.ArrayList;
import java.util.List;

public class ArtikelVerwaltung {
    private List<Artikel> artikelListe;

    public ArtikelVerwaltung() {
        this.artikelListe = new ArrayList<>();
    }

    // Artikel hinzufügen
    public void artikelHinzufuegen(String bezeichnung, int bestand, double preis) {
        Artikel neuerArtikel = new Artikel(bezeichnung, bestand, preis);
        artikelListe.add(neuerArtikel);
        System.out.println("Artikel hinzugefügt: " + neuerArtikel);
    }

    // Artikel entfernen
    public void artikelEntfernen(String Bezeichnung) {
        Artikel artikelZumEntfernen = artikelSuchen(Bezeichnung);
        if (artikelZumEntfernen != null) {
            artikelListe.remove(artikelZumEntfernen);
            System.out.println("Artikel entfernt: " + artikelZumEntfernen);
        } else {
            System.out.println("Artikel nicht gefunden.");
        }
    }

    // Bestand eines Artikels aktualisieren
    public void bestandAktualisieren(String Bezeichnung, int neuerBestand) {
        Artikel artikel = artikelSuchen(Bezeichnung);
        if (artikel != null) {
            artikel.setBestand(neuerBestand);
            System.out.println("Bestand aktualisiert: " + artikel);
        } else {
            System.out.println("Artikel nicht gefunden.");
        }
    }

    // Artikel nach Artikelname suchen
    public Artikel artikelSuchen(String bezeichnung) {
        for (Artikel artikel : artikelListe) {
            if (artikel.getBezeichnung().equalsIgnoreCase(bezeichnung)) {
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