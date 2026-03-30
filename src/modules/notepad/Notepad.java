package modules.notepad;

import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {
    static Scanner scanner = new Scanner(System.in);
    public static void start() {
        int choice;
        do {
            System.out.println("\n===== FILE MANAGEMENT SYSTEM =====");
            System.out.println("1. Create File");
            System.out.println("2. Read File");
            System.out.println("3. Add/Write Content");
            System.out.println("4. Delete File");
            System.out.println("5. Search Word");
            System.out.println("6. Count Lines");
            System.out.println("7. Rename File");
            System.out.println("8. File Information");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.println("\n--- CREATE FILE ---");
                    CreateFile();
                    break;

                case 2:
                    System.out.println("\n--- READ FILE ---");
                    read();
                    break;
                case 3:
                    System.out.println("\n--- ADD / WRITE CONTENT ---");
                    AddContent();
                    break;

                case 4:
                    System.out.println("\n--- DELETE FILE ---");
                    delete();
                    break;

                case 5:
                    System.out.println("\n--- SEARCH WORD ---");
                    Search();
                    break;

                case 6:
                    System.out.println("\n--- COUNT LINES ---");
                    count();
                    break;
                case 7:
                    System.out.println("\n--- RENAME FILE ---");
                    Rename();
                    break;

                case 8:
                    System.out.println("\n--- FILE INFORMATION ---");
                    FileInformation();
                    break;

                case 9:
                    System.out.println("Exiting program... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 9);
    }

    static void delete() {
        System.out.println("Enter file name/address(with .txt):");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    static void read() {
        System.out.println("Enter file name/address(with .txt)");
        String fileName = scanner.nextLine();
        // Use try-with-resources to ensure the reader is closed automatically
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read file line by line until a null is returned (end of file)
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void CreateFile() {
        System.out.println("Please enter file name/address:");
        String fileName = scanner.nextLine();
        System.out.println("Please enter file content: ");
        String content = scanner.nextLine();
        if (new File(fileName).exists()) {
            System.out.println("File already exists!");
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(content);
                writer.newLine();
                System.out.println("File created and written successfully.");
            } catch (IOException e) {
                System.err.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    static void AddContent() {
        System.out.println("Please enter file name/address:");
        String fileName = scanner.nextLine();

        System.out.println("Do you want to overwrite whole file: (true = overwrite / false = append):");
        boolean isOverwrite = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Please enter file content:");
        String content = scanner.nextLine();

        try (
                FileWriter fw = new FileWriter(fileName, !isOverwrite);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write(content);
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void Rename() {
        System.out.print("Enter old file address(with .txt):");
        String fileName1 = scanner.nextLine();
        System.out.print("Enter new file address(with .txt):");
        String fileName2 = scanner.nextLine();
        File oldFile = new File(fileName1);
        File newFile = new File(fileName2);

        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully.");
        } else {
            System.out.println("Rename failed.");
        }
    }

    static void count() {
        System.out.println("Please enter file name/address(with .txt):");
        String fileName = scanner.nextLine();

        int count = 0;
        int words = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                count++;
                words += line.split("\\s+").length;
            }

            System.out.println("Total lines: " + count);
            System.out.println("Total words: " + words);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void Search() {
        System.out.println("Please enter file name/address (with .txt):");
        String fileName = scanner.nextLine();

        System.out.println("Enter word to search:");
        String word = scanner.nextLine().trim().toLowerCase();

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;


            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains(word)) {
                    found = true;
                    System.out.println("Found in line: " + line); // DEBUG
                }
                lineNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (found)
            System.out.println("Word found!");
        else
            System.out.println("Word not found!");
    }

    static void FileInformation() {
        System.out.println("WELCOME TO FILE INFORMATION");
        System.out.println("Please enter file name/address(with .txt):");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File Size: " + file.length());
        } else {
            System.out.println("File does not exist.");
        }
    }
}


