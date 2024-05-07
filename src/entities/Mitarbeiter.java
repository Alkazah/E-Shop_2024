package entities;

public class Mitarbeiter extends Nutzer {

    public Mitarbeiter(int nummer, String name, String benutzername, String passwort) {
        super(nummer, name, benutzername, passwort);
    }

    public Mitarbeiter(String name, String benutzername, String passwort) {
        super(name, benutzername, passwort);
    }

    @Override
    public boolean istMitarbeiter() {
        return true;
    }
}