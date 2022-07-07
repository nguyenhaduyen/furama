package common;

import java.util.Scanner;

public class CheckServiceCodeHouse {
    private static final String REGEX_HOUSE = "^(SVHO)\\s-\\s\\d{4}$";

    public static boolean checkServiceCodeHouse(String serviceCode) {
        return serviceCode.matches(REGEX_HOUSE);
    }
}
