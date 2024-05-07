package entities;

import java.util.HashMap;
import java.util.Map;

public class Warenkorb {
    private Nutzer besitzer;  // Der Nutzer, dem der Warenkorb gehört
    private Map<Artikel, Integer> artikel; // Speichert Artikel und deren Mengen
    private double gesamtpreis; // Gesamtpreis aller Artikel im Warenkorb

    public Warenkorb(Nutzer besitzer) {
        this.besitzer = besitzer;
        this.artikel = new HashMap<>();
        this.gesamtpreis = 0.0;
    }

    // Fügt einen Artikel und die gewünschte Menge zum Warenkorb hinzu
    public void artikelHinzufuegen(Artikel artikel, int menge) {
        // Checkt, ob genug Artikels im Lager gibt
        if(artikel.getBestand() < this.artikel.getOrDefault(artikel, 0) + menge){
            System.out.println("Im Lager sind nur noch " + artikel.getBestand() + " " + artikel.getBezeichnung() + " verfügbar.");
            return;
        }
        this.artikel.put(artikel, this.artikel.getOrDefault(artikel, 0) + menge);
        updateGesamtpreis(); // Aktualisiert den Gesamtpreis nach der Änderung
    }

    // Entfernt eine spezifizierte Menge eines Artikels aus dem Warenkorb
    public void artikelEntfernen(Artikel artikel, int menge) {
        int aktuelleMenge = this.artikel.getOrDefault(artikel, 0);
        if (aktuelleMenge <= menge) {
            this.artikel.remove(artikel);
        } else {
            this.artikel.put(artikel, aktuelleMenge - menge);
        }
        updateGesamtpreis(); // Aktualisiert den Gesamtpreis nach der Änderung
    }

    // Berechnet den Gesamtpreis aller Artikel im Warenkorb basierend auf ihrer Menge und dem Einzelpreis
    private void updateGesamtpreis() {
        double neuerGesamtpreis = 0.0;
        for (Map.Entry<Artikel, Integer> entry : this.artikel.entrySet()) {
            neuerGesamtpreis += entry.getKey().getPreis() * entry.getValue();
        }
        this.gesamtpreis = neuerGesamtpreis;
    }

    public Map<Artikel, Integer> getArtikel() {
        return artikel;
    }

    public Nutzer getBesitzer() {
        return besitzer;
    }

    public double getGesamtpreis(){
        return gesamtpreis;
    }

    // Methode zum Leeren des Warenkorbs
    public void warenkorbLeeren() {
        artikel.clear();  // Entfernt alle Einträge in der Map
        gesamtpreis = 0.0; // Setzt den Gesamtpreis zurück
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Warenkorb von " + besitzer.getName() + ":\n");
        for (Map.Entry<Artikel, Integer> entry : artikel.entrySet()) {
            sb.append(entry.getKey().getBezeichnung())
                    .append(" - Menge: ")
                    .append(entry.getValue())
                    .append(" - Einzelpreis: ")
                    .append(entry.getKey().getPreis())
                    .append(" - Gesamtpreis: ")
                    .append(entry.getKey().getPreis() * entry.getValue())
                    .append("\n");
        }
        sb.append("Gesamtpreis des Warenkorbs: ").append(gesamtpreis);
        return sb.toString();
    }
}