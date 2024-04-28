package entities;

public class Kunde {

    private int kundenNr;
    private String name = "";
    private String email = "";
    private String passwort = "";
    private String strasse = "";
    private String plz = "";
    private String wohnort = "";


    public void setKundenNr(int mitarbeiterNr) {
        this.kundenNr = mitarbeiterNr;
    }

    public int getKundenNr() {
        return kundenNr;
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
