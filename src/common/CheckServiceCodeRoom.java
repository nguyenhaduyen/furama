package common;

public class CheckServiceCodeRoom {
    private static final String REGEX_ROOM = "^(SVRO)\\s-\\s\\d{4}$";

    public static boolean checkServiceCodeRoom(String serviceCode) {
        return serviceCode.matches(REGEX_ROOM);
    }
}
