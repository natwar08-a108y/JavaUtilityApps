package modules.calculator;

import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        System.out.println("******************************");
        System.out.println("      JAVA CALCULATOR         ");
        System.out.println("******************************");

        int mainChoice;
        do {
            System.out.print(
                    "\nSelect operation based on no. \n" +
                            "1. Basic Arithmetic Calculator (+, -, *, /)\n" +
                            "2. Comparison based Calculator\n" +
                            "3. Root & Power Calculator\n" +
                            "4. Absolute value, Round up & Round down Calculator\n" +
                            "5. Maximum & Minimum Calculator\n" +
                            "6. Logarithmic Calculator\n" +
                            "7. Trigonometric Calculator\n" +
                            "0. Exit\n" +
                            "Enter Choice: ");
            mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    Arithmetic();
                    break;
                case 2:
                    Comparison();
                    break;
                case 3:
                    RootAndPowerCalculator();
                    break;
                case 4:
                    RoundupAndDown();
                    break;
                case 5:
                    MaximumAndMinimum();
                    break;
                case 6:
                    Logarithmic();
                    break;
                case 7:
                    Trigonometric();
                    break;
                case 0:
                    System.out.println("Exiting... ");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (mainChoice != 0);

    }

    static void Trigonometric() {
        System.out.println("Enter choice -\n1-Conversion (radian -> degree)" +
                "\n2-Conversion (degree -> radian)" +
                "\n3-sin(x), cos(x), tan(x) (degree input)" +
                "\n4-inverse trig (asin, acos, atan) (value/range checks)" +
                "\n5-Hypotenuse calculator");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                int stop = 1;
                while (stop != 0) {
                    System.out.print("Enter angle (in radian): ");
                    double num1 = scanner.nextDouble();
                    System.out.printf("Angle = %.2f degrees\n", Math.toDegrees(num1));
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop = scanner.nextInt();
                }
                break;
            }
            case 2: {
                int stop1 = 1;
                while (stop1 != 0) {
                    System.out.print("Enter angle (in degree): ");
                    double num1 = scanner.nextDouble();
                    System.out.printf("Angle = %.2f radians\n", Math.toRadians(num1));
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop1 = scanner.nextInt();
                }
                break;
            }
            case 3: {
                int stop2 = 1;
                while (stop2 != 0) {
                    System.out.print("Enter angle (in degree): ");
                    double num1 = scanner.nextDouble();
                    double angle = Math.toRadians(num1);
                    System.out.println("Sin = " + Math.sin(angle));
                    System.out.println("Cos = " + Math.cos(angle));
                    System.out.println("Tan = " + Math.tan(angle));
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop2 = scanner.nextInt();
                }
                break;
            }
            case 4: {
                int stop3 = 1;
                while (stop3 != 0) {
                    System.out.print("Enter value (for asin/acos: -1 to 1, for atan any real): ");
                    double value = scanner.nextDouble();

                    if (value <= 1 && value >= -1) {
                        System.out.println("asin (degrees) = " + Math.toDegrees(Math.asin(value)));
                        System.out.println("acos (degrees) = " + Math.toDegrees(Math.acos(value)));
                    } else {
                        System.out.println("Not in range for asin & acos (-1..1)");
                    }

                    System.out.println("atan (degrees) = " + Math.toDegrees(Math.atan(value)));

                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop3 = scanner.nextInt();
                }
                break;
            }
            case 5: {
                int stop4 = 1;
                while (stop4 != 0) {
                    System.out.print("Enter side 1: ");
                    double value1 = scanner.nextDouble();
                    System.out.print("Enter side 2: ");
                    double value2 = scanner.nextDouble();
                    double hypo = Math.hypot(value1, value2);
                    System.out.printf("Hypotenuse = %.2f\n", hypo);
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop4 = scanner.nextInt();
                }
                break;
            }
            default:
                System.out.println("Invalid Choice!");
        }
    }

    static void Logarithmic() {
        System.out.print("Enter choice- 1-ln(), 2-log10(), 3-general log(base b), 4-exponent(e^x): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                int stop = 1;
                while (stop != 0) {
                    System.out.print("Enter positive number: ");
                    double num1 = scanner.nextDouble();
                    if (num1 > 0)
                        System.out.println("Output = " + Math.log(num1));
                    else
                        System.out.println("Log undefined for zero or negative numbers");
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop = scanner.nextInt();
                }
                break;
            }
            case 2: {
                int stop1 = 1;
                while (stop1 != 0) {
                    System.out.print("Enter positive number: ");
                    double num1 = scanner.nextDouble();
                    if (num1 > 0)
                        System.out.println("Output = " + Math.log10(num1));
                    else
                        System.out.println("Log10 undefined for zero or negative numbers");
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop1 = scanner.nextInt();
                }
                break;
            }
            case 3: {
                int stop2 = 1;
                while (stop2 != 0) {
                    System.out.print("Enter value (a): ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter base (b > 0, b != 1): ");
                    double b = scanner.nextDouble();
                    if (a > 0 && b > 0 && b != 1)
                        System.out.println("Output = " + (Math.log(a) / Math.log(b)));
                    else
                        System.out.println("Invalid input: a>0 and base b>0 (b!=1) required");
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop2 = scanner.nextInt();
                }
                break;
            }
            case 4: {
                int stop3 = 1;
                while (stop3 != 0) {
                    System.out.print("Enter exponent value: ");
                    double a = scanner.nextDouble();
                    System.out.println("Output = " + Math.exp(a));
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop3 = scanner.nextInt();
                }
                break;
            }
            default:
                System.out.println("Wrong Choice!");
        }
    }

    static void RoundupAndDown() {
        System.out.print("Enter choice- 1 for Absolute value, 2 for Rounding up (ceil), 3 for Rounding down (floor): ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                int stop = 1;
                while (stop != 0) {
                    System.out.print("Enter number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Absolute value = " + Math.abs(num1));
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop = scanner.nextInt();
                }
                break;
            }
            case 2: {
                int stop1 = 1;
                while (stop1 != 0) {
                    System.out.print("Enter number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Rounding up (ceil) = " + Math.ceil(num1));
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop1 = scanner.nextInt();
                }
                break;
            }
            case 3: {
                int stop3 = 1;
                while (stop3 != 0) {
                    System.out.print("Enter number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Rounding down (floor) = " + Math.floor(num1));
                    System.out.print("Continue ?(Press 0-stop or 1-continue): ");
                    stop3 = scanner.nextInt();
                }
                break;
            }
            default:
                System.out.println("Invalid choice");
        }
    }

    static void RootAndPowerCalculator() {
        System.out.print("Enter choice- 1 for root or 2 for power: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                int stop = 1;
                while (stop != 0) {
                    System.out.print("Enter number for root: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter root no. (n): ");
                    double n = scanner.nextDouble();
                    if (n != 0) {
                        double root = Math.pow(num1, 1.0 / n);
                        System.out.printf("Root = %.4f\n", root);
                    } else {
                        System.out.println("Root power cannot be 0");
                    }
                    System.out.print("Continue ?(0-stop,1-continue): ");
                    stop = scanner.nextInt();
                }
                break;
            }
            case 2: {
                int stop1 = 1;
                while (stop1 != 0) {
                    System.out.print("Enter base number: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Enter power no. (n): ");
                    double n = scanner.nextDouble();
                    double power = Math.pow(num1, n);
                    System.out.printf("Power = %.4f\n", power);
                    System.out.print("Continue? (0-stop,1-continue): ");
                    stop1 = scanner.nextInt();
                }
                break;
            }
            default:
                System.out.println("Invalid choice!");
        }
    }

    static void Comparison() {
        System.out.println("Enter expression 1:");
        double Exp1 = scanner.nextDouble();
        System.out.println("Enter expression 2:");
        double Exp2 = scanner.nextDouble();

        double eps = 1e-9;
        if (Math.abs(Exp1 - Exp2) < eps) {
            System.out.println(Exp1 + " is equal to " + Exp2);
        } else if (Exp1 > Exp2) {
            System.out.println(Exp1 + " is greater than " + Exp2);
        } else {
            System.out.println(Exp1 + " is less than " + Exp2);
        }
    }

    static void MaximumAndMinimum() {
        System.out.print("Enter first number (or 0 to exit immediately): ");
        double max = scanner.nextDouble();
        double min = max;
        while (true) {
            System.out.print("Radhe Radhe (Press 0 to exit) Enter another Number: \n");
            double num = scanner.nextDouble();
            if (num == 0) break;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            System.out.printf("Current max: %.2f & Current min: %.2f\n", max, min);
        }
        System.out.printf("Final largest number: %.2f & Smallest number: %.2f\n", max, min);
    }

    static void Arithmetic() {
        System.out.println("Select operation based on no. \n1. +\n2. -\n3. *\n4. /");
        int choice = scanner.nextInt();
        System.out.println("Enter number 1:");
        double a = scanner.nextDouble();
        System.out.println("Enter number 2:");
        double b = scanner.nextDouble();

        switch (choice) {
            case 1: {
                double sum = a + b;
                int stop1 = 1;
                while (stop1 != 0) {
                    System.out.printf("%.4f", sum);
                    System.out.print("\nContinue?(press 0-stop or 1-Continue): ");
                    stop1 = scanner.nextInt();
                    if (stop1 != 0) {
                        System.out.printf("\nEnter number to add to %.4f: ", sum);
                        double c = scanner.nextDouble();
                        sum = sum + c;
                    }
                }
                System.out.printf("\nSum = %.4f\n", sum);
                break;
            }
            case 2: {
                double diff = a - b;
                int stop2 = 1;
                while (stop2 != 0) {
                    System.out.printf("%.4f", diff);
                    System.out.print("\nContinue?(press 0-stop or 1-continue): ");
                    stop2 = scanner.nextInt();
                    if (stop2 != 0) {
                        System.out.printf("\nEnter number to subtract from %.4f: ", diff);
                        double c = scanner.nextDouble();
                        diff = diff - c;
                    }
                }
                System.out.printf("\nDifference = %.4f\n", diff);
                break;
            }
            case 3: {
                double prod = a * b;
                int stop3 = 1;
                while (stop3 != 0) {
                    System.out.printf("%.4f", prod);
                    System.out.print("\nContinue?(Press 0-stop or 1 -continue): ");
                    stop3 = scanner.nextInt();
                    if (stop3 != 0) {
                        System.out.printf("\nEnter number to multiply with %.4f: ", prod);
                        double c = scanner.nextDouble();
                        prod = prod * c;
                    }
                }
                System.out.printf("\nProduct = %.4f\n", prod);
                break;
            }
            case 4: {
                if (b == 0) {
                    System.out.println("Division by 0 is not possible");
                } else {
                    double div = a / b;
                    double rem = a % b;
                    int stop;
                    do {
                        System.out.printf("Division = %.4f & Remainder = %.4f", div, rem);
                        System.out.print("\nContinue? (0 = Stop, 1 = Continue): ");
                        stop = scanner.nextInt();
                        if (stop == 1) {
                            System.out.printf("Enter number to divide %.4f / ", div);
                            double c = scanner.nextDouble();
                            if (c == 0) {
                                System.out.println("Division by 0 not allowed!");
                                continue;
                            }
                            rem = div % c;
                            div = div / c;
                        }
                    } while (stop != 0);
                    System.out.printf("\nFinal Division = %.4f & Final Remainder = %.4f\n", div, rem);
                }
                break;
            }
            default:
                System.out.println("### Invalid choice ###");
        }
    }

}

