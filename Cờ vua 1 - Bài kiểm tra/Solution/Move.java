public class Move {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private Piece movedPiece;
    private Piece killedPiece;

    /**
     * Constructor.
     */
    public Move(int startX, int startY, int endX, int endY, Piece piece) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.movedPiece = piece;
    }

    /**
     * Constructor.
     */
    public Move(int startX, int startY, int endX, int endY, Piece movedPiece, Piece killedPiece) {
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
        this.movedPiece = movedPiece;
        this.killedPiece = killedPiece;
    }

    /**
     * Process.
     */
    private String factoryX(int x) {
        if (x == 1) {
            return "a";
        }
        if (x == 2) {
            return "b";
        }
        if (x == 3) {
            return "c";
        }
        if (x == 4) {
            return "d";
        }
        if (x == 5) {
            return "e";
        }
        if (x == 6) {
            return "f";
        }
        if (x == 7) {
            return "g";
        }
        return "h";
    }

    /**
     * Process.
     */
    public String toString() {
        return movedPiece.getColor()
                + "-"
                + movedPiece.getSymbol()
                + factoryX(endX)
                + endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getEndX() {
        return endX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndY() {
        return endY;
    }

    public void setStartX(int x) {
        this.startX = x;
    }

    public void setStartY(int y) {
        this.startY = y;
    }

    public void setEndX(int x) {
        this.endX = x;
    }

    public void setEndY(int y) {
        this.endY = y;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getKilledPiece() {
        return killedPiece;
    }

    public void setKilledPiece(Piece killedPiece) {
        this.killedPiece = killedPiece;
    }
}
