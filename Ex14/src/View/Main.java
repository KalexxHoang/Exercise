package View;

import Controller.Manager;
import Model.Exception.InvalidDOBException;
import Model.Exception.InvalidFullNameException;
import Model.Exception.InvalidPhoneNumberException;
import Model.Exception.UnknowRuntimeExcption;

public class Main {
    public static void main(String[] args) throws InvalidPhoneNumberException, InvalidFullNameException, InvalidDOBException, UnknowRuntimeExcption {
        try {
            Manager user = new Manager();
            user.userMenu();
        } catch (Exception e) {
            throw new UnknowRuntimeExcption("Input files have unknow errors");
        }
    }
}