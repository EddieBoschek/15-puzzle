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

        //tillfällig print
        System.out.println(x + " " + y + " " +  buttonPosition + " " + valid);

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
}