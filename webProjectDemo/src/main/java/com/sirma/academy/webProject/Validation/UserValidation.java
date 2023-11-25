package com.sirma.academy.webProject.Validation;

import com.sirma.academy.webProject.Model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {

    public static boolean userValidation(User user){

        Pattern patternName = Pattern.compile("[a-zA-z]+");
        Matcher matcherName = patternName.matcher(user.getName());
        if (!matcherName.matches()) {
            return false;
        }

        Pattern patternEmail = Pattern.compile("[a-zA-z\\d]+@[a-z]+.[a-z]+");
        Matcher matcherEmail = patternEmail.matcher(user.getEmail());
        if (!matcherEmail.matches()) {
            return false;
        }

        Pattern patternPassword = Pattern.compile("[a-zA-z\\d]+");
        Matcher matcherPassword = patternPassword.matcher(user.getPassword());
        if (!matcherPassword.matches()) {
            return false;
        }
        return true;
    }
}
