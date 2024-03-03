import java.util.Random;

public class Set {

    Random random = new Random();

    public Result play() {

        int diceResult = rollDice();
        Result result;

        switch (diceResult) {
            case 2, 3, 12 -> result = Result.LOSS;
            case 7, 11 -> result = Result.WIN;
            default -> {
                int diceResult2 = rollDice();
                while (diceResult2 != diceResult && diceResult2 != 7) {
                    diceResult2 = rollDice();
                }
                result = (diceResult2 == diceResult) ? Result.WIN : Result.LOSS;
            }
        }
        return result;
    }

    public int rollDice() {

        System.out.print("Roll dice (press Enter):");
        Game.in.nextLine();
        int dice1 = random.nextInt(1, 7);
        int dice2 = random.nextInt(1, 7);
        System.out.printf("%d + %d = %d%n", dice1, dice2, (dice1 + dice2));

        return dice1 + dice2;

    }
}
