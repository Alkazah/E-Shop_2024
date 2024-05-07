package Verwaltungen;

import entities.Kunde;
import entities.Mitarbeiter;
import entities.Nutzer;

import java.util.ArrayList;
import java.util.List;

public class NutzerVerwaltung {
    private List<Nutzer> nutzerListe; // Eine Liste, die alle Nutzerobjekte speichert

    public NutzerVerwaltung() {
        this.nutzerListe = new ArrayList<>();
    }

    // Methode zum Registrieren eines Kunden mit Adresse
    public void registriereNutzer(String name, String email, String passwort, String strasse, String plz, String wohnort) {
        // Überprüfung, ob der E-Mail bereits existiert
        if (nutzerListe.stream().anyMatch(nutzer -> nutzer.getEmail().equals(email))) {
            System.out.println("Benutzername bereits vergeben.");
            return; // Beendet die Methode, falls die E-Mail schon vergeben ist
        }
        // Erstellen eines neuen Kundenobjekts mit den übergebenen Daten
        Nutzer neuerNutzer = new Kunde(name, email, passwort, strasse, plz, wohnort);
        System.out.println(neuerNutzer.getName() + " erfolgreich registriert.");
        nutzerListe.add(neuerNutzer); // Hinzufügen des neuen Nutzers zur Liste
        //System.out.println("Nutzer erfolgreich registriert.");
    }

    // Methode zum Registrieren eines Mitarbeiters ohne Adresse
    public void registriereNutzer(String name, String email, String passwort) {
        // Überprüfung, ob die E-Mail bereits in der Liste existiert
        if (nutzerListe.stream().anyMatch(nutzer -> nutzer.getEmail().equals(email))) {
            System.out.println("E-Mail bereits vergeben.");
            return; // Beendet die Methode, falls die E-Mail schon vergeben ist
        }

        // Erstellen eines neuen Mitarbeiterobjekts mit den übergebenen Daten
        Nutzer neuerNutzer = new Mitarbeiter(name, email, passwort);
        System.out.println(neuerNutzer.getName() + " erfolgreich registriert.");
        nutzerListe.add(neuerNutzer); // Hinzufügen des neuen Nutzers zur Liste
        //System.out.println("Nutzer erfolgreich registriert.");
    }


    // Methode zum Anmelden eines Nutzers mit E-Mail und Passwort
    public Nutzer anmelden(String email, String passwort) {
        // Durchläuft alle Nutzer in der Liste
        for (Nutzer nutzer : nutzerListe) {
            if (nutzer.getEmail().equalsIgnoreCase(email) && nutzer.getPasswort().equals(passwort)) {
                return nutzer;
            }
        }
        return null; // Gibt null zurück, wenn kein passender Nutzer gefunden wurde
    }
}