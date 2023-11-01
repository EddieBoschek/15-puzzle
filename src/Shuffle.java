import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Shuffle {
    public static void shuffle(JPanel gameBoard) {
        int[] array = new int[16];
        Random random = new Random();
        int randomNumber;
        boolean inArray;

        for (int i = 0; i < array.length-1; i++) {
            do {
                randomNumber = random.nextInt(15) + 1;
                inArray = false;
                for (int y = 0; y < array.length - 1; y++) {
                    if (array[y] == randomNumber) {
                        inArray = true;
                        break;
                    }
                }
            } while (inArray);
            array[i] = randomNumber;
        }
        int i = 0;
        for (Component component : gameBoard.getComponents()) {
            if (component instanceof JButton button) {
                button.setText(Integer.toString(array[i]));
                button.setVisible(true);
                i++;
            }
        }
    }
}