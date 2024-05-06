package Verwaltungen;

import entities.Artikel;
import entities.Ereignis;
import entities.Nutzer;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class EreignisVerwaltung {
    private List<Ereignis> ereignisse;

    public EreignisVerwaltung() {
        this.ereignisse = new ArrayList<>();
    }

    // Ereignis hinzufügen (allgemein)
    public void ereignisHinzufuegen(Date datum, String beschreibung, Nutzer beteiligter) {
        Ereignis neuesEreignis = new Ereignis(datum, beschreibung, beteiligter);
        ereignisse.add(neuesEreignis);
        System.out.println("Ereignis hinzugefügt: " + neuesEreignis);
    }

    // Artikel in das Lager einlagern
    public void einlagern(Artikel artikel, int menge, Nutzer nutzer) {
        if (nutzer.istMitarbeiter()) {
            artikel.setBestand(artikel.getBestand() + menge); // Bestand des Artikels aktualisieren
            ereignisHinzufuegen(new Date(), "Einlagern: " + menge + " Stück von " + artikel.getBezeichnung(), nutzer);
            System.out.println("Artikel eingelagert: " + menge + " Stück von " + artikel.getBezeichnung());
        } else {
            System.out.println("Zugriff verweigert: Nur Mitarbeiter dürfen Artikel einlagern.");
        }
    }

    // Artikel aus dem Lager auslagern
    public void auslagern(Artikel artikel, int menge, Nutzer nutzer) {
        if (nutzer.istMitarbeiter()) {
            if (artikel.getBestand() >= menge) {
                artikel.setBestand(artikel.getBestand() - menge); // Bestand des Artikels aktualisieren
                ereignisHinzufuegen(new Date(), "Auslagern: " + menge + " Stück von " + artikel.getBezeichnung(), nutzer);
                System.out.println("Artikel ausgelagert: " + menge + " Stück von " + artikel.getBezeichnung());
            } else {
                System.out.println("Nicht genügend Bestand vorhanden. Verfügbar: " + artikel.getBestand());
            }
        } else {
            System.out.println("Zugriff verweigert: Nur Mitarbeiter dürfen Artikel auslagern.");
        }
    }

    // Liste aller Ereignisse ausgeben
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Alle Ereignisse:\n");
        for (Ereignis e : ereignisse) {
            sb.append(e.toString()).append("\n");
        }
        return sb.toString();
    }
}

