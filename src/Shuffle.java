import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    public static int[] shuffle() {
        int[] array = new int[16];
        Arrays.fill(array, -1);
        Random random = new Random();
        int randomNumber;
        boolean inArray;

        for (int i = 0; i < array.length; i++) {
            while (true) {
                randomNumber = random.nextInt(16);
                inArray = false;
                for (int n : array) {
                    if (n == randomNumber) {
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
