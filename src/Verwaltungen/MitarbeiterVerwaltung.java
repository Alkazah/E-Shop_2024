package Verwaltungen;

import entities.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;

public class MitarbeiterVerwaltung {
    private List<Mitarbeiter> mitarbeiterListe;

    public MitarbeiterVerwaltung() {
        this.mitarbeiterListe = new ArrayList<>();
    }

    public void mitarbeiterHinzufuegen(Mitarbeiter mitarbeiter) {
        if (mitarbeiterListe.stream().noneMatch(m -> m.getEmail().equals(mitarbeiter.getEmail()))) {
            mitarbeiterListe.add(mitarbeiter);
            System.out.println("Mitarbeiter erfolgreich hinzugefügt: " + mitarbeiter.getName());
        } else {
            System.out.println("Ein Mitarbeiter mit dieser E-Mail existiert bereits.");
        }
    }

    public void mitarbeiterEntfernen(Mitarbeiter mitarbeiter) {
        if (mitarbeiterListe.contains(mitarbeiter)) {
            mitarbeiterListe.remove(mitarbeiter);
            System.out.println("Mitarbeiter erfolgreich entfernt: " + mitarbeiter.getName());
        } else {
            System.out.println("Mitarbeiter nicht gefunden.");
        }
    }

    public List<Mitarbeiter> getAlleMitarbeiter() {
        return new ArrayList<>(mitarbeiterListe);
    }
}

