import javax.swing.*;

public class WinCondition {

    public static boolean checkIfMet(JPanel gameBoard) {
        JButton[] buttonArray = new JButton[16];
        boolean win = true;

        for (int i = 0; i < 16; i++)
            buttonArray[i] = (JButton) gameBoard.getComponent(i);

        int lastButton = 0;
        for (int i = 0; i < 15; i++) {
            if (lastButton < Integer.parseInt(buttonArray[i].getText()))
                lastButton = Integer.parseInt(buttonArray[i].getText());
            else {
                win = false;
                break;
            }
        }
        return win;
    }
}