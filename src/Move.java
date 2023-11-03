import javax.swing.*;
import java.awt.event.ActionEvent;

public class Move {

    public static void checkAndMove(ActionEvent e, int blankTilePosition) {

        JButton pressedButton = (JButton) e.getSource();
        int buttonPosition = Integer.parseInt(pressedButton.getActionCommand());
        int howManyMoves = 0;
        int removal = 0;
        JPanel gameBoard = (JPanel) pressedButton.getParent();
        JButton blankTile = (JButton) gameBoard.getComponent(blankTilePosition);

        if (buttonPosition / 4 == blankTilePosition / 4 ^ buttonPosition % 4 == blankTilePosition % 4) {
            if (buttonPosition / 4 == blankTilePosition / 4) {
                howManyMoves = Math.abs(buttonPosition - blankTilePosition);
                removal = 1;
            }
            else if (buttonPosition % 4 == blankTilePosition % 4) {
                howManyMoves = Math.abs((buttonPosition - blankTilePosition) / 4);
                removal = 4;
            }
            JButton nextButton;
            for (int i = 1; i <= howManyMoves; i++) {

                if (buttonPosition-blankTilePosition > 0)
                    nextButton = (JButton) gameBoard.getComponent(blankTilePosition + i*removal);
                else
                    nextButton = (JButton) gameBoard.getComponent(blankTilePosition - i*removal);

                blankTile.setText(nextButton.getText());
                blankTile.setVisible(true);
                nextButton.setVisible(false);
                nextButton.setText("0");
                blankTile = nextButton;
            }
            Main.setBlankTilePosition(buttonPosition);
        }
    }
}