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

    public static void main(String[] args) {
        int exit = 0;
        ArrayList<Integer> scores = new ArrayList<>();

        while (exit != 1) {
            System.out.println("Press 1 to increase combo and increase score, 2 to reset combo, 0 to end");

            Scanner sc = new Scanner(System.in);
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
        }

    }
}