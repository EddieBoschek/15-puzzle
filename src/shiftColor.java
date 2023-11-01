import javax.swing.*;
import java.awt.*;

public class shiftColor {
    private static Color customPurple = new Color(128, 0, 255);
    private static Color customOrange = new Color(255, 175, 0);
    private static Color[] colors = {customOrange, Color.GREEN, customPurple, Color.MAGENTA};
    private static int colorIndexF = 0;
    private static int colorIndexB = 2;

    public static void shiftColor(JLabel gameStatus) {

        gameStatus.setForeground(colors[colorIndexF]);
        gameStatus.setBackground(colors[colorIndexB]);
        colorIndexF = (colorIndexF + 1) % colors.length;
        colorIndexB = (colorIndexB + 1) % colors.length;
    }
}
