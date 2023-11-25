package com.sirma.academy.webProject.Validation;

import com.sirma.academy.webProject.Model.Reservation;
import com.sirma.academy.webProject.Model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReservationValidation {
    public static boolean reservationValidation(Reservation reservation){

        Pattern patternTitle = Pattern.compile("[a-zA-z ]+");
        Matcher matcherTitle = patternTitle.matcher(reservation.getTitle());
        if (!matcherTitle.matches()) {
            return false;
        }

        /*Pattern patternDate = Pattern.compile("");
        Matcher matcherDate = patternDate.matcher(reservation.getDateTime());
        if (!matcherDate.matches()) {
            return false;
        }*/

        return true;
    }
}
