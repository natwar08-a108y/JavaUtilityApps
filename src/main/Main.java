package main;

import modules.calculator.Calculator;
import modules.calendar.Calendar;
import modules.music.Music;
import modules.notepad.Notepad;
import modules.peopleinformation.PeopleInfo;
import modules.unitconverter.UnitConverter;
import modules.game.Game;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            showMenu();
            choice = getChoice();

            switch (choice) {

                case 1:
                    openSection("Calculator 📠");
                    Calculator.start();
                    break;

                case 2:
                    openSection("Calendar 📅");
                    Calendar.start();
                    break;

                case 3:
                    openSection("Music Player 🎤");
                    Music.start();
                    break;

                case 4:
                    openSection("Notepad 🗒️");
                    Notepad.start();
                    break;

                case 5:
                    openSection("People Information 👥");
                    PeopleInfo.start();
                    break;

                case 6:
                    openSection("Unit Converter ⏲️");
                    UnitConverter.start();
                    break;

                case 7:
                    openSection("Game 🎮");
                    Game.start();
                    break;

                case 0:
                    System.out.println("\nExiting Application...");
                    break;

                default:
                    System.out.println("\n❌ Invalid choice");
            }

            if (choice != 0) pause();

        } while (choice != 0);

        scanner.close();
    }

    private static void showMenu() {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║    JAVA MULTI UTILITY APPLICATION    ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  1. Calculator                       ║");
        System.out.println("║  2. Calendar                         ║");
        System.out.println("║  3. Music Player                     ║");
        System.out.println("║  4. Notepad                          ║");
        System.out.println("║  5. People Information               ║");
        System.out.println("║  6. Unit Converter                   ║");
        System.out.println("║  7. Game                             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║  0. Exit                             ║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    private static int getChoice() {

        System.out.print("\n➤ Enter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter number: ");
            scanner.next();
        }

        return scanner.nextInt();
    }

    private static void openSection(String name) {

        System.out.println("\n══════════════════════════════════════");
        System.out.println("           " + name.toUpperCase());
        System.out.println("══════════════════════════════════════\n");
    }

    private static void pause() {

        System.out.print("\nPress Enter to continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {}
    }
}
