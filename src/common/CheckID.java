package common;

public class CheckID {
    private static final String REGEX_ID = "^[1-9][0-9]{8}$";
    public static boolean checkID(String id) {
        return id.matches(REGEX_ID);
    }
}
