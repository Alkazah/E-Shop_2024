package cui;

import entities.Kunde;

import java.util.Scanner;

public class KundenMenu {
    public void start(Kunde kunde) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Willkommen, " + kunde.getName() + "! Was möchten Sie tun?");
            System.out.println("1. Produkte anzeigen");
            System.out.println("2. Warenkorb anzeigen");
            System.out.println("3. Bestellung aufgeben");
            System.out.println("4. Logout");
            System.out.print("Bitte wählen Sie eine Option: ");
            int auswahl = scanner.nextInt();

            switch (auswahl) {
                case 1:
                    // Produkte anzeigen
                    break;
                case 2:
                    // Warenkorb anzeigen
                    break;
                case 3:
                    // Bestellung aufgeben
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

