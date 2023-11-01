package sprint3.Inlamningsuppgift_3.src;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Move {


    public static boolean validMoveCheck(ActionEvent e, int blankTilePosition) {
        boolean valid = false;
        JButton pressedButton = (JButton) e.getSource();
        JPanel gameBoard = (JPanel) pressedButton.getParent();
        int x = (pressedButton.getBounds().x-10)/90;
        int y = (pressedButton.getBounds().y-10)/84;
        int buttonPosition = 4 * y + x;

        int leftButton = -1;
        int rightButton = -1;
        int upButton = -1;
        int downButton = -1;

        if (x != 0)
            leftButton = buttonPosition - 1;
        if (x != 3)
            rightButton = buttonPosition + 1;
        if (y != 0)
            upButton = buttonPosition - 4;
        if (y != 3)
            downButton = buttonPosition + 4;

        int[] buttonArray = {leftButton,rightButton,upButton,downButton};

        for (int button: buttonArray)
            if (button == blankTilePosition)
                valid = true;


        return valid;
    }
    public static int makeMove(ActionEvent e, int blankTilePosition) {
        JButton pressedButton = (JButton) e.getSource();
        JPanel gameBoard = (JPanel) pressedButton.getParent();
        JButton blankTile = (JButton) gameBoard.getComponent(blankTilePosition);

        int x = (pressedButton.getBounds().x-10)/90;
        int y = (pressedButton.getBounds().y-10)/84;
        int pressedButtonPosition = 4 * y + x;

        blankTile.setText(pressedButton.getText());
        blankTile.setVisible(true);
        pressedButton.setText("0");
        pressedButton.setVisible(false);

        blankTilePosition = pressedButtonPosition;

        return blankTilePosition;
    }

    public static int moveCheckAndMaker(ActionEvent e, int blankTilePosition) {

        JButton pressedButton = (JButton) e.getSource();
        int x = (pressedButton.getBounds().x - 10) / 90;
        int y = (pressedButton.getBounds().y - 10) / 84;
        int buttonPosition = 4 * y + x;
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
                nextButton.setText("0");
                nextButton.setVisible(false);
                blankTile = nextButton;
            }
            blankTilePosition = buttonPosition;
        }
        return blankTilePosition;
    }
}
