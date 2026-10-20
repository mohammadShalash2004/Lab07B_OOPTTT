
public class TTTBoard {
    private char[][] board = new char[3][3];

    public TTTBoard() {
        reset();
    }

    public void reset() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (row < 0 || row > 2 || col < 0 || col > 2
                || board[row][col] != ' '
                || (player != 'X' && player != 'O')) {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' '
                    && board[i][0] == board[i][1]
                    && board[i][1] == board[i][2]) {
                return board[i][0];
            }

            if (board[0][i] != ' '
                    && board[0][i] == board[1][i]
                    && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }

        if (board[0][0] != ' '
                && board[0][0] == board[1][1]
                && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] != ' '
                && board[0][2] == board[1][1]
                && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return ' ';
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
