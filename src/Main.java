import Verwaltungen.ArtikelVerwaltung;
import Verwaltungen.EreignisVerwaltung;
import Verwaltungen.NutzerVerwaltung;
import entities.Artikel;
import entities.Kunde;
import entities.Nutzer;
import entities.Warenkorb;

public class Main {

    public static void main(String[] args) {
        Artikel Kartoffel = new Artikel("Kartoffel", 2,  12.50);
        Artikel Kartoffel2 = new Artikel("Kartoffel2", 3,  12.50);
        Artikel Pandora = new Artikel(1, "Pandora", 5, 75.00);
        Kunde kunde1 = new Kunde(1, "Haaa","ASsdsad", "asdasdas", "Strasse", "28256", "Bremen");
        System.out.println(kunde1.getName());
        System.out.println(Kartoffel);
        System.out.println(Kartoffel2);
        System.out.println(Pandora);

        ArtikelVerwaltung artikelVerwaltung = new ArtikelVerwaltung();
        artikelVerwaltung.artikelHinzufuegen("artikelName", 4, 14.50);
        artikelVerwaltung.artikelHinzufuegen("artikelName2", 6, 16.70);
        artikelVerwaltung.artikelHinzufuegen("artikelName3", 9, 19.00);
        artikelVerwaltung.artikelEntfernen("artikelName2");
        artikelVerwaltung.artikelHinzufuegen("artikelName4", 13, 13.30);
        artikelVerwaltung.bestandAktualisieren("artikelName3", 5);
        System.out.println(artikelVerwaltung.getAlleArtikel());

        System.out.println();

        NutzerVerwaltung nutzerVerwaltung = new NutzerVerwaltung();
        nutzerVerwaltung.kundeRegistrieren("Ahmed", "ahmad.com", "123", "null", null, null);
        nutzerVerwaltung.kundeRegistrieren("Ahmed", "ahmad.com", "123", "null", null, null);
        nutzerVerwaltung.mitarbeiterRegistrieren("Ahmed2", "ahmad2.com", "123");
        System.out.println(nutzerVerwaltung.anmelden("ahmad.com", "123"));
        System.out.println(nutzerVerwaltung.anmelden("ahmad2.com", "123"));

        Nutzer nutzer = nutzerVerwaltung.anmelden("ahmad.com", "123");
        if (nutzer instanceof Kunde) {
            Kunde kunde = (Kunde) nutzer;
            System.out.println(kunde.getStrasse());
        } else {
            System.out.println("Angegebener Nutzer ist kein Kunde.");
        }

        System.out.println("###############################");
        Warenkorb warenkorb = new Warenkorb(nutzer);
        System.out.println(warenkorb.getBesitzer().getName());
        warenkorb.artikelHinzufuegen(Kartoffel, 2);
        warenkorb.artikelHinzufuegen(Pandora, 3);
        System.out.println(warenkorb.getArtikel());
        System.out.println(warenkorb + "\n");

        warenkorb.artikelHinzufuegen(Kartoffel, 2);
        warenkorb.artikelEntfernen(Pandora, 1);
        System.out.println(warenkorb.getArtikel());
        System.out.println(warenkorb);

        System.out.println("###############################");
        EreignisVerwaltung ereignisVerwaltung = new EreignisVerwaltung();
        Artikel kartoffel = artikelVerwaltung.artikelSuchen("artikelName4");
        Nutzer mitarbeiter = nutzerVerwaltung.anmelden("ahmad2.com", "123");
        ereignisVerwaltung.einlagern(kartoffel, 100, mitarbeiter);
        System.out.println(artikelVerwaltung.getAlleArtikel());

    }
}
