import Verwaltungen.NutzerVerwaltung;
import Verwaltungen.WarenkorbVerwaltung;
import entities.Artikel;
import entities.Kunde;
import entities.Nutzer;
import entities.Warenkorb;

public class Main {

    public static void main(String[] args) {
        Artikel Kartoffel = new Artikel(1,"Kartoffel", 2,  12.50);
        Artikel Pandora = new Artikel(1, "Pandora", 5, 75.00);
        Kunde kunde1 = new Kunde(1, "Haaa","ASsdsad", "asdasdas", "Strasse", "28256", "Bremen");
        System.out.println(kunde1.getName());
        System.out.println(Kartoffel);


        NutzerVerwaltung nutzerVerwaltung = new NutzerVerwaltung();
        nutzerVerwaltung.registriereNutzer(2, "Ahmed", "ahmad.com", "123", "null", null, null);
        nutzerVerwaltung.registriereNutzer(2, "Ahmed", "ahmad.com", "123", "null", null, null);
        nutzerVerwaltung.registriereNutzer(3, "Ahmed2", "ahmad2.com", "123");
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
        WarenkorbVerwaltung warenkorbVerwaltung = new WarenkorbVerwaltung();

    }
}
