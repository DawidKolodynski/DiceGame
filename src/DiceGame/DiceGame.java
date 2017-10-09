package DiceGame;


import java.util.Scanner;

public class DiceGame {
//    W grze w kości bierze udział dwóch graczy o nazwach: pierwszy, drugi. Każdemu graczowi przypada 5 tur, w każdej turze,
//    gracz wykonuje maksymalnie 10 rzutów dwoma kośćmi jednocześnie. Tury graczy odbywają się naprzemiennie tzn. grę zaczyna
//    gracz pierwszy, po turze następuje tura gracza drugiego, następna jest tura gracza pierwszego itd. Możliwe wyniki rzutu
//    jedna kością to jedna z następujących cyfr {1, 2, 3, 4, 5, 6}. Grę zawsze rozpoczyna gracz ”pierwszy”.
//
//    Podczas każdej tury gracz zbiera punkty według zasad opisanych poniżej: Suma punktów każdego gracza przed rozpoczęciem gry
//    wynosi zero. Wygrywa gracz, który zbierze mniejsza ilość punktów. Napisz program symulujący grę w kości.Standardowe wejście
//    programu to dwie cyfry ze zbioru {1, 2, 3, 4, 5, 6} oznaczające liczbę oczek na poszczególnych kościach w danym rzucie.
//    Pary cyfr podawane są kolejno. W każdym rzucie wczytywana jest nowa para cyfr oznaczająca wynik rzutu kośćmi danego gracza.
//
//    Standardowe wyjście zależy od sumy oczek z obydwu kości w danym rzucie w następujący sposób:
//
//   1. Gdy gracz w swojej turze w pierwszym rzucie uzyska sumę oczek z obu kości równa 7 lub 11, wygrywa. Na standardowe wyjście powinien
//    zostać wypisany komunikat o wyniku gracza w danej turze: "Gracz nazwa_gracza wygrał". Aktualnie wykonywana tura powinna zostać
//    przerwana i rozpocząć tura przeciwnika.
//   2. Gdy gracz w swojej turze w pierwszym rzucie uzyska sumę oczek z obu kości równa 2 lub 12, przegrywa. Na standardowe wyjście powinien
//    zostać wypisany komunikat o wyniku gracza w danej turze: "Gracz nazwa_gracza przegrał". Aktualnie wykonywana tura powinna zostać
//    przerwana i rozpocząć tura przeciwnika. Do punktów gracza doliczone są punkty w liczbie równej ilości rzutów w danej turze.
//   3. Gdy gracz w swojej turze uzyska sumę oczek z obu kości równa 5, wygrywa, kończy swoja turę, rozpoczyna się tura przeciwnika.
//    Na standardowe wyjście powinien zostać wypisany komunikat o wyniku gracza w danej turze: "Gracz nazwa_gracza wygrał".
//   4. Gdy gracz w swojej turze uzyska sumę oczek z obu kości inna niż opisane powyżej do punktów gracza doliczona zostaje suma oczek
//    uzyskanych w danym rzucie podzielona przez numer rzutu w danej turze. Po zakończeniu wszystkich tur obydwu graczy na standardowe
//    wyjście zostaje wypisany komunikat o sumie punktów zdobytych przez każdego z graczy oraz który z graczy wygrał.

    static Scanner scanner = new Scanner(System.in);
    static Player player1 = new Player("pierwszy");
    static Player player2 = new Player("drugi");

    static int points1;
    static int points2;

    public static void main(String[] args) {
        System.out.println("Zaczynamy grę.");
        int currentRound;
        int gamesCount = readGamesCount();

        ScoringSystem scoringSystem = new ScoringSystem(gamesCount, player1.getName(), player2.getName());

        playRound(gamesCount);
    }

    private static void playRound(int gamesCount) {
        for (int currentRound = 1; currentRound <= gamesCount; currentRound++) {
            System.out.println("=========================");
            System.out.println(String.format("\t\tRunda %d/%d", currentRound, gamesCount));
            System.out.println("=========================");
            for (int i = 1; i <= 2; i++) {
                points1 = player1.isThrowing();
                points2 = player2.isThrowing();
                GameResult result = roundResult();

                switch (result) {
                    case P1:
                        System.out.println(String.format("Wygraywa gracz %s", player1.getName()));
                        break;
                    case P2:
                        System.out.println(String.format("Wygraywa gracz %s", player2.getName()));
                        break;
                    case TIE:
                        System.out.println(String.format("Remis"));
                        break;
                    default:
                        System.out.println("Coś nie wyszło");
                }
            }
        }
    }

    private static GameResult roundResult() {
        System.out.println(String.format("Wynik rundy: %s - %d || %s - %d ", player1.getName(), points1, player2.getName(), points2));
        if (points1 > points2)
            return GameResult.P2;
        else if (points2 > points1)
            return GameResult.P1;
        else
            return GameResult.TIE;
    }

    private static int readGamesCount() {
        System.out.println("Podaj ilość gier: ");
        int count = scanner.nextInt();
        return count;
    }
}
