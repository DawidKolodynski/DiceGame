package DiceGame;

import java.util.Random;

public class Player {
    String name;
    int toss;

    public Player(String name) {
        this.name = name;
    }

    public int isThrowing() {
        Random random = new Random();
        toss = random.nextInt(6) + 1;
        return toss;
    }
//
//    public int score(int toss) {
//
//        int score =+ toss;
//
//     return score;
//    }

    public String scoreBoard(Player player, int score) {
        String result = "Wynik gracza " + player.name + " to: " + score;
        System.out.println(result);
        return result;
    }

    public String getName() {
        return name;
    }
}
