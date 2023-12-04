package sample;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(String color, int posX, int posY) {
        super(color, posX, posY);
        this.type = "Pawn";
        setImage();
    }

    @Override
    public void getAllPossibleMoves() {
        int x = this.posX;
        int y = this.posY;
        ArrayList<String> moves = new ArrayList<>();
        this.possibleMoves = new ArrayList<>();

        int direction = this.color.equals("black") ? 1 : -1; // Black pawns move down the board, white pawns move up.

        // Forward move
        String forwardMove = "Square" + x + (y + direction);
        if (getSquareByName(forwardMove) != null && !getSquareByName(forwardMove).occupied) {
            moves.add(forwardMove);
        }

        // Initial two-square move
        if ((this.color.equals("black") && y == 1) || (this.color.equals("white") && y == 6)) {
            String twoSquareMove = "Square" + x + (y + 2 * direction);
            if (getSquareByName(twoSquareMove) != null && !getSquareByName(twoSquareMove).occupied 
                && !getSquareByName(forwardMove).occupied) {
                moves.add(twoSquareMove);
            }
        }

        // Capture moves (diagonal)
        String[] diagonalMoves = {"Square" + (x + 1) + (y + direction), "Square" + (x - 1) + (y + direction)};
        for (String move : diagonalMoves) {
            if (getSquareByName(move) != null && getSquareByName(move).occupied 
                && !getPieceByName(move).getColor().equals(this.color)) {
                moves.add(move);
            }
        }

        // Add moves to possibleMoves
        for (String move : moves) {
            possibleMoves.add(move);
        }
    }


}
