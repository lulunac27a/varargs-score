import java.util.ArrayList;
import java.util.Scanner;

public class NumberLoopSum {

    private static int score(ArrayList<Integer> args) {
        int score = 0; // initialize the values
        int combo = 0;

        for (int i = 0; i < args.size(); i++) {
            if (args.get(i) == 1) { // add score and increase combo if the value is 1
                combo++;
                score += combo;
            } else if (args.get(i) == 0) { // reset combo to 0
                combo = 0;
            }
        }
        return score;
    }

    private static int calculateScoreWithMultiplier(ArrayList<Integer> args) {
        int score = 0; // initialize the values
        int multiplier = 1;
        for (int i = 0; i < args.size(); i++) { // add score and increase multiplier
            score += args.get(i) * multiplier;
            multiplier++;
        }
        return score;
    }

    private static double calculateScoreWithExponentialMultiplier(
            ArrayList<Integer> args) {
        double score = 0; // initialize the values
        double multiplier = 1; // multiplier is exponential
        for (int i = 0; i < args.size(); i++) { // add score and increase multiplier exponentially
            score += args.get(i) * multiplier;
            multiplier += multiplier / (1 + Math.log(multiplier));
        }
        return Math.floor(score);
    }

    public static void main(String[] args) {
        boolean exit = false;
        ArrayList<Integer> scores = new ArrayList<>(); // get the list to pass the methods with varargs
        System.out.println(
                "Press 1 for original, 2 for a multiplier, 3 for a multiplier with exponential growth");
        Scanner sc = new Scanner(System.in); // get input
        int mode = sc.nextInt(); // get input for mode
        while (!exit) {
            if (mode == 1) { // score and combo mode — enter 1 and 2
                System.out.println(
                        "Press 1 to increase combo and increase score, 2 to reset combo, 0 to end");
                int number = sc.nextInt(); // get input for 0, 1 or 2
                if (number == 0) {
                    exit = true; // exit the program
                    System.out.println("Score: " + score(scores)); // print the final score
                }
                if (number == 1) {
                    scores.add(1); // add score and increase combo by 1
                }
                if (number == 2) {
                    scores.add(0); // reset combo to 1
                }
            }
            if (mode == 2) { // score multiplier mode - enter 1 to 9
                System.out.println(
                        "Enter 1-9 to add score and increase multiplier, 0 to end");
                String numberStr = sc.next(); // get input and then get the first digit of integer input
                if ("0".equals(numberStr)) {
                    exit = true; // exit the program
                    System.out.println("Score: " + calculateScoreWithMultiplier(scores)); // print the final score
                } else {
                    int sum = 0; // initialize sum to 0
                    for (int i = 0; i < numberStr.length(); i++) { // add the sum of the digits
                        sum += Character.getNumericValue(numberStr.charAt(i)); // get the numeric value between 0 and 9
                    }
                    scores.add(sum); // add the score and increase multiplier exponentially
                }
            }
            if (mode == 3) { // score multiplier mode with exponential growth — enter 1 to 9
                System.out.println(
                        "Enter 1-9 to add score and increase multiplier, 0 to end");
                String numberStr = sc.next(); // get input and then get the first digit of integer input
                if ("0".equals(numberStr)) {
                    exit = true; // exit the program
                    System.out.println(
                            "Score: " + calculateScoreWithExponentialMultiplier(scores)); // print the final score
                } else {
                    int sum = 0; // initialize sum to 0
                    for (int i = 0; i < numberStr.length(); i++) { // add the sum of the digits
                        sum += Character.getNumericValue(numberStr.charAt(i)); // get the numeric value between 0 and 9
                    }
                    scores.add(sum); // add the score and increase multiplier exponentially
                }
            }
        }
        sc.close(); // close the scanner input to avoid resource leak
    }
}
