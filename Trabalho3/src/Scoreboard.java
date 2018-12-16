import isel.leic.pg.Console;

public class Scoreboard {

    private static final int SAVE_HIGHEST_SCORES = 10;

    private static final int[] levelScores = { 25, 50, 100, 200, 400 };
    private static final Player[] highestScores = new Player[SAVE_HIGHEST_SCORES];

    private static int score = 0;
    private static byte level = 0;

    /**
     * Adds the point dynamically to the score, and updates the level
     * @param points Points to add
     */
    public static void addPoints(int points) {
        if (points <= 0)
            return;

        Panel.printMessage("+" + points + ";points");

        // dynamic effect to add points
        for (int i = 1; i <= points; ++i) {
            ++score;
            Panel.printScore(score);
            Console.sleep(50);
        }

        // updates the level if the score is enough
        if (level != 6 && score > levelScores[level - 1])
            nextLevel();
    }

    /**
     * Gets the max colors based on the level
     * @return Max Colors
     */
    public static int getMaxColors() {
        return level + 3;
    }

    /**
     * Ends the current game and display's the current scoreboard
     * @return True if the player wants to play again, false otherwise
     */
    public static boolean endGame() {
        int hsIndex = hasNewHighScore();
        // if the player has a new high score then hsIndex will be different from -1
        if (hsIndex != -1) {
            String name = Panel.highScore(score);
            highestScores[hsIndex] = new Player(name, score);
        }

        // prints the highest scores table for 2s
        Panel.printScoreboard(highestScores);
        Console.sleep(2000);

        // asks the player whether the game should reset
        if (Panel.continuePlaying()) {
            Panel.printGrid();
            return false;
        }

        Console.stopMusic();
        return true;
    }

    /**
     * Resets the current score
     */
    public static void reset() {
        Console.stopMusic();

        score = 0;
        level = 0;
        nextLevel();
    }

    /**
     * Check if the player has a new high score and, if needed, sorts the scoreboard
     * for the new player
     * @return The index where the new player will be added
     */
    private static int hasNewHighScore() {
        // uses one iteration of insertion sort to add the player if needed
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

    /**
     * Updates the level
     */
    private static void nextLevel() {
        Panel.printLevel(++level);
        if (level == 1) {
            // plays music1 from level 1 to 5
            Console.startMusic("music1");
        } else if (level == 6) {
            // starts playing music2 when player reaches level 6
            Console.stopMusic();
            Console.startMusic("music2");
        }
    }
}
