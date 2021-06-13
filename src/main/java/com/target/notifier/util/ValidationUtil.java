package com.target.notifier.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static boolean isStringValid(String in){

        if (in == null || in.length() == 0 ||
                in.replaceAll(" ","").length() == 0){
            return  false;
        }
        else
        {
            return true;
        }
    }


    public static boolean EmailValidator(String mail) {
         Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

}
