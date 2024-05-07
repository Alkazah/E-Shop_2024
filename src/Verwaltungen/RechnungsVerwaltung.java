package Verwaltungen;

import entities.Artikel;
import entities.Kunde;
import entities.Rechnung;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RechnungsVerwaltung {
    private List<Rechnung> rechnungen;

    public RechnungsVerwaltung() {
        this.rechnungen = new ArrayList<>();
    }

    // Erstellt eine neue Rechnung und fügt sie der Liste der Rechnungen hinzu
    public void rechnungErstellen(Kunde kunde, Date datum, List<Artikel> gekaufteArtikel, double gesamtpreis) {
        Rechnung neueRechnung = new Rechnung(kunde, datum, gekaufteArtikel, gesamtpreis);
        rechnungen.add(neueRechnung);
        System.out.println("Neue Rechnung erstellt: " + neueRechnung);
    }

    // Gibt alle Rechnungen zurück
    public List<Rechnung> getAlleRechnungen() {
        return new ArrayList<>(rechnungen);
    }

    // Gibt alle Rechnungen für einen bestimmten Kunden zurück
    public List<Rechnung> getRechnungenFuerKunden(Kunde kunde) {
        return rechnungen.stream()
                .filter(rechnung -> rechnung.getKunde().equals(kunde))
                .collect(Collectors.toList());
    }

    // Gibt Rechnungen basierend auf dem Datum zurück
    public List<Rechnung> getRechnungenNachDatum(Date datum) {
        return rechnungen.stream()
                .filter(rechnung -> rechnung.getDatum().equals(datum))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Alle Rechnungen:\n");
        for (Rechnung rechnung : rechnungen) {
            sb.append(rechnung).append("\n");
        }
        return sb.toString();
    }
}