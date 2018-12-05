public class Scoreboard {

    private static final int[] levelScores = { 25, 50, 100, 200, 400 };
    private static int score = 0;
    private static byte level = 1;

    public static void addPoints(int points) {
        score += points;
        if (level != 6 && score > levelScores[level - 1])
            nextLevel();

        Panel.printScore(score);
        Panel.printMessage("+" + points + ";points");
    }

    public static int getMaxColors() {
        return level + 3;
    }

    private static void nextLevel() {
        Panel.printLevel(++level);
    }
}
