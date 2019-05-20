package util;

import java.security.SecureRandom;
import java.util.Random;

public class StringUtil {
    public static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static final Random R = new SecureRandom();

    public static String newRandomString(int len) {
        StringBuilder stringBuilder =  new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            stringBuilder.append(AB.charAt(R.nextInt(61)));
        }

        return stringBuilder.toString();
    }
}
