package sample;

import java.util.Stack;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Pane chessBoardContainer; // Container for the chessboard
    @FXML
    private ListView<String> movesList; // ListView for recent moves

    private Game game; // Store the game reference

    public void initialize() {
        game = new Game("Coral");
        game.setController(this); // Pass this controller instance to the game
        
        // Set up the chessboard in the UI
        chessBoardContainer.getChildren().clear();
        chessBoardContainer.getChildren().add(game.getChessBoard().getChessBoard());

        // Initialize the moves list
        updateMovesList();
    }

    // Call this method whenever a move is made in the game
    public void updateMovesList() {
        if (game != null && game.getChessBoard() != null) {
            Stack<Move> moveHistory = game.getChessBoard().getMoveHistory();
            
            // Run on the JavaFX Application Thread
            Platform.runLater(() -> {
                movesList.getItems().clear(); // Clear the current list
                moveHistory.forEach(move -> movesList.getItems().add(move.toString())); // Add all moves to the list
            });
        }
    }

    // Setter method for the game, if not already present in Game class
    public void setGame(Game game) {
        this.game = game;
    }
}