import isel.leic.pg.Console;
import isel.leic.pg.Location;
import isel.leic.pg.MouseEvent;

import static java.awt.event.KeyEvent.*;

public class ColorFrames {

    public static final int BOARD_DIM = 3;  // [2..4] Dimension (lines and columns) of board
    public static final int FRAMES_DIM = 3; // [1..4] Number of frames in each place of of board
    public static final int NO_FRAME = -1;  // Special color to mark frame absence
    public static final int BOARD_PLACES = BOARD_DIM * BOARD_DIM;

    /**
     * Random generated piece.
     * Each position has the color of each frame [0 .. MAX_COLORS-1] or NO_FRAME indicates that frame does not exist.
     * Each index corresponds to one dimension of the frame.
     */
    private static int[] piece = new int[FRAMES_DIM];

    /**
     * Flag to finish the game
     */
    private static boolean terminate = false;
    private static boolean forceTerminate = false;

    public static void main(String[] args) {
        Panel.init();
        Panel.printMessage("Welcome");
        playGame();
        Panel.printMessageAndWait("BYE");
        Panel.end();
    }

    private static void playGame() {
        do {
            long time = System.currentTimeMillis();
            terminate = false;

            int key;
            Board.resetBoard();
            generatePiece();
            printPiece();
            do {
                key = Console.waitKeyPressed(1000);
                if (key > 0) {
                    processKey(key);
                    Console.waitKeyReleased(key);
                } else if (key == Console.MOUSE_EVENT) {
                    processMouseEvent();
                } else Panel.printMessage("");
            } while (!terminate && !forceTerminate);
        } while (!forceTerminate && !Scoreboard.endGame());
    }

    private static void processKey(int key) {
        if (key == VK_ESCAPE) terminate = true;
        int gridNum = 0;
        if (key >= VK_1 && key <= VK_9)
            gridNum = key - VK_1 + 1;
        else if (key >= VK_NUMPAD1 && key <= VK_NUMPAD9 )
            gridNum = key - VK_NUMPAD1 + 1;
        else if (key >= VK_A && key <= VK_Z)
            gridNum = key - VK_A + 10;

        if (gridNum >= 1 && gridNum <= BOARD_PLACES)
            putPieceInBoard(gridNum);
    }

    private static void processMouseEvent() {
        Location loc = Console.getMouseEvent(MouseEvent.CLICK);
        if (loc == null)
            return;

        int x = loc.col;
        int y = loc.line;
        for (int i = 0; i < BOARD_DIM; ++i) {
            int minx = i * (Panel.GRID_SIZE + 1) + 1;
            int maxx = minx + Panel.GRID_SIZE - 1;

            int j = 0;
            for (; j < BOARD_DIM; ++j) {
                int miny = j * (Panel.GRID_SIZE + 1) + 1;
                int maxy = miny + Panel.GRID_SIZE - 1;

                if (x >= minx && x <= maxx && y >= miny && y <= maxy) {
                    putPieceInBoard(i + j + (BOARD_PLACES - BOARD_DIM + 1) - (BOARD_DIM + 1) * j);
                    break;
                }
            }

            if (j != BOARD_DIM)
                break;
        }
    }

    private static void putPieceInBoard(int gridNum) {
        if (Board.hasSpaceForPiece(piece, gridNum)) {
            Board.setPieceInBoard(piece, gridNum);
            generatePiece();
            printPiece();
        } else {
            Panel.printMessage("Invalid;move");
        }
    }

    private static void generatePiece() {
        for (int f = 0; f < FRAMES_DIM; ++f)  // Removes all frames
            piece[f] = NO_FRAME;

        int maxFrames = Board.getMaxFramesPerSquare();
        if (maxFrames == 0) {
            terminate = true;
            return;
        }

        int numOfFrames = 1 + (int) (Math.random() * (maxFrames - 1)); // Frames to generate
        for(int i = 0 ; i < numOfFrames ; ++i) {
            int frameSize;
            do frameSize = (int) (Math.random() * FRAMES_DIM);
            while (!Board.isFrameAvailable(frameSize) || piece[frameSize] != NO_FRAME);
            piece[frameSize] = (int) (Math.random() * Scoreboard.getMaxColors());
        }
    }

    private static void printPiece() {
        for (int f = 0; f < FRAMES_DIM; ++f) { // For each frame dimension
            int color = piece[f];
            if (color == NO_FRAME) Panel.clearFrame(f, 0); // Clean if does not exist with (f) dimension
            else Panel.printFrame(f, color, 0); // or Displays the frame with (f) dimension and (color)
        }
    }

}
