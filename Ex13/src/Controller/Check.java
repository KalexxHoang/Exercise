package Controller;

import Model.Exception.BirthDayException;
import Model.Exception.EmailException;
import Model.Exception.PhoneException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Check {
    /*********************************
     *            checkDate          *
     *********************************/
    public static void checkDate(String stringDate) throws BirthDayException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date date = formatter.parse(stringDate);

        } catch (ParseException e) {
            throw new BirthDayException("Date illegal");
        }
    }

    /*********************************
     *           checkEmail          *
     *********************************/
    public static void checkEmail(String stringEmail) throws EmailException {
        StringBuilder string = new StringBuilder(stringEmail);
        String newString =  string.substring(0,9);
        StringBuilder check = new StringBuilder(newString);
        String lastString = String.valueOf(check.reverse());
        if (lastString.equals("@gmail.com"))
            return;
        else
            throw new EmailException("Email illegal");
    }

    /*********************************
     *           checkPhone          *
     *********************************/
    public static void checkPhone(int phone) throws PhoneException {
        String string = Integer.toString(phone);
        if (string.length() == 10 && string.charAt(0) == '0')
            return;
        else
            throw new PhoneException("Phone illegal");
    }
}
