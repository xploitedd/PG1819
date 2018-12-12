import isel.leic.pg.Console;

public class Board {

    private static final int[][] pieces = new int[ColorFrames.BOARD_PLACES][ColorFrames.FRAMES_DIM];
    private static int pointsToAdd = 0;

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

    public static void resetBoard() {
        for (int i = 0; i < ColorFrames.BOARD_PLACES; ++i) {
            for (int j = 0; j < ColorFrames.FRAMES_DIM; ++j)
                pieces[i][j] = ColorFrames.NO_FRAME;
        }
    }

    public static boolean hasSpaceForPiece(int[] piece, int pos) {
        for (int f = 0; f < piece.length; ++f) {
            int color = piece[f];
            // a posição do array é pos - 1 porque a pos varia entre [1..BOARD_PLACES]
            if (color != ColorFrames.NO_FRAME && pieces[pos - 1][f] != ColorFrames.NO_FRAME)
                return false;
        }

        return true;
    }

    public static boolean isFrameAvailable(int frame) {
        for (int b = 0; b < ColorFrames.BOARD_PLACES; ++b) {
            if (pieces[b][frame] == ColorFrames.NO_FRAME)
                return true;
        }

        return false;
    }

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

    private static void checkGridPos(int pos) {
        int[] pcs = pieces[pos - 1];
        int f = 0;
        for (; f < ColorFrames.FRAMES_DIM; ++f) {
            int color = pcs[f];
            if (color != pcs[0] || color == ColorFrames.NO_FRAME)
                break;
        }

        if (f == ColorFrames.FRAMES_DIM) {
            clearGridPosition(pos);
            pointsToAdd += ColorFrames.BOARD_DIM;
        } else {
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

    private static void checkLine(int pos, int color) {
        int ppos = pos;
        while ((pos - 1) % ColorFrames.BOARD_DIM > 0 && pos > 1)
            --pos;

        check(pos, ppos, 1, color);
    }

    private static void checkColumn(int pos, int color) {
        int ppos = pos;
        while (pos - ColorFrames.BOARD_DIM > 0)
            pos -= ColorFrames.BOARD_DIM;

        check(pos, ppos, ColorFrames.BOARD_DIM, color);
    }

    private static void checkDiagonals(int pos, int color) {
        check(1, pos, ColorFrames.BOARD_DIM + 1, color);
        check(ColorFrames.BOARD_DIM, pos, ColorFrames.BOARD_DIM - 1, color);
    }

    private static void check(int pos, int ppos, int mp, int color) {
        int p = 0;
        for (; p < ColorFrames.BOARD_DIM; ++p) {
            int ps = p * mp + pos;
            if (ps != ppos) {
                int f = 0;
                for (; f < ColorFrames.FRAMES_DIM; ++f) {
                    if (pieces[ps - 1][f] == color)
                        break;
                }

                if (f == ColorFrames.FRAMES_DIM)
                    break;
            }
        }

        if (p == ColorFrames.BOARD_DIM) {
            for (int i = 0; i < ColorFrames.BOARD_DIM; ++i)
                clearGridPositionColor(i * mp + pos, color);
        }
    }

    private static boolean isInDiagonal(int pos) {
        for (int i = 0; i < ColorFrames.BOARD_DIM; ++i) {
            if (1 + i * (ColorFrames.BOARD_DIM + 1) == pos || ColorFrames.BOARD_DIM + i * (ColorFrames.BOARD_DIM - 1) == pos)
                return true;
        }

        return false;
    }

    private static void clearGridPosition(int pos) {
        for (int f = 0; f < ColorFrames.FRAMES_DIM; ++f)
            clearGridPositionFrame(pos, f);
    }

    private static void clearGridPositionFrame(int pos, int frame) {
        int color = pieces[pos - 1][frame];
        if (color != ColorFrames.NO_FRAME) {
            Console.sleep(200);
            Panel.clearFrame(frame, pos);
            pieces[pos - 1][frame] = ColorFrames.NO_FRAME;
        }
    }
    
    private static void clearGridPositionColor(int pos, int color) {
        for (int f = 0; f < ColorFrames.FRAMES_DIM; ++f) {
            int cl = pieces[pos - 1][f];
            if (cl == color) {
                clearGridPositionFrame(pos, f);
                ++pointsToAdd;
            }
        }
    }
}
