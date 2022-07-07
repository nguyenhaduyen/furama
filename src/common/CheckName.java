package common;

public class CheckName {
    private static final String REGEX_NAME = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)+$";

    public static boolean checkName(String name) {
        return name.matches(REGEX_NAME);
    }
}
