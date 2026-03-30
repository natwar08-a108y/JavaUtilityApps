package modules.peopleinformation;

import java.io.*;
import java.util.Scanner;

public class PeopleInfo {
    static Scanner scanner = new Scanner(System.in);
    public static void start() {
        int choice;

        do {
            System.out.println("\n===== People Information Management System =====");
            System.out.println("1. Create Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Filter by City/Occupation");
            System.out.println("5. Delete Contact");
            System.out.println("6. Count Contacts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    CreateContact();
                    break;

                case 2:
                    ViewContact();
                    break;

                case 3:
                    SearchContact();
                    break;

                case 4:
                    FilterByCityOccupation();
                    break;

                case 5:
                    DeleteContact();
                    break;

                case 6:
                    CountContact();
                    break;

                case 7:
                    System.out.println("Exiting program... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);
    }
    static void CreateContact() {
        char choice;

        do {
            String name, phone, email;
            while (true) {
                System.out.print("Enter Name: ");
                name = scanner.nextLine();

                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Please enter your name!");
                }
            }

            while (true) {
                System.out.print("Enter Phone: ");
                phone = scanner.nextLine();

                if (phone.length() == 10 && phone.matches("\\d+")) {
                    break;
                } else {
                    System.out.println("Invalid phone! Try again.");
                }
            }
            while (true) {
                System.out.print("Enter Email: ");
                email = scanner.nextLine();

                if (!email.isEmpty() && email.contains("@")) {
                    break;
                } else {
                    System.out.println("Invalid email! Try again.");
                }
            }

            System.out.print("Enter Occupation: ");
            String occupation = scanner.nextLine();

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            String record = name + "," + phone + "," + email + "," + occupation + "," + city;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/modules/peopleinformation/PeopleInfoManageSys.txt", true))) {
                bw.write(record);
                bw.newLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.print("Add another person? (y/n): ");
            choice = scanner.next().charAt(0);
            scanner.nextLine();

        } while (choice == 'y' || choice == 'Y');
    }
    static void CountContact(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/modules/peopleinformation/PeopleInfoManageSys.txt"))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                count++;
            }

            System.out.println("Total Number of Contact: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void ViewContact(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/modules/peopleinformation/PeopleInfoManageSys.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void SearchContact() {
        System.out.println("Search by: 1.Name  2.Phone  3.Email");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter data to search: ");
        String input = scanner.nextLine().trim().toLowerCase();

        int index;

        switch (choice) {
            case 1: index = 0; break;
            case 2: index = 1; break;
            case 3: index = 2; break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/modules/peopleinformation/PeopleInfoManageSys.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 5 && data[index].trim().toLowerCase().contains(input)) {
                    System.out.println("\n" + line);
                    found = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!found) System.out.println("No record found.");
    }
    static void FilterByCityOccupation() {

        System.out.println("Filter by: 1.Occupation  2.City");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter value to search: ");
        String input = scanner.nextLine().trim().toLowerCase();

        int index;

        switch (choice) {
            case 1: index = 3; break;
            case 2: index = 4; break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("src/modules/peopleinformation/PeopleInfoManageSys.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 5 && data[index].trim().toLowerCase().contains(input)) {
                    System.out.println("\n" + line);
                    found = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!found) System.out.println("No record found.");
    }
    static void DeleteContact() {

        System.out.println("Delete by: 1.Name  2.Phone  3.Email");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter value to delete: ");
        String input = scanner.nextLine().trim().toLowerCase();

        int index;

        switch (choice) {
            case 1: index = 0; break;
            case 2: index = 1; break;
            case 3: index = 2; break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        boolean found = false;
        StringBuilder newData = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("src/modules/peopleinformation/PeopleInfoManageSys.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length >= 5 && data[index].trim().toLowerCase().contains(input)) {
                    found = true;
                    continue;
                }

                newData.append(line).append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/modules/peopleinformation/PeopleInfoManageSys.txt"))) {
            bw.write(newData.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (found)
            System.out.println("Contact deleted successfully.");
        else
            System.out.println("No matching record found.");
    }
}
