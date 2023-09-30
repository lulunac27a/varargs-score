import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int score(ArrayList<Integer> args) {
        int score = 0;
        int combo = 0;

        for (int i = 0; i < args.size(); i++) {
            if (args.get(i) == 1) {
                combo++;
                score += combo;
            } else if (args.get(i) == 0) {
                combo = 0;
            }
        }
        return score;
    }

    private static int multiple(ArrayList<Integer> args) {
        int score = 0;
        int multiplier = 1;
        for (int i = 0; i < args.size(); i++) {
            score += args.get(i) * multiplier;
            multiplier++;
        }
        return score;
    }

    public static void main(String[] args) {
        int exit = 0;
        ArrayList<Integer> scores = new ArrayList<>();
        System.out.println("Press 1 for original, 2 for multiplier");
        Scanner sc = new Scanner(System.in);
        int mode = sc.nextInt();
        while (exit != 1) {
            if (mode == 1) {
                System.out.println("Press 1 to increase combo and increase score, 2 to reset combo, 0 to end");
                int number = sc.nextInt();
                if (number == 0) {
                    exit = 1;
                    System.out.println("Score: " + score(scores));
                }
                if (number == 1) {
                    scores.add(1);
                }
                if (number == 2) {
                    scores.add(0);
                }
            } else if (mode == 2) {
                System.out.println("Enter 1-9 to add score and increase multiplier, 0 to end");
                int number = sc.nextInt();
                if (number == 0) {
                    exit = 1;
                    System.out.println("Score: " + multiple(scores));
                } else {
                    int value = Character.getNumericValue(String.valueOf(Math.abs(Math.max(1, number))).charAt(0));
                    scores.add(value);
                }
            }
        }

    }
}