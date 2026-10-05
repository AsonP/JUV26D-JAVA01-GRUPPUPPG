package fangdjupet;

import fangdjupet.game.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Menu menu = new Menu(scanner);
            menu.run();
        }
    }
}
