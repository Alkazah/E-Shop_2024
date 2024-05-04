package Verwaltungen;

import entities.Artikel;
import entities.Nutzer;
import entities.Warenkorb;

import java.util.HashMap;
import java.util.Map;

public class WarenkorbVerwaltung {
    private Map<Nutzer, Warenkorb> warenkoerbe;

    public WarenkorbVerwaltung() {
        this.warenkoerbe = new HashMap<>();
    }

    public Warenkorb getWarenkorb(Nutzer nutzer) {
        return warenkoerbe.get(nutzer);
    }

    public Warenkorb erstelleWarenkorb(Nutzer nutzer) {
        if (!warenkoerbe.containsKey(nutzer)) {
            Warenkorb neuerWarenkorb = new Warenkorb(nutzer);
            warenkoerbe.put(nutzer, neuerWarenkorb);
            return neuerWarenkorb;
        }
        return warenkoerbe.get(nutzer);
    }

    public void artikelZumWarenkorbHinzufuegen(Nutzer nutzer, Artikel artikel, int menge) {
        Warenkorb warenkorb = warenkoerbe.get(nutzer);
        if (warenkorb == null) {
            warenkorb = erstelleWarenkorb(nutzer);
        }
        warenkorb.artikelHinzufuegen(artikel, menge);
    }

    public void artikelAusWarenkorbEntfernen(Nutzer nutzer, Artikel artikel, int menge) {
        Warenkorb warenkorb = warenkoerbe.get(nutzer);
        if (warenkorb != null) {
            warenkorb.artikelEntfernen(artikel, menge);
        }
    }
}
