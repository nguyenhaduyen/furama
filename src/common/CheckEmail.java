package common;

public class CheckEmail {
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static boolean checkMail(String email) {
       return email.matches(REGEX_EMAIL);
    }
}
