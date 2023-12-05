package sample;

public class Move {
    private Square start;
    private Square end;
    private Piece pieceMoved;
    private Piece pieceCaptured;

    public Move(Square start, Square end, Piece pieceMoved, Piece pieceCaptured) {
        this.start = start;
        this.end = end;
        this.pieceMoved = pieceMoved;
        this.pieceCaptured = pieceCaptured;
    }

    @Override
    public String toString() {
        // Customize this based on how you want to display the moves.
        String moveString = pieceMoved.getType() + " from " + start.getName();
        System.out.println("piece moved");
        moveString += " to " + end.getName();
        if (pieceCaptured != null) {
            moveString += " capturing " + pieceCaptured.getType();
            System.out.println("piece killed");
        }
        return moveString;
    }
}