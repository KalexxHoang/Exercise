package Controller;

import Model.Exception.InvalidDOBException;
import Model.Exception.InvalidFullNameException;
import Model.Exception.InvalidPhoneNumberException;

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

    /**********************************
     *        checkPhoneNumber        *
     **********************************/
    public static void checkPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        List<String> numberList = Arrays.asList("090","098","091","031","035","038");
        Optional<String> check = numberList.stream()
                .filter(item -> item.contains(phoneNumber.substring(0,2)))
                .findFirst();

        if (check.isPresent())
            return;
        else
            throw new InvalidPhoneNumberException("Phone number illegal");
    }
}
