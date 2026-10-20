
import javax.swing.*;
import java.awt.*;

public class TTTTileButton extends JButton {
    private final int row;
    private final int col;

    public TTTTileButton(int row, int col) {
        this.row = row;
        this.col = col;

        setFont(new Font("Arial", Font.BOLD, 48));
        setFocusPainted(false);
        setBackground(Color.WHITE);
        setOpaque(true);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
