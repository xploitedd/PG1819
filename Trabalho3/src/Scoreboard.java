import isel.leic.pg.Console;

public class Scoreboard {

    private static final int[] levelScores = { 25, 50, 100, 200, 400 };
    public static Player highestScore;

    private static int score = 0;
    private static byte level = 1;

    public static void addPoints(int points) {
        if (points <= 0)
            return;

        Panel.printMessage("+" + points + ";points");

        for (int i = 1; i <= points; ++i) {
            ++score;
            Panel.printScore(score);
            Console.sleep(50);
        }

        if (level != 6 && score > levelScores[level - 1])
            nextLevel();
    }

    public static int getMaxColors() {
        return 9;
    }

    public static boolean endGame() {
        if (highestScore == null || highestScore.score <= score) {
            String name = Panel.highScore(score);
            highestScore = new Player(name, score);
            //Panel.printMessage("HS: " + highestScore.playerName);
        }

        if (Panel.continuePlaying()) {
            Scoreboard.reset();
            Panel.printGrid();
            return false;
        }

        return true;
    }

    public static void reset() {
        score = 0;
        level = 1;
        Panel.printLevel(1);
    }

    private static void nextLevel() {
        Panel.printLevel(++level);
    }
}
