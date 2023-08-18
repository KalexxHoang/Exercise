package Controller;

import Model.Exception.InvalidDOBException;
import Model.Exception.InvalidFullNameException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Check {
    /**********************************
     *        checkFullName           *
     **********************************/
    public static void checkFullName(String fullName) throws InvalidFullNameException {
        int length = fullName.length();
        if (length >= 10 && length <= 50)
            return;
        else
            throw new InvalidFullNameException("Name illegal");
    }

    /**********************************
     *            checkDOB            *
     **********************************/
    public static void checkDOB(String doB) throws InvalidDOBException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try {
            Date date = formatter.parse(doB);

        } catch (ParseException e) {
            throw new InvalidDOBException("Date illegal");
        }
    }
}
