package modules.game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static void start() {

        System.out.println("=======================================");
        System.out.println("     🎮 WELCOME TO JAVA GAME ZONE 🎮    ");
        System.out.println("=======================================");
        System.out.println("✨ Play • Learn • Enjoy ✨");
        System.out.println("=======================================\n");

        String choice = "";

        while (!choice.equalsIgnoreCase("Q")) {

            System.out.println("\nChoose a Game:");
            System.out.println("1. Random Number Guessing");
            System.out.println("2. Quit Challenge Game");
            System.out.println("3. Mad Libs Story");
            System.out.println("4. Coin Flip");
            System.out.println("5. Dice Roll");
            System.out.println("6. Dice Guessing");
            System.out.println("7. Rock Paper Scissors");
            System.out.println("8. Math Quiz");
            System.out.println("Q. Quit");

            System.out.print("Enter your choice: ");
            choice = scanner.next();

            System.out.println();

            switch (choice.toUpperCase()) {

                case "1":
                    RandomNo();
                    break;

                case "2":
                    SmallGame();
                    break;

                case "3":
                    madlibs();
                    break;

                case "4":
                    flipcoin();
                    break;

                case "5":
                    DiceProgram();
                    break;

                case "6":
                    DiceNoGuessing();
                    break;

                case "7":
                    rockPaperScissors();
                    break;

                case "8":
                    MathQuiz();
                    break;

                case "Q":
                    System.out.println("🙏 Thank you for playing!");
                    System.out.println("See you again 🎮✨");
                    break;

                default:
                    System.out.println("❌ Invalid Choice! Try again.");
            }
        }
    }

    static void RandomNo() {
        System.out.println("**************************************");
        System.out.println("Welcome to Random no. guessing game");
        System.out.println("**************************************");
        int num1 = random.nextInt(1, 101);
        int number;
        int count = 0;
        do {
            System.out.print("Guess a number between 1 - 100 :");
            number = scanner.nextInt();
            if (number < 0 || number > 100) {
                System.out.println("Invalid guess");
            } else {
                if (num1 == number) {
                    System.out.println("You guessed right");
                } else if (number > num1) {
                    System.out.println("You guessed higher no.");
                } else if (number < num1) {
                    System.out.println("You guessed a lower number");
                }
                count++;
            }
        } while (num1 != number);
        System.out.println("You guessed the game in " + count + " tries");

    }

    static void SmallGame() {
        int count = 0;
        String response = "";
        System.out.println("You are playing a game:😡😡😡 Quit😤😤😤");
        while (!response.equals("Q")) {
            System.out.println("😡😡😡Man! Quit Now😤😤😤You cannot survive more😡😡");
            System.out.print("Press Q to quit : ");
            response = scanner.next().toUpperCase();
            count++;
        }
        System.out.println("You have quit the game 😎 Bad Luck \n Score = " + count + "\n Try again ");
    }

    static void madlibs() {
        int num1 = random.nextInt(1, 6);
        scanner.nextLine();
        switch (num1) {
            case 1:
                String adjective1;
                String noun1;
                String adjective2;
                String verb1;
                String adjective3;
                System.out.println("Enter an adjective (description): ");
                adjective1 = scanner.nextLine();
                System.out.println("Enter an noun (animal or person): ");
                noun1 = scanner.nextLine();
                System.out.println("Enter an adjective (description): ");
                adjective2 = scanner.nextLine();
                System.out.println("Enter a verb (action): ");
                verb1 = scanner.nextLine();
                System.out.println("Enter an adjective (description): ");
                adjective3 = scanner.nextLine();
                System.out.println("\nToday,I went to a " + adjective1 + " zoo");
                System.out.println("In an exhibit i saw a " + noun1 + ".");
                System.out.println(noun1 + " was " + adjective2 + " and " + verb1 + "!");
                System.out.println("I was " + adjective3 + "!");
                break;
            case 2:
                String adjective;
                String teacher;
                String subject;
                String verb;
                String place;

                System.out.println("Enter an adjective: ");
                adjective = scanner.nextLine();

                System.out.println("Enter a teacher name: ");
                teacher = scanner.nextLine();

                System.out.println("Enter a subject: ");
                subject = scanner.nextLine();

                System.out.println("Enter a verb: ");
                verb = scanner.nextLine();

                System.out.println("Enter a place: ");
                place = scanner.nextLine();

                System.out.println("\nToday my " + adjective + " teacher " + teacher + " taught us " + subject + ".");
                System.out.println("Suddenly he started to " + verb + " in the middle of class!");
                System.out.println("Then everyone ran to the " + place + "!");
                break;
            case 3:
                String planet;
                String adjective8;
                String alienName;
                String verb2;
                String food;

                System.out.println("Enter a planet: ");
                planet = scanner.nextLine();

                System.out.println("Enter an adjective: ");
                adjective8 = scanner.nextLine();

                System.out.println("Enter an alien name: ");
                alienName = scanner.nextLine();

                System.out.println("Enter a verb: ");
                verb2 = scanner.nextLine();

                System.out.println("Enter a food item: ");
                food = scanner.nextLine();

                System.out.println("\nYesterday I traveled to planet " + planet + ".");
                System.out.println("There I met a " + adjective8 + " alien named " + alienName + ".");
                System.out.println("We started to " + verb2 + " together.");
                System.out.println("Then we ate " + food + " for dinner!");
                break;
            case 4:
                String heroName;
                String power;
                String villain;
                String action;
                String city;

                System.out.println("Enter a superhero name: ");
                heroName = scanner.nextLine();

                System.out.println("Enter a superpower: ");
                power = scanner.nextLine();

                System.out.println("Enter a villain name: ");
                villain = scanner.nextLine();

                System.out.println("Enter an action verb: ");
                action = scanner.nextLine();

                System.out.println("Enter a city name: ");
                city = scanner.nextLine();

                System.out.println("\nThe mighty " + heroName + " protects the city of " + city + ".");
                System.out.println("One day the evil " + villain + " attacked!");
                System.out.println(heroName + " used the power of " + power + " to " + action + " the villain.");
                System.out.println("The city was saved!");
                break;
            case 5:
                String food1;
                String adjective7;
                String animal;
                String verb7;
                String place7;

                System.out.println("Enter a food: ");
                food1 = scanner.nextLine();

                System.out.println("Enter an adjective: ");
                adjective7 = scanner.nextLine();

                System.out.println("Enter an animal: ");
                animal = scanner.nextLine();

                System.out.println("Enter a verb: ");
                verb7 = scanner.nextLine();

                System.out.println("Enter a place: ");
                place7 = scanner.nextLine();

                System.out.println("\nI was eating a " + food1 + " when suddenly a " + adjective7 + " " + animal + " appeared!");
                System.out.println("The " + animal + " started to " + verb7 + " loudly.");
                System.out.println("So I ran away to the " + place7 + "!");
                break;
        }
    }

    static void flipcoin() {
        System.out.println("Welcome to coin flipping Game");

        String response = "";
        int point = 0;

        while (!response.equalsIgnoreCase("Q")) {

            System.out.print("Choose 'H' for Head & 'T' for Tail: ");
            String choice = scanner.next().toUpperCase();

            String P = (random.nextInt(2) == 0) ? "H" : "T";

            System.out.println("Flipping coin....... Result: " + P);

            if (P.equals(choice)) {
                System.out.println("Correct Guess");
                point++;
            } else {
                System.out.println("Incorrect Guess");
            }

            System.out.print("Press Q to quit or any key to continue: ");
            response = scanner.next();
        }

        System.out.println("Final Score = " + point);
    }

    static void DiceProgram() {
        int noOfDice;
        int total = 0;
        System.out.print("Enter no. of Dice:");
        noOfDice = scanner.nextInt();
        if (noOfDice > 0) {
            for (int i = 1; i <= noOfDice; i++) {
                int roll = random.nextInt(1, 7);
                System.out.println("You rolled: " + roll);
                printDie(roll);
                total += roll;
            }
            System.out.println("Total: " + total);

        } else {
            System.out.println("No. of dice must be greater than 0");
        }
    }

    static void DiceNoGuessing() {
        System.out.println("Welcome to Dice Number Gaming");

        String response = "";
        int point = 0;

        while (!response.equalsIgnoreCase("Q")) {

            System.out.print("Choose 1 to 6 : ");
            int choice = scanner.nextInt();
            if (choice < 1 || choice > 6) {
                System.out.println("Please choose correct number");
            } else {
                int num1 = random.nextInt(1, 7);
                System.out.println("Rolling Dice....... Result: " + num1);
                if (choice == num1) {
                    System.out.println("Wow! You guessed correct");
                    point++;
                } else {
                    System.out.println("Incorrect Guess");
                }
            }
            System.out.print("Press Q to quit or any key to continue: ");
            response = scanner.next();
        }

        System.out.println("Final Score = " + point);
    }


    static void printDie(int roll) {
        switch (roll) {
            case 1 -> System.out.println("""
                     _________
                    |         |
                    |    *    |
                    |         |
                    |_________|                    """);
            case 2 -> System.out.println("""
                     _________
                    | *       |
                    |         |
                    |       * |
                    |_________|                    """);
            case 3 -> System.out.println("""
                     _________
                    | *       |
                    |    *    |
                    |       * |
                    |_________|                     """);
            case 4 -> System.out.println("""
                     _________
                    | *     * |
                    |         |
                    | *     * |
                    |_________|                     """);
            case 5 -> System.out.println("""
                     _________
                    | *     * |
                    |    *    |
                    | *     * |
                    |_________|                   """);
            case 6 -> System.out.println("""
                     _________
                    | *     * |
                    | *     * |
                    | *     * |
                    |_________|                     """);
        }
    }

    static void rockPaperScissors() {
        System.out.println("Welcome to Rock Paper Scissors Game!");

        String response = "";
        int userScore = 0;
        int compScore = 0;

        while (!response.equalsIgnoreCase("Q")) {

            System.out.print("Enter R (Rock), P (Paper), S (Scissors): ");
            String user = scanner.next().toUpperCase();

            int num = random.nextInt(3);
            String comp = "";

            if (num == 0) comp = "R";
            else if (num == 1) comp = "P";
            else comp = "S";

            System.out.println("Computer chose: " + comp);

            if (user.equals(comp)) {
                System.out.println("It's a Draw!");
            } else if (
                    (user.equals("R") && comp.equals("S")) ||
                            (user.equals("P") && comp.equals("R")) ||
                            (user.equals("S") && comp.equals("P"))
            ) {
                System.out.println("You Win!");
                userScore++;
            } else {
                System.out.println("Computer Wins!");
                compScore++;
            }

            System.out.println("Score → You: " + userScore + " | Computer: " + compScore);

            System.out.print("Press Q to quit or any key to continue: ");
            response = scanner.next();
        }

        System.out.println("Final Score → You: " + userScore + " | Computer: " + compScore);
    }

    static void MathQuiz() {
        System.out.println("Welcome to Math Quiz");

        String res = "";
        int score = 0;
        int attempts = 0;

        while (!res.equalsIgnoreCase("Q")) {

            System.out.print("Choose Level (0 Easy, 1 Medium, 2 Hard): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            int op = random.nextInt(3); // 0:+, 1:-, 2:*
            int a = 0, b = 0;

            if (choice == 0) {
                if (op == 2) {
                    a = random.nextInt(0, 10);
                    b = random.nextInt(0, 10);
                } else {
                    a = random.nextInt(0, 100);
                    b = random.nextInt(0, 100);
                }
            }
            else if (choice == 1) {
                if (op == 2) {
                    a = random.nextInt(10, 20);
                    b = random.nextInt(10, 20);
                } else {
                    a = random.nextInt(100, 1000);
                    b = random.nextInt(100, 1000);
                }
            }
            else if (choice == 2) {
                if (op == 2) {
                    a = random.nextInt(15, 50);
                    b = random.nextInt(15, 50);
                } else {
                    a = random.nextInt(1000, 10000);
                    b = random.nextInt(1000, 10000);
                }
            }
            else {
                System.out.println("Invalid Choice");
                continue;
            }

            int correct = 0;
            String symbol = "";

            switch (op) {
                case 0:
                    correct = a + b;
                    symbol = "+";
                    break;
                case 1:
                    correct = a - b;
                    symbol = "-";
                    break;
                case 2:
                    correct = a * b;
                    symbol = "X";
                    break;
            }

            System.out.print(a + " " + symbol + " " + b + " = ");
            int userAns = scanner.nextInt();

            attempts++;

            if (userAns == correct) {
                System.out.println("Correct Answer");
                score++;
            } else {
                System.out.println("Wrong! Answer is " + correct);
            }

            System.out.println("Score: " + score + "/" + attempts);

            System.out.print("Press Q to quit: ");
            res = scanner.next();
        }

        System.out.println("Final Score: " + score + "/" + attempts);
    }
}

