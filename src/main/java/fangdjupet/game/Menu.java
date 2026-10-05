package fangdjupet.game;

import java.util.Scanner;

/**
 * Huvudmenyn. Ansvarar bara för att visa valen och läsa in användarens val.
 * Själva spellogiken läggs i egna klasser som menyn anropar.
 */
public class Menu {
    private final Scanner scanner;
    private boolean running;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        running = true;
        while (running) {
            printMenu();
            if (!scanner.hasNextLine()) {
                break;
            }
            handleChoice(scanner.nextLine().trim());
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("=== Fangdjupet ===");
        System.out.println("1. Starta nytt äventyr");
        System.out.println("2. Fortsätt sparat äventyr");
        System.out.println("3. Visa hjältens utrustning");
        System.out.println("4. Strid mot nästa fiende");
        System.out.println("0. Avsluta");
        System.out.print("Välj: ");
    }

    private void handleChoice(String choice) {
        switch (choice) {
            case "1" -> startNewAdventure();
            case "2" -> continueSavedAdventure();
            case "3" -> showEquipment();
            case "4" -> fightNextEnemy();
            case "0" -> quit();
            default -> System.out.println("Ogiltigt val, försök igen.");
        }
    }

    private void startNewAdventure() {
        notImplemented("Starta nytt äventyr");
    }

    private void continueSavedAdventure() {
        notImplemented("Fortsätt sparat äventyr");
    }

    private void showEquipment() {
        notImplemented("Visa hjältens utrustning");
    }

    private void fightNextEnemy() {
        notImplemented("Strid mot nästa fiende");
    }

    private void quit() {
        System.out.println("Tack för att du spelade Fångdjupet!");
        running = false;
    }

    private void notImplemented(String feature) {
        System.out.println(feature + " är inte implementerat ännu.");
    }
}
