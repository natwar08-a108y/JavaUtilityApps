package modules.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Calendar {

    static Scanner scanner = new Scanner(System.in);

    public static void start() {

        System.out.println("\n============Welcome to JAVA CALENDAR=====================");
        LocalDate date = LocalDate.now();
        System.out.println("Date: " + date + "                               " + "Day: " + date.getDayOfWeek());
        QuotesOfDay();
        int mainChoice;

        do {
            System.out.print(
                    "\nSelect operation based on no. \n" +
                            "1. Age Calculator\n" +
                            "2. Calendar of month\n" +
                            "3. Calendar of Year\n" +
                            "4. Checking Holiday(add, check, delete event)\n" +
                            "5. Checking if leap year\n" +
                            "6. Checking gap b/w 2 dates \n" +
                            "7. Comparing 2 dates \n" +
                            "8. Running clock \n" +
                            "0. Exit\n" +
                            "Enter Choice: ");

            mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {

                case 1:
                    ageCalculator();
                    break;

                case 2:
                    PrintingMonthCalendar();
                    break;

                case 3:
                    PrintingYearCalendar();
                    break;

                case 4:
                    DayMarker();
                    break;

                case 5:
                    leapYearCalculator();
                    break;

                case 6:
                    gapCalculator();
                    break;

                case 7:
                    ComparingDates();
                    break;

                case 8:
                    runClock();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
            if (mainChoice != 0) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        } while (mainChoice != 0);
    }
    static void runClock() {
        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("HH:mm:ss");

            System.out.println("Enter seconds you want to run the clock:");
            int p = scanner.nextInt();
            scanner.nextLine();
            for(int i = 1;i<=p;i++){
                LocalTime time = LocalTime.now();
                System.out.print("\r" + time.format(formatter));
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Clock Stopped");
        }
        System.out.println("  Clock Stopped");
    }

    static void ComparingDates() {

        System.out.println("Enter Date (dd-MM-yyyy):");
        String input1 = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date1 = LocalDate.parse(input1, formatter);

        System.out.println("Enter Date (dd-MM-yyyy):");
        String input2 = scanner.nextLine();

        LocalDate date2 = LocalDate.parse(input2, formatter);

        if (date1.isBefore(date2)) {
            System.out.println(date1 + " is earlier than " + date2);
        } else if (date1.isAfter(date2)) {
            System.out.println(date1 + " is later than " + date2);
        } else {
            System.out.println(date1 + " equal to " + date2);
        }
    }
    static void DayMarker() {

        try {

            HashMap<String, String> holidayMap = loadHolidays();

            System.out.println("1. Check Holiday");
            System.out.println("2. Add Holiday");
            System.out.println("3. Delete Holiday");
            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    checkHoliday(holidayMap);
                    break;

                case 2:
                    addHoliday(holidayMap);
                    break;

                case 3:
                    deleteHoliday(holidayMap);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } catch (Exception e) {
            System.out.println("Error occurred.");
        }
    }

    static void checkHoliday(HashMap<String, String> map) {

        System.out.print("Enter date (yyyy/mm/dd): ");
        String date = scanner.nextLine();

        if (map.containsKey(date)) {
            System.out.println("Holiday: " + map.get(date));
        } else {
            System.out.println("No holiday found.");
        }
    }

    static void addHoliday(HashMap<String, String> map) throws IOException {

        System.out.print("Enter date (yyyy/mm/dd): ");
        String date = scanner.nextLine();

        if (map.containsKey(date)) {
            System.out.println("Holiday already exists.");
            return;
        }

        System.out.print("Enter event name: ");
        String event = scanner.nextLine();

        FileWriter writer = new FileWriter("src/modules/calendar/Holiday.txt", true);
        writer.write( date + "-" + event + "\n");
        writer.close();

        System.out.println("Holiday added successfully.");
    }

    static void deleteHoliday(HashMap<String, String> map) throws IOException {

        System.out.print("Enter date to delete: ");
        String date = scanner.nextLine();

        if (!map.containsKey(date)) {
            System.out.println("Holiday not found.");
            return;
        }

        map.remove(date);

        FileWriter writer = new FileWriter("src/modules/calendar/Holiday.txt");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            writer.write(entry.getKey() + "-" + entry.getValue() + "\n");
        }

        writer.close();

        System.out.println("Holiday deleted successfully.");
    }

    static HashMap<String, String> loadHolidays() throws FileNotFoundException {

        HashMap<String, String> holidayMap = new HashMap<>();
        File file = new File("src/modules/calendar/Holiday.txt");

        if (!file.exists()) {
            return holidayMap;
        }

        try (Scanner reader = new Scanner(file)) {
        while (reader.hasNextLine()) {

            String line = reader.nextLine();
            String[] parts = line.split("-", 2);

            if (parts.length == 2) {
                holidayMap.put(parts[0].trim(), parts[1].trim());
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return holidayMap;
    }

    static void QuotesOfDay() {

        ArrayList<String> quotes = new ArrayList<>();

        try {

            File file = new File("src/modules/calendar/quotes.txt");

            if (!file.exists()) {
                return;
            }

            Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                quotes.add(fileScanner.nextLine());
            }

            fileScanner.close();

            if (quotes.size() > 0) {
                Random random = new Random();
                int index = random.nextInt(quotes.size());

                System.out.println("Quote of the Day:");
                System.out.println(quotes.get(index));
            }

        } catch (Exception e) {
            System.out.println("Quotes file error.");
        }
    }

    static void leapYearCalculator() {
        System.out.print("Enter Year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        if (Year.isLeap(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not leap year.");
        }
    }

    static void ageCalculator() {

        System.out.print("Enter Birth Year: ");
        int y1 = scanner.nextInt();
        System.out.print("Enter Birth Month: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter Birth Day: ");
        int d1 = scanner.nextInt();
        scanner.nextLine();

        LocalDate date1 = LocalDate.of(y1, m1, d1);
        LocalDate date2 = LocalDate.now();

        if (date1.isAfter(date2)) {
            System.out.println("You are not Born Yet!");
        } else {
            Period p = Period.between(date1, date2);
            System.out.println("You are: "
                    + p.getYears() + " years, "
                    + p.getMonths() + " months, "
                    + p.getDays() + " days old.");
        }
    }
    static void PrintingMonthCalendar(){
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        System.out.print("Enter Month no (1-12): ");
        int month = scanner.nextInt();
        String[] mon = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        System.out.println(" " + mon[month-1]);
        LocalDate date = LocalDate.of(year, month, 1);
        int daysInMonth = date.lengthOfMonth();
        System.out.println("\nSUN MON TUE WED THU FRI SAT");
        DayOfWeek firstDay = date.getDayOfWeek();
        int value = firstDay.getValue();
        int startPosition = value % 7;
        for (int i = 0; i < startPosition; i++) {
            System.out.print(" ");
        }

        for (int day = 1; day <= daysInMonth; day++){
            System.out.printf("%-4d", day);
            if ((day + startPosition) % 7 == 0) { System.out.println(); }
        }
    }
    static void PrintingYearCalendar() {
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        String[] mon = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int month = 1; month <= 12; month++) {
            System.out.println("\n        " + mon[month - 1]);
            LocalDate date = LocalDate.of(year, month, 1);
            int daysInMonth = date.lengthOfMonth();

            System.out.println("SUN MON TUE WED THU FRI SAT");

            DayOfWeek firstDay = date.getDayOfWeek();
            int value = firstDay.getValue();
            int startPosition = value % 7;

            for (int i = 0; i < startPosition; i++) {
                System.out.print("    ");
            }

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.printf("%-4d", day);

                if ((day + startPosition) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println("\n");
        }
    }
    static void gapCalculator() {

        System.out.print("Enter Year: ");
        int y1 = scanner.nextInt();
        System.out.print("Enter Month: ");
        int m1 = scanner.nextInt();
        System.out.print("Enter Day: ");
        int d1 = scanner.nextInt();

        LocalDate date1 = LocalDate.of(y1, m1, d1);

        System.out.println("1. From now\n2. From specific date");
        int ch = scanner.nextInt();
        scanner.nextLine();

        if (ch == 1) {

            LocalDate now = LocalDate.now();
            long daysBetween = Math.abs(ChronoUnit.DAYS.between(date1, now));
            System.out.println("Days difference: " + daysBetween);

        } else if (ch == 2) {

            System.out.print("Enter Year: ");
            int y2 = scanner.nextInt();
            System.out.print("Enter Month: ");
            int m2 = scanner.nextInt();
            System.out.print("Enter Day: ");
            int d2 = scanner.nextInt();
            scanner.nextLine();

            LocalDate date2 = LocalDate.of(y2, m2, d2);

            long daysBetween = Math.abs(ChronoUnit.DAYS.between(date1, date2));
            System.out.println("Days difference: " + daysBetween);
        }
    }
}