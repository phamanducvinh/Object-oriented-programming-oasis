import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    private ArrayList<Piece> pieces;

    public Board() {
        pieces = new ArrayList<>();
    }

    public boolean validate(int x, int y) {
        return (1 <= x && x <= 8 && 1 <= y && y < +8);
    }

    /**
     * Process.
     */
    private Piece find(int x, int y) {
        for (Piece piece : pieces) {
            if (x == piece.getCoordinatesX()
                    && y == piece.getCoordinatesY()) {
                return piece;
            }
        }
        return null;
    }

    /**
     * Process.
     */
    public void addPiece(Piece piece) {
        if (!validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            return;
        }

        if (find(piece.getCoordinatesX(), piece.getCoordinatesY()) != null) {
            return;
        }

        this.pieces.add(piece);
    }

    public Piece getAt(int x, int y) {
        return find(x, y);
    }

    /**
     * Process.
     */
    public void removeAt(int x, int y) {
        Piece piece = find(x, y);
        if (piece != null) {
            this.pieces.remove(piece);
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
