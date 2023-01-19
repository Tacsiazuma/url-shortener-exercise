package app.tier.service;


import java.util.Random;

public class RandomIdGenerator {

    // 58 because we exclude misreaded characters like 0/O, I/l from the original base62
    // still have a quite high possibilities approx. 38 billion
    // if we assume a million daily active users, 10% of which creates a new url every day
    // 365*0.1m = 36.5 million new entries a year.
    private static final int CHARACTER_POSSIBILITIES = 58;

    private static final char[] BASE_58_CHARS = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
            .toCharArray();

    private final Random random = new Random();

    public String getBase58(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(BASE_58_CHARS[random.nextInt(CHARACTER_POSSIBILITIES)]);
        }
        return sb.toString();
    }

}