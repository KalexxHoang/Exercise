package View;

import Controller.Manager;
import Model.Exception.InvalidDOBException;
import Model.Exception.InvalidFullNameException;

public class Main {
    public static void main(String[] args) throws InvalidFullNameException, InvalidDOBException {
        Manager user = new Manager();
        user.userMenu();
    }
}