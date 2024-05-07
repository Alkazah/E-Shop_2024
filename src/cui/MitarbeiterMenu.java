package cui;

import entities.Mitarbeiter;

import java.util.Scanner;

public class MitarbeiterMenu {
    public void start(Mitarbeiter mitarbeiter) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Willkommen, " + mitarbeiter.getName() + "! Was möchten Sie tun?");
            System.out.println("1. Lagerbestand verwalten");
            System.out.println("2. Produkt hinzufügen");
            System.out.println("3. Produkt entfernen");
            System.out.println("4. Logout");
            System.out.print("Bitte wählen Sie eine Option: ");
            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1:
                    // Lagerbestand verwalten
                    break;
                case 2:
                    // Produkt hinzufügen
                    break;
                case 3:
                    // Produkt entfernen
                    break;
                case 4:
                    System.out.println("Sie haben sich ausgeloggt.");
                    running = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe.");
                    break;
            }
        }
    }
}
