package DiceGame;

public class ScoringSystem {
    private int points1;
    private int points2;

    private int maxRounds;
    private int currentRound;

    private String host;
    private String guest;

    public ScoringSystem(int maxRounds, String host, String guest) {
        this.maxRounds = maxRounds;
        this.host = host;
        this.guest = guest;
    }


    public int add(int toss) {
        int result;
        result =+ toss;

        return result;

    }
}
