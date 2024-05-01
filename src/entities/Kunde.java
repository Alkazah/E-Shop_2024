package entities;

public class Kunde extends Nutzer {
    private String strasse = "";
    private String plz = "";
    private String wohnort = "";

    public Kunde(int nummer, String name, String benutzername, String passwort, String strasse, String plz, String wohnort) {
        super(nummer, name, benutzername, passwort);
        this.strasse = strasse;
        this.plz = plz;
        this.wohnort = wohnort;
    }

    @Override
    public boolean istMitarbeiter() {
        return false;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getPlz() {
        return plz;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getWohnort() {
        return wohnort;
    }
}