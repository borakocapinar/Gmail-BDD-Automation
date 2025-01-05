package utils;


import io.github.cdimascio.dotenv.Dotenv;

public class DotenvUtils {
    private static final Dotenv dotenv = Dotenv.load(); // Load once

    private DotenvUtils() {
        // Private constructor to prevent instantiation
    }

    public static String get(String key) {
        return dotenv.get(key);
    }
}
