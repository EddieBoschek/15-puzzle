package sprint3.Inlamningsuppgift_3.src;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ValidMove {


    public static int check(ActionEvent e, int blankTilePosition) {
        int valid = -1;
        JButton pressedButton = (JButton)e.getSource();
        JPanel gameBoard = (JPanel)pressedButton.getParent();
        int x = pressedButton.getBounds().x;
        int y = pressedButton.getBounds().y;
        int buttonPosition = 4*y+x;

        try {
            switch (blankTilePosition) {
                case gameBoard.getComponent(buttonPosition-1) -> valid = buttonPosition-1;
                case gameBoard.getComponent(buttonPosition+1) -> valid = buttonPosition+1;
                case gameBoard.getComponent(buttonPosition-4) -> valid = buttonPosition-4;
                case gameBoard.getComponent(buttonPosition+4) -> valid = buttonPosition+4;
            }
        } catch (Exception exc) {
            exc.printStackTrace()
        }

        return valid;
    }
}
