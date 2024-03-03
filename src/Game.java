import java.util.Random;
import java.util.Scanner;

public class Game {
    public enum Result {WIN, LOSS}

    public static Scanner in = new Scanner(System.in);
    public static Random random = new Random();

    public static void play(int sum) {
        String repeat = "y";
        while (repeat.equals("y")) {
            int bet = getBet("Make your bet: ");
            while (bet > sum) {
                bet = getBet("Too much, repeat your bet: ");
            }

            String resultMessage = "";
            switch (Set.play())
            {
                case WIN -> {
                    sum += bet;
                    resultMessage = "You win";
                }
                case LOSS -> {
                    sum -= bet;
                    resultMessage = "You lost";
                }
            }
            System.out.printf("%s. You have %d%n", resultMessage, sum);

            if (sum == 0){
                System.out.println("See you later. Get luck next time!");
                return;
            }
            System.out.print("Do you want to continue (y/n)? : ");
            repeat = in.nextLine();
        }
    }
    private static int getBet(String prompt){
        System.out.print(prompt);
        int bet = in.nextInt();
        in.nextLine();
        return bet;
    }
}
