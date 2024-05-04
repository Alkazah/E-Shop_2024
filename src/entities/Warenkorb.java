package entities;

import java.util.HashMap;
import java.util.Map;

public class Warenkorb {
    private Nutzer besitzer;  // Der Nutzer, dem der Warenkorb gehört
    private Map<Artikel, Integer> artikel; // Speichert Artikel und deren Mengen
    private double gesamtpreis;

    public Warenkorb(Nutzer besitzer) {
        this.besitzer = besitzer;
        this.artikel = new HashMap<>();
        this.gesamtpreis = 0.0;
    }

    public void artikelHinzufuegen(Artikel artikel, int menge) {
        this.artikel.put(artikel, this.artikel.getOrDefault(artikel, 0) + menge);
        updateGesamtpreis();
    }

    public void artikelEntfernen(Artikel artikel, int menge) {
        int aktuelleMenge = this.artikel.getOrDefault(artikel, 0);
        if (aktuelleMenge <= menge) {
            this.artikel.remove(artikel);
        } else {
            this.artikel.put(artikel, aktuelleMenge - menge);
        }
        updateGesamtpreis();
    }

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

