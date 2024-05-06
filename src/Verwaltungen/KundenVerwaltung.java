package Verwaltungen;

import entities.Kunde;

import java.util.ArrayList;
import java.util.List;

public class KundenVerwaltung {
    private List<Kunde> kundenListe;

    public KundenVerwaltung() {
        this.kundenListe = new ArrayList<>();
    }

    public void kundeHinzufuegen(Kunde kunde) {
        if (kundenListe.stream().noneMatch(k -> k.getEmail().equals(kunde.getEmail()))) {
            kundenListe.add(kunde);
            System.out.println("Kunde erfolgreich hinzugefügt: " + kunde.getName());
        } else {
            System.out.println("Ein Kunde mit dieser E-Mail existiert bereits.");
        }
    }

    public void kundeEntfernen(Kunde kunde) {
        if (kundenListe.contains(kunde)) {
            kundenListe.remove(kunde);
            System.out.println("Kunde erfolgreich entfernt: " + kunde.getName());
        } else {
            System.out.println("Kunde nicht gefunden.");
        }
    }

    public void kundenDatenAktualisieren(Kunde kunde, String neueStrasse, String neuerPlz, String neuerWohnort) {
        Kunde gefunden = kundenListe.stream().filter(k -> k.getEmail().equals(kunde.getEmail())).findFirst().orElse(null);
        if (gefunden != null) {
            gefunden.setStrasse(neueStrasse);
            gefunden.setPlz(neuerPlz);
            gefunden.setWohnort(neuerWohnort);
            System.out.println("Kundendaten aktualisiert für: " + gefunden.getName());
        } else {
            System.out.println("Kunde nicht gefunden.");
        }
    }

    public List<Kunde> getAlleKunden() {
        return new ArrayList<>(kundenListe);
    }
}

