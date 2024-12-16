package org.example.Util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidateForms {

    public static boolean isValidateNewMatch(String player1, String player2, HttpServletRequest request) {

        if (player1.equals(player2)) {
            request.setAttribute("checkedAnswer1","players can not play against themself");
            request.setAttribute("checkedAnswer2","players can not play against themself");
            return false;
        }else if (player1.isEmpty() || player2.isEmpty()) {
            request.setAttribute("checkedAnswer1","Enter all Player names");
            request.setAttribute("checkedAnswer2","Enter all Player names");
            return false;
        }else if(player1.length() > 20 ) {
            request.setAttribute("checkedAnswer1","you player1 can not consist more than 20 characters");
            return false;
        }else if (player2.length() > 20){
            request.setAttribute("checkedAnswer2","you player2 can not consist more than 20 characters");
            return false;
        }else if(player1.length() < 3 ) {
            request.setAttribute("checkedAnswer1","you player1 can not consist less than 3 characters");
            return false;
        }else if (player2.length() < 3) {
            request.setAttribute("checkedAnswer2", "you player2 can not consist less than 3 characters");
            return false;
        }else{
            return true;
        }
    }
}
