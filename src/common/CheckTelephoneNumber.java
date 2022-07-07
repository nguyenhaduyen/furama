package common;

public class CheckTelephoneNumber {
    private static final String REGEX_TELEPHONE = "^(0[0-9]{9})$";
    public static boolean checkTelephone (String phone) {
        return phone.matches(REGEX_TELEPHONE);
    }
}
