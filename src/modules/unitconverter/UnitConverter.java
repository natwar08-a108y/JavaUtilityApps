package modules.unitconverter;

import java.util.Scanner;

public class UnitConverter {
    static Scanner scanner = new Scanner(System.in);
    public static void start(){
        String choice = "";

        System.out.println("=======================================");
        System.out.println("      📏 UNIT CONVERTER SYSTEM 📏      ");
        System.out.println("=======================================");

        while (!choice.equalsIgnoreCase("Q")) {

            System.out.println("\nChoose Conversion Category:");
            System.out.println("1. Length");
            System.out.println("2. Weight");
            System.out.println("3. Temperature");
            System.out.println("4. Speed");
            System.out.println("5. Time");
            System.out.println("6. Data Storage");
            System.out.println("7. Energy");
            System.out.println("8. Area");
            System.out.println("Q. Back to Main Menu");

            System.out.print("Enter your choice: ");
            choice = scanner.next();

            System.out.println();

            switch (choice.toUpperCase()) {

                case "1":
                    lengthConverter();
                    break;

                case "2":
                    weightConverter();
                    break;

                case "3":
                    temperatureConverter();
                    break;

                case "4":
                    speedConverter();
                    break;

                case "5":
                    timeConverter();
                    break;

                case "6":
                    dataConverter();
                    break;

                case "7":
                    energyConverter();
                    break;

                case "8":
                    areaConverter();
                    break;

                case "Q":
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }
    static void  lengthConverter(){
        System.out.println("========= LENGTH CONVERTER =========");
        System.out.println("1. Meter → Kilometer");
        System.out.println("2. Kilometer → Meter");
        System.out.println("3. Meter → Centimeter");
        System.out.println("4. Centimeter → Meter");
        System.out.println("5. Inch → Centimeter");
        System.out.println("6. Centimeter → Inch");
        System.out.println("7. Feet → Meter");
        System.out.println("8. Meter → Feet");
        System.out.println("9. Kilometer → Miles");
        System.out.println("10. Miles → Kilometer");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        System.out.println(); // spacing

        switch (choice) {

            case 1:
                System.out.print("Enter distance in meters: ");
                double m1 = scanner.nextDouble();
                System.out.println("Result: " + (m1 / 1000) + " km");
                break;

            case 2:
                System.out.print("Enter distance in kilometers: ");
                double km1 = scanner.nextDouble();
                System.out.println("Result: " + (km1 * 1000) + " m");
                break;

            case 3:
                System.out.print("Enter length in meters: ");
                double m2 = scanner.nextDouble();
                System.out.println("Result: " + (m2 * 100) + " cm");
                break;

            case 4:
                System.out.print("Enter length in centimeters: ");
                double cm1 = scanner.nextDouble();
                System.out.println("Result: " + (cm1 / 100) + " m");
                break;

            case 5:
                System.out.print("Enter length in inches: ");
                double inch1 = scanner.nextDouble();
                System.out.println("Result: " + (inch1 * 2.54) + " cm");
                break;

            case 6:
                System.out.print("Enter length in centimeters: ");
                double cm2 = scanner.nextDouble();
                System.out.println("Result: " + (cm2 / 2.54) + " inch");
                break;

            case 7:
                System.out.print("Enter height in feet: ");
                double ft1 = scanner.nextDouble();
                System.out.println("Result: " + (ft1 * 0.3048) + " m");
                break;

            case 8:
                System.out.print("Enter height in meters: ");
                double m3 = scanner.nextDouble();
                System.out.println("Result: " + (m3 / 0.3048) + " ft");
                break;

            case 9:
                System.out.print("Enter distance in kilometers: ");
                double km2 = scanner.nextDouble();
                System.out.println("Result: " + (km2 * 0.621371) + " miles");
                break;

            case 10:
                System.out.print("Enter distance in miles: ");
                double mile = scanner.nextDouble();
                System.out.println("Result: " + (mile / 0.621371) + " km");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    static void weightConverter() {

        System.out.println("========= WEIGHT CONVERTER =========");
        System.out.println("1. Kg → Gram");
        System.out.println("2. Gram → Kg");
        System.out.println("3. Kg → Pound");
        System.out.println("4. Pound → Kg");
        System.out.println("5. Gram → Milligram");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter weight in kg: ");
                double kg = scanner.nextDouble();
                System.out.println("Result: " + (kg * 1000) + " g");
                break;

            case 2:
                System.out.print("Enter weight in gram: ");
                double g = scanner.nextDouble();
                System.out.println("Result: " + (g / 1000) + " kg");
                break;

            case 3:
                System.out.print("Enter weight in kg: ");
                double kg1 = scanner.nextDouble();
                System.out.println("Result: " + (kg1 * 2.20462) + " lb");
                break;

            case 4:
                System.out.print("Enter weight in pound: ");
                double lb = scanner.nextDouble();
                System.out.println("Result: " + (lb / 2.20462) + " kg");
                break;

            case 5:
                System.out.print("Enter weight in gram: ");
                double g1 = scanner.nextDouble();
                System.out.println("Result: " + (g1 * 1000) + " mg");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    static void temperatureConverter() {

        System.out.println("========= TEMPERATURE CONVERTER =========");
        System.out.println("1. Celsius → Fahrenheit");
        System.out.println("2. Fahrenheit → Celsius");
        System.out.println("3. Celsius → Kelvin");
        System.out.println("4. Kelvin → Celsius");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter temperature in Celsius: ");
                double c = scanner.nextDouble();
                System.out.println("Result: " + ((c * 9/5) + 32) + " F");
                break;

            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                double f = scanner.nextDouble();
                System.out.println("Result: " + ((f - 32) * 5/9) + " C");
                break;

            case 3:
                System.out.print("Enter temperature in Celsius: ");
                double c1 = scanner.nextDouble();
                System.out.println("Result: " + (c1 + 273.15) + " K");
                break;

            case 4:
                System.out.print("Enter temperature in Kelvin: ");
                double k = scanner.nextDouble();
                System.out.println("Result: " + (k - 273.15) + " C");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    static void speedConverter() {

        System.out.println("========= SPEED CONVERTER =========");
        System.out.println("1. km/h → m/s");
        System.out.println("2. m/s → km/h");
        System.out.println("3. mph → km/h");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter speed in km/h: ");
                double kmh = scanner.nextDouble();
                System.out.println("Result: " + (kmh / 3.6) + " m/s");
                break;

            case 2:
                System.out.print("Enter speed in m/s: ");
                double ms = scanner.nextDouble();
                System.out.println("Result: " + (ms * 3.6) + " km/h");
                break;

            case 3:
                System.out.print("Enter speed in mph: ");
                double mph = scanner.nextDouble();
                System.out.println("Result: " + (mph * 1.60934) + " km/h");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    static void timeConverter() {

        System.out.println("========= TIME CONVERTER =========");
        System.out.println("1. Hour → Minute");
        System.out.println("2. Minute → Second");
        System.out.println("3. Second → Minute");
        System.out.println("4. Day → Hour");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter time in hours: ");
                double hr = scanner.nextDouble();
                System.out.println("Result: " + (hr * 60) + " minutes");
                break;

            case 2:
                System.out.print("Enter time in minutes: ");
                double min = scanner.nextDouble();
                System.out.println("Result: " + (min * 60) + " seconds");
                break;

            case 3:
                System.out.print("Enter time in seconds: ");
                double sec = scanner.nextDouble();
                System.out.println("Result: " + (sec / 60) + " minutes");
                break;

            case 4:
                System.out.print("Enter time in days: ");
                double day = scanner.nextDouble();
                System.out.println("Result: " + (day * 24) + " hours");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    static void dataConverter() {

        System.out.println("========= DATA STORAGE CONVERTER =========");
        System.out.println("1. KB → MB");
        System.out.println("2. MB → KB");
        System.out.println("3. MB → GB");
        System.out.println("4. GB → MB");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter data in KB: ");
                double kb = scanner.nextDouble();
                System.out.println("Result: " + (kb / 1024) + " MB");
                break;

            case 2:
                System.out.print("Enter data in MB: ");
                double mb = scanner.nextDouble();
                System.out.println("Result: " + (mb * 1024) + " KB");
                break;

            case 3:
                System.out.print("Enter data in MB: ");
                double mb1 = scanner.nextDouble();
                System.out.println("Result: " + (mb1 / 1024) + " GB");
                break;

            case 4:
                System.out.print("Enter data in GB: ");
                double gb = scanner.nextDouble();
                System.out.println("Result: " + (gb * 1024) + " MB");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    static void energyConverter() {

        System.out.println("========= ENERGY CONVERTER =========");
        System.out.println("1. Joule → Calorie");
        System.out.println("2. Calorie → Joule");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter energy in Joules: ");
                double j = scanner.nextDouble();
                System.out.println("Result: " + (j / 4.184) + " cal");
                break;

            case 2:
                System.out.print("Enter energy in Calories: ");
                double cal = scanner.nextDouble();
                System.out.println("Result: " + (cal * 4.184) + " J");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
    static void areaConverter() {

        System.out.println("========= AREA CONVERTER =========");
        System.out.println("1. m² → cm²");
        System.out.println("2. cm² → m²");
        System.out.println("3. km² → m²");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter area in m²: ");
                double m2 = scanner.nextDouble();
                System.out.println("Result: " + (m2 * 10000) + " cm²");
                break;

            case 2:
                System.out.print("Enter area in cm²: ");
                double cm2 = scanner.nextDouble();
                System.out.println("Result: " + (cm2 / 10000) + " m²");
                break;

            case 3:
                System.out.print("Enter area in km²: ");
                double km2 = scanner.nextDouble();
                System.out.println("Result: " + (km2 * 1000000) + " m²");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}

