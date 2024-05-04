package Verwaltungen;

import entities.Artikel;
import entities.Nutzer;
import entities.Warenkorb;

import java.util.HashMap;
import java.util.Map;

public class WarenkorbVerwaltung {
    private Map<Nutzer, Warenkorb> warenkoerbe; // Zuordnung von Nutzern zu ihren Warenkörben

    public WarenkorbVerwaltung() {
        this.warenkoerbe = new HashMap<>();
    }

    // Gibt den Warenkorb eines Nutzers zurück, falls vorhanden
    public Warenkorb getWarenkorb(Nutzer nutzer) {
        return warenkoerbe.get(nutzer);
    }

    // Erstellt einen neuen Warenkorb für einen Nutzer, falls noch nicht vorhanden
    public Warenkorb erstelleWarenkorb(Nutzer nutzer) {
        if (!warenkoerbe.containsKey(nutzer)) {
            Warenkorb neuerWarenkorb = new Warenkorb(nutzer);
            warenkoerbe.put(nutzer, neuerWarenkorb);
            return neuerWarenkorb;
        }
        return warenkoerbe.get(nutzer);
    }

    // Fügt einem Nutzerwarenkorb einen Artikel hinzu
    public void artikelZumWarenkorbHinzufuegen(Nutzer nutzer, Artikel artikel, int menge) {
        Warenkorb warenkorb = warenkoerbe.get(nutzer);
        if (warenkorb == null) {
            warenkorb = erstelleWarenkorb(nutzer);
        }
        warenkorb.artikelHinzufuegen(artikel, menge);
    }

    // Entfernt einen Artikel aus einem Nutzerwarenkorb
    public void artikelAusWarenkorbEntfernen(Nutzer nutzer, Artikel artikel, int menge) {
        Warenkorb warenkorb = warenkoerbe.get(nutzer);
        if (warenkorb != null) {
            warenkorb.artikelEntfernen(artikel, menge);
        }
    }
}
