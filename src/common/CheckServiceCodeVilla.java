package common;

import java.util.Scanner;

public class CheckServiceCodeVilla {

    private static final String REGEX_VILLA = "^(SVVL)\\s-\\s\\d{4}$";

    public static boolean checkServiceCodeVilla(String serviceCode) {
        return serviceCode.matches(REGEX_VILLA);
    }
}
