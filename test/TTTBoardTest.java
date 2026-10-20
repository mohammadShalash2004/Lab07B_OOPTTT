
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TTTBoardTest {

    @Test
    void testValidMove() {
        TTTBoard board = new TTTBoard();
        assertTrue(board.makeMove(0, 0, 'X'));
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    void testInvalidMove() {
        TTTBoard board = new TTTBoard();
        board.makeMove(0, 0, 'X');
        assertFalse(board.makeMove(0, 0, 'O'));
    }

    @Test
    void testWinner() {
        TTTBoard board = new TTTBoard();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertEquals('X', board.checkWinner());
    }

    @Test
    void testReset() {
        TTTBoard board = new TTTBoard();
        board.makeMove(0, 0, 'X');
        board.reset();
        assertEquals(' ', board.getCell(0, 0));
    }
}

