public class Set {
    public static Game.Result play() {
        int firstResult = rollDice();
        return switch (firstResult) {
            case 2, 3, 12 -> Game.Result.LOSS;
            case 7, 11 -> Game.Result.WIN;
            //default-> nextRoll(firstResult);
            default-> {
                int diceResult = rollDice();
                while (diceResult != firstResult && diceResult != 7) {
                    diceResult = rollDice();
                }
                yield  diceResult == firstResult ? Game.Result.WIN : Game.Result.LOSS;
            }
        };
    }

    private static Game.Result nextRoll(int firstResult){
        int diceResult = rollDice();
        while (diceResult != firstResult && diceResult != 7) {
            diceResult = rollDice();
        }
        return diceResult == firstResult ? Game.Result.WIN : Game.Result.LOSS;
    }

    private static int rollDice() {
        System.out.print("Roll dice (press Enter):");
        Game.in.nextLine();
        int dice1 = Game.random.nextInt(1, 7);
        int dice2 = Game.random.nextInt(1, 7);
        System.out.printf("%d + %d = %d%n", dice1, dice2, (dice1 + dice2));

        return dice1 + dice2;
    }
}
