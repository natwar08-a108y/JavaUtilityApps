package modules.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Music {

    public static void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java Music Player ===");
        System.out.println("1. Har Har Shambhu Shiv Mahadeva");
        System.out.println("2. Narayan (Jubin)");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        File file = getFile(choice);

        if (file == null) {
            System.out.println("Invalid choice");
            return;
        }

        playAudio(file, scanner);
    }

    private static File getFile(int choice) {

        switch (choice) {
            case 1:
                return new File("src/modules/music/Har Har Sambhu.wav");
            case 2:
                return new File("src/modules/music/Narayan.wav");
            default:
                return null;
        }
    }

    private static void playAudio(File file, Scanner scanner) {

        try (AudioInputStream audioInputStream =
                     AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            long duration = clip.getMicrosecondLength() / 1_000_000;
            printDuration(duration);

            String input = "";

            while (!input.equals("Q")) {

                System.out.println("\nP = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("Enter choice: ");

                input = scanner.next().toUpperCase();

                switch (input) {

                    case "P":
                        if (!clip.isRunning()) clip.start();
                        break;

                    case "S":
                        clip.stop();
                        break;

                    case "R":
                        resetAudio(clip, scanner);
                        break;

                    case "Q":
                        clip.close();
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line unavailable");
        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    private static void resetAudio(Clip clip, Scanner scanner) {
        long duration = clip.getMicrosecondLength() / 1_000_000;
        System.out.print("Reset from start? (Y/N): ");
        String choice = scanner.next().toUpperCase();

        if (choice.equals("Y")) {
            clip.setMicrosecondPosition(0);
        } else if (choice.equals("N")) {
            System.out.print("Enter position (seconds): ");
            int sec = scanner.nextInt();
            if (sec >= 0 && sec <= duration) {
                clip.setMicrosecondPosition(sec * 1_000_000);
            } else {
                System.out.println("Enter value between 0 and " + duration + " seconds");
            }
        } else {
            System.out.println("Invalid input");
        }
    }

    private static void printDuration(long seconds) {

        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long sec = seconds % 60;

        System.out.printf("Duration: %02d:%02d:%02d\n", hours, minutes, sec);
    }
}