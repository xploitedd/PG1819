import isel.leic.pg.Console;

public class Board {

    private static final int[][] pieces = new int[ColorFrames.BOARD_PLACES][ColorFrames.FRAMES_DIM];
    private static int pointsToAdd = 0;

    /**
     * Places a piece in the board
     * @param piece Piece to be placed in board
     * @param pos Board position to place the piece
     */
    public static void setPieceInBoard(int[] piece, int pos) {
        for (int f = 0; f < ColorFrames.FRAMES_DIM; ++f) { // For each frame dimension
            int color = piece[f];
            if (color != ColorFrames.NO_FRAME) {
                Panel.printFrame(f, color, pos); // Displays the frame with (f) dimension and (color)
                Panel.clearFrame(f, 0); // Clean the frame of piece.
                pieces[pos - 1][f] = color;
            }
        }

        checkGridPos(pos);
    }

    /**
     * Resets the board
     */
    public static void resetBoard() {
        for (int i = 0; i < ColorFrames.BOARD_PLACES; ++i) {
            for (int j = 0; j < ColorFrames.FRAMES_DIM; ++j)
                pieces[i][j] = ColorFrames.NO_FRAME;
        }
    }

    /**
     * Check if the board has space for the piece
     * @param piece Piece to be checked
     * @param pos Position in the board where the piece will be placed
     * @return True if it has space, false otherwise
     */
    public static boolean hasSpaceForPiece(int[] piece, int pos) {
        for (int f = 0; f < piece.length; ++f) {
            int color = piece[f];
            if (color != ColorFrames.NO_FRAME && pieces[pos - 1][f] != ColorFrames.NO_FRAME)
                return false;
        }

        return true;
    }

    /**
     * Checks if the piece is available
     * @param piece Piece to be checked
     * @return True if it is available, false otherwise
     */
    public static boolean isPieceAvailable(int[] piece) {
        /* Before this was checking if a frame was available,
           but now it's checking for the whole piece since the method
           implemented before could give bugs */

        for (int b = 1; b <= ColorFrames.BOARD_PLACES; ++b) {
            if (hasSpaceForPiece(piece, b))
                return true;
        }

        return false;
    }

    /**
     * Calculate the max number of frames that can be placed into the board
     * @return The maximum number of frames
     */
    public static int getMaxFramesPerSquare() {
        int max = 0;
        for (int b = 0; b < ColorFrames.BOARD_PLACES; ++b) {
            int frames = 0;
            for (int f = 0; f < ColorFrames.FRAMES_DIM; ++f) {
                if (pieces[b][f] == ColorFrames.NO_FRAME)
                    ++frames;
            }

            if (frames > max)
                max = frames;
        }

        return max;
    }

    /**
     * Checks a position of the grid for lines, columns and diagonals that have the same color
     * @param pos Position to be checked
     */
    private static void checkGridPos(int pos) {
        // Verifies if the colors in the position are all the same
        int[] pcs = pieces[pos - 1];
        int f = 0;
        for (; f < ColorFrames.FRAMES_DIM; ++f) {
            int color = pcs[f];
            if (color != pcs[0] || color == ColorFrames.NO_FRAME)
                break;
        }

        if (f == ColorFrames.FRAMES_DIM) {
            // If a piece is filled with one color only, then delete this piece
            clearGridPosition(pos);
        } else {
            // Verifies for lines, columns and diagonals that have colors different that NO_FRAME
            for (int fr = 0; fr < ColorFrames.FRAMES_DIM; ++fr) {
                int color = pcs[fr];
                if (color != ColorFrames.NO_FRAME) {
                    checkLine(pos, color);
                    checkColumn(pos, color);

                    if (isInDiagonal(pos))
                        checkDiagonals(pos, color);
                }
            }
        }

        Scoreboard.addPoints(pointsToAdd);
        pointsToAdd = 0;
    }

    /**
     * Check if a certain color forms a line
     * @param pos Position where we want to check
     * @param color Color we want to check
     */
    private static void checkLine(int pos, int color) {
        int ppos = pos;
        while ((pos - 1) % ColorFrames.BOARD_DIM > 0 && pos > 1)
            --pos;

        check(pos, ppos, 1, color);
    }

    /**
     * Check if a certain color forms a column
     * @param pos Position where we want to check
     * @param color Color we want to check
     */
    private static void checkColumn(int pos, int color) {
        int ppos = pos;
        while (pos - ColorFrames.BOARD_DIM > 0)
            pos -= ColorFrames.BOARD_DIM;

        check(pos, ppos, ColorFrames.BOARD_DIM, color);
    }

    /**
     * Check if a certain color forms a diagonal
     * @param pos Position where we want to check
     * @param color Color we want to check
     */
    private static void checkDiagonals(int pos, int color) {
        check(1, pos, ColorFrames.BOARD_DIM + 1, color);
        check(ColorFrames.BOARD_DIM, pos, ColorFrames.BOARD_DIM - 1, color);
    }

    /**
     * Checks a position base on its multiplier and the first element of the column, line or diagonal
     * @param pos First element of the line, column or diagonal
     * @param ppos Current position
     * @param mp Multiplier that indicates how much it's going to add between positions
     * @param color Color to be checked
     */
    private static void check(int pos, int ppos, int mp, int color) {
        int p = 0;
        for (; p < ColorFrames.BOARD_DIM; ++p) {
            int ps = p * mp + pos;
            if (ps != ppos) {
                int f = 0;
                for (; f < ColorFrames.FRAMES_DIM; ++f) {
                    if (pieces[ps - 1][f] == color)
                        break; // when a piece doesn't have the specified color
                }

                if (f == ColorFrames.FRAMES_DIM)
                    break;
            }
        }

        /* if has a line, column or diagonal with frames that have the same color
            clears those frames */
        if (p == ColorFrames.BOARD_DIM) {
            for (int i = 0; i < ColorFrames.BOARD_DIM; ++i)
                clearGridPositionColor(i * mp + pos, color);
        }
    }

    /**
     * Checks if a position is in a diagonal
     * @param pos Position to be checked
     * @return True if it's in a diagonal, false otherwise
     */
    private static boolean isInDiagonal(int pos) {
        for (int i = 0; i < ColorFrames.BOARD_DIM; ++i) {
            if (1 + i * (ColorFrames.BOARD_DIM + 1) == pos || ColorFrames.BOARD_DIM + i * (ColorFrames.BOARD_DIM - 1) == pos)
                return true;
        }

        return false;
    }

    /**
     * Clears a grid position
     * @param pos Position to be cleared
     */
    private static void clearGridPosition(int pos) {
        for (int f = 0; f < ColorFrames.FRAMES_DIM; ++f)
            clearGridPositionFrame(pos, f);
    }

    /**
     * Clears a frame in a position
     * @param pos Position where the frame is
     * @param frame Frame to be cleared
     */
    private static void clearGridPositionFrame(int pos, int frame) {
        // clears the frames with 200ms interval between each and adds a point
        int color = pieces[pos - 1][frame];
        if (color != ColorFrames.NO_FRAME) {
            Console.sleep(200);
            Panel.clearFrame(frame, pos);
            pieces[pos - 1][frame] = ColorFrames.NO_FRAME;
            ++pointsToAdd;
        }
    }

    /**
     * Clears all frames that have the specified color in a position
     * @param pos Position where the frames will be checked
     * @param color Color to be cleared
     */
    private static void clearGridPositionColor(int pos, int color) {
        for (int f = 0; f < ColorFrames.FRAMES_DIM; ++f) {
            int cl = pieces[pos - 1][f];
            if (cl == color) {
                clearGridPositionFrame(pos, f);
            }
        }
    }
}
