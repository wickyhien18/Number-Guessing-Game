public class Game {
    //Initialize random number
    private final int SystemNumber = (int) (Math.random() * 100) + 1;
    private int Chances;
    private int Hints;
    private int Highest = 0;

    //Set number of chances
    public Game(int challenge, int h) {
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
        switch (h) {
            case 1 :
                Hints = 5;
                break;
            case 2:
                Hints = 3;
                break;
            case 3:
                Hints = 2;
                break;
        }
    }

    public int getSystemNumber() {
        return this.SystemNumber;
    }
    public int getChances() {
        return this.Chances;
    }
    public int getHints() {
        return this.Hints;
    }
    public void setHighest(int h) {
        this.Highest = h;
    }
    public int getHighest() { return this.Highest;}
}