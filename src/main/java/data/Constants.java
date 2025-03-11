package data;

import java.util.Random;

public class Constants {
    public static final String NEW_USERNAME = generateUsername();
    public static final String PASSWORD = "test@123";
    public static final String USERNAME = "maria966";
    public static final String URL = "https://www.demoblaze.com/";
    public static final String NAME = "Alex Test";
    public static final String COUNTRY = "Irlanda";
    public static final String CITY = "Dublin";
    public static final String CARD_NR = "4916765915538360";
    public static final String CARD_MONTH = "01";
    public static final String CARD_YEAR ="26";

    private static String generateUsername() {
        Random rnd = new Random();
        return "maria" + rnd.nextInt(10000);
    }
}
