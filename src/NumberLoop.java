import java.util.ArrayList;
import java.util.Scanner;

public class NumberLoop {
    private static int score(ArrayList<Integer> args) {
        int score = 0;// initialize the values
        int combo = 0;

        for (int i = 0; i < args.size(); i++) {
            if (args.get(i) == 1) {// add score and increase combo if value is 1
                combo++;
                score += combo;
            } else if (args.get(i) == 0) {// reset combo to 0
                combo = 0;
            }
        }
        return score;
    }

    private static int multiplier(ArrayList<Integer> args) {
        int score = 0;// initialize the values
        int multiplier = 1;
        for (int i = 0; i < args.size(); i++) {// add score and increase multiplier
            score += args.get(i) * multiplier;
            multiplier++;
        }
        return score;
    }

    private static double multiplierLog(ArrayList<Integer> args) {
        double score = 0;// initialize the values
        double multiplier = 1;// multiplier is exponential
        for (int i = 0; i < args.size(); i++) {// add score and increase multiplier exponentially
            score += args.get(i) * multiplier;
            multiplier += multiplier / (1 + Math.log(multiplier));
        }
        return Math.floor(score);
    }

    public static void main(String[] args) {
        int exit = 0;
        ArrayList<Integer> scores = new ArrayList<>();// get list to pass the methods with varargs
        System.out.println("Press 1 for original, 2 for multiplier, 3 for multiplier with exponential growth");
        Scanner sc = new Scanner(System.in);// get input
        int mode = sc.nextInt();// get input for mode
        while (exit != 1) {
            if (mode == 1) {// score and combo mode - enter 1 and 2
                System.out.println("Press 1 to increase combo and increase score, 2 to reset combo, 0 to end");
                int number = sc.nextInt();// get input for 0, 1 or 2
                if (number == 0) {
                    exit = 1;// exit the program
                    System.out.println("Score: " + score(scores));// print the final score
                }
                if (number == 1) {
                    scores.add(1);// add score and increase combo by 1
                }
                if (number == 2) {
                    scores.add(0);// reset combo to 1
                }
            }
            if (mode == 2) {// score multiplier mode - enter 1 to 9
                System.out.println("Enter 1-9 to add score and increase multiplier, 0 to end");
                int number = sc.nextInt();// get input and then get the first digit of integer input
                if (number == 0) {
                    exit = 1;// exit the program
                    System.out.println("Score: " + multiplier(scores));// print the final score
                } else {
                    int value = Character.getNumericValue(String.valueOf(Math.abs(Math.max(1, number))).charAt(0));// get
                                                                                                                   // the
                                                                                                                   // numeric
                                                                                                                   // value
                                                                                                                   // between
                                                                                                                   // 1
                                                                                                                   // and
                                                                                                                   // 9
                    scores.add(value);// add the score and increase multiplier by 1
                }
            }
            if (mode == 3) {// score multiplier mode with exponential growth - enter 1 to 9
                System.out.println("Enter 1-9 to add score and increase multiplier, 0 to end");
                int number = sc.nextInt();// get input and then get the first digit of integer input
                if (number == 0) {
                    exit = 1;// exit the program
                    System.out.println("Score: " + multiplierLog(scores));// print the final score
                } else {
                    int value = Character.getNumericValue(String.valueOf(Math.abs(Math.max(1, number))).charAt(0));// get
                                                                                                                   // the
                                                                                                                   // numeric
                                                                                                                   // value
                                                                                                                   // between
                                                                                                                   // 1
                                                                                                                   // and
                                                                                                                   // 9
                    scores.add(value);// add the score and increase multiplier exponentially
                }
            }
        }

    }
}