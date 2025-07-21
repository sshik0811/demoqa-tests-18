package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static String getRandomItemFromArray(String[] array) {
        int randomIndex = ThreadLocalRandom.current().nextInt(array.length);
        return array[randomIndex];
    }
}
