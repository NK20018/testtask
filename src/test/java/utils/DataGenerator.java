package utils;

import java.util.Random;

public class DataGenerator {

    public static String generateRandomDigits() {
        Random random = new Random();
        int length = random.nextInt(3) + 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}