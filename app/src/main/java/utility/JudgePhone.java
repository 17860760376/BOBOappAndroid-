package utility;

import android.text.Editable;

import java.util.regex.Pattern;

public class JudgePhone {
    public static boolean isPhoneNumber(String input) {
        String regex = "(1[0-9][0-9]|15[0-9]|18[0-9])\\d{8}";
        Pattern p;
        p = Pattern.compile(regex);
        return p.matches(regex, input);
    }
    public static boolean isPhoneNumber(Editable input) {
        String regex = "(1[0-9][0-9]|15[0-9]|18[0-9])\\d{8}";
        Pattern p;
        p = Pattern.compile(regex);
        return p.matches(regex, input);
    }
}
