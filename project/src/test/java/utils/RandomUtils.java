package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import static tests.TestData.*;

public class RandomUtils {
    public static String getRandomItemFromArray(String[] array) {
        int randomIndex = ThreadLocalRandom.current().nextInt(array.length);
        return array[randomIndex];
    }
    public static String getRandomValue(String[] arr) {
        int index = new Random().nextInt(arr.length);
        return arr[index];
    }
    public static String getRandomCity(String state) {
        String[] cities;
        switch (state) {
            case "NCR" : cities = ncr;
                break;
            case "Uttar Pradesh" : cities = uttarpradesh;
                break;
            case "Haryana" : cities = haryana;
                break;
            case "Rajasthan" : cities = rajasthan;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);

        }
        return cities[new Random().nextInt(cities.length)];
    }
}
