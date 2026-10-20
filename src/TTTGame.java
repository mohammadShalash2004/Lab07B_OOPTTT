
import javax.swing.*;
import java.awt.*;

public class TTTGame extends JFrame {
    private final TTTBoard board;
    private final TTTTileButton[][] buttons;
    private final JLabel statusLabel;
    private char currentPlayer;
    private boolean gameOver;

    public TTTGame() {
        board = new TTTBoard();
        buttons = new TTTTileButton[3][3];
        currentPlayer = 'X';
        gameOver = false;

        setTitle("Tic Tac Toe");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        statusLabel = new JLabel(
                "Player X's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(statusLabel, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                TTTTileButton tile = new TTTTileButton(row, col);
                buttons[row][col] = tile;
                boardPanel.add(tile);

                tile.addActionListener(e -> handleMove(tile));
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        JButton resetButton = new JButton("New Game");
        resetButton.setFont(new Font("Arial", Font.BOLD, 18));
        resetButton.addActionListener(e -> resetGame());
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void handleMove(TTTTileButton tile) {
        if (gameOver) {
            return;
        }

        int row = tile.getRow();
        int col = tile.getCol();

        if (!board.makeMove(row, col, currentPlayer)) {
            return;
        }

        tile.setText(String.valueOf(currentPlayer));

        if (currentPlayer == 'X') {
            tile.setForeground(Color.BLUE);
        } else {
            tile.setForeground(Color.RED);
        }

        char winner = board.checkWinner();

        if (winner != ' ') {
            gameOver = true;
            statusLabel.setText("Player " + winner + " Wins!");
            JOptionPane.showMessageDialog(
                    this, "Player " + winner + " Wins!");
        } else if (board.isFull()) {
            gameOver = true;
            statusLabel.setText("It's a Tie!");
            JOptionPane.showMessageDialog(this, "It's a Tie!");
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            statusLabel.setText(
                    "Player " + currentPlayer + "'s Turn");
        }
    }

    private void resetGame() {
        board.reset();
        currentPlayer = 'X';
        gameOver = false;
        statusLabel.setText("Player X's Turn");

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }
}
