package entities;

public abstract class Nutzer {
    private int nummer;
    private String name;
    private String email;
    private String passwort;

    public Nutzer(int nummer, String name, String email, String passwort) {
        this.nummer = nummer;
        this.name = name;
        this.email = email;
        this.passwort = passwort;
    }

    public Nutzer(String name, String email, String passwort) {
        this.name = name;
        this.email = email;
        this.passwort = passwort;
    }

    public int getNummer() {
        return nummer;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswort() {
        return passwort;
    }

    public abstract boolean istMitarbeiter();
}