import java.util.Scanner;

public class Game {
    public static Scanner in = new Scanner(System.in);
    private int sum;

    public Game(int sum) {
        this.sum = sum;
        System.out.printf("You have %d%n", this.sum);
    }

    public void play() {

        String repeat = "y";
        while (repeat.equals("y")) {
            System.out.printf("Make your bet: ");
            int bet = in.nextInt();
            in.nextLine();
            while (bet > sum) {
                System.out.printf("Too much, repeat your bet: ");
                bet = in.nextInt();
                in.nextLine();
            }

            Set set = new Set();

            Result result = set.play();

            if (result == Result.WIN) {
                sum += bet;
                System.out.println("You win");
            } else {
                sum -= bet;
                System.out.println("You lost");
            }
            System.out.printf("You have %d%n", sum);
            if (sum > 0) {
                System.out.println("Do you want to continue (y/n)?");
                repeat = in.nextLine();
            } else {
                System.out.println("See you later. Get luck next time!");
                repeat = "n";
            }
        }

    }

}
