import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    public static int[] shuffle() {
        int[] array = new int[16];
        Random random = new Random();
        int randomNumber;
        boolean inArray;

        for (int i = 0; i < array.length-1; i++) {
            while (true) {
                randomNumber = random.nextInt(15) + 1;
                inArray = false;
                for (int y = 0; y < array.length-1; y++) {
                    if (array[y] == randomNumber) {
                        inArray = true;
                        break;
                    }
                }
                if (!inArray) {
                    break;
                }
            }
            array[i] = randomNumber;
        }
        return array;
    }
}
