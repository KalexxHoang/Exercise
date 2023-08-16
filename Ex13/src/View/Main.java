package View;

import Controller.Manager;
import Model.Employee.Employee;
import Model.Exception.BirthDayException;
import Model.Exception.EmailException;
import Model.Exception.PhoneException;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static Set<Employee> employeeSet;
    public static void main(String[] args) throws PhoneException, EmailException, BirthDayException {
        Main.employeeSet = new LinkedHashSet<>();
        Manager user = new Manager(Main.employeeSet);
        user.userMenu();
    }
}