package NumberGuessingGame;

public class Game {
    private final int SystemNumber = (int) (Math.random() * 100) + 1;
    private int Chances;

    public Game(int challenge) {
        switch (challenge) {
            case 1 :
                Chances = 10;
                break;
            case 2:
                Chances = 5;
                break;
            case 3:
                Chances = 3;
                break;
        }
    }

    public int getSystemNumber() {
        return this.SystemNumber;
    }
    public int getChances() {
        return this.Chances;
    }
}