package common;

public class CheckServiceName {
    private static final String REGEX_SERVICE_NAME = "^[A-Z][a-z]*$";
    public static boolean checkServiceName (String serviceName) {
        return serviceName.matches(REGEX_SERVICE_NAME);
    }
}
