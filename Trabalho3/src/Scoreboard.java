import isel.leic.pg.Console;

public class Scoreboard {

    private static final int SAVE_HIGHEST_SCORES = 10;

    private static final int[] levelScores = { 25, 50, 100, 200, 400 };
    private static final Player[] highestScores = new Player[SAVE_HIGHEST_SCORES];

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
        return level + 3;
    }

    public static boolean endGame() {
        int hsIndex = hasNewHighScore();
        if (hsIndex != -1) {
            String name = Panel.highScore(score);
            highestScores[hsIndex] = new Player(name, score);
        }

        Panel.printScoreboard(highestScores);
        Console.sleep(2000);

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

    private static int hasNewHighScore() {
        for (int i = 0; i < highestScores.length; ++i) {
            if (highestScores[i] == null) {
                return i;
            } else if (highestScores[i].score < score) {
                for (int j = highestScores.length - 1; j > i; --j) {
                    Player p = highestScores[j - 1];
                    if (p != null)
                        highestScores[j] = p;
                }

                return i;
            }
        }

        return -1;
    }

    private static void nextLevel() {
        Panel.printLevel(++level);
    }
}
