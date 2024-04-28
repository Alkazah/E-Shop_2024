package entities;

public class Mitarbeiter {
    private int mitarbeiterNr;
    private String name = "";
    private String email = "";
    private String passwort = "";

    public void setMitarbeiterNr(int mitarbeiterNr) {
        this.mitarbeiterNr = mitarbeiterNr;
    }

    public int getMitarbeiterNr() {
        return mitarbeiterNr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public String getPasswort() {
        return passwort;
    }


}
