package sprint3.Inlamningsuppgift_3.src;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ValidMove {


    public static boolean check(ActionEvent e, int blankTilePosition) {
        boolean valid;
        JButton pressedButton = (JButton)e.getSource();
        JPanel gameBoard = (JPanel)pressedButton.getParent();
        int x = pressedButton.getBounds().x;
        int y = pressedButton.getBounds().y;
        int buttonPosition = 4*y+x;

        try {
            switch (blankTilePosition) {
                case gameBoard.getComponent(buttonPosition-1) -> valid = true;
                case gameBoard.getComponent(buttonPosition+1) -> valid = true;
                case gameBoard.getComponent(buttonPosition-4) -> valid = true;
                case gameBoard.getComponent(buttonPosition+4) -> valid = true;
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return valid;
    }
}
