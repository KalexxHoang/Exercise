package Controller;

import Model.Employee.Employee;
import Model.Employee.Experience;
import Model.Employee.Fresher;
import Model.Employee.Intern;
import Model.Exception.BirthDayException;
import Model.Exception.EmailException;
import Model.Exception.PhoneException;
import View.EMPLOYEE;

import java.util.*;
import java.util.stream.Collectors;

import View.MENU;
import View.View;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Employee> employeeSet;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager(Set<Employee> employeeSet) {
        this.view = new View();
        this.employeeSet = employeeSet;
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu() throws PhoneException, EmailException, BirthDayException {
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD:
                    addEmployee();
                    break;

                case DELETE:
                    deleteEmployee();
                    break;

                case MODIFY:
                    modifyEmployee();
                    break;

                case SEARCH:
                    searchEmployee();
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }



    /*********************************
     *            addBill            *
     *********************************/
    public void checkID(Employee employee) {
        Optional<Employee> check = this.employeeSet.stream()
                .filter(item -> item.equals(employee))
                .findFirst();

        if (check.isPresent()) {
            view.printReplaceOption();
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.employeeSet.remove(check.get());
                    this.employeeSet.add(employee);
                case 2:
                    return;
            }
        }
       this.employeeSet.add(employee);
    }

    public void addEmployee() throws BirthDayException, PhoneException, EmailException {
        view.printEmployeeOption();
        int employeeOption = new Scanner(System.in).nextInt();
        EMPLOYEE opt = EMPLOYEE.getEnumEmployee(employeeOption);

        Employee employee = view.createEmployee();

        switch (opt) {
            case EXPERIENCE:
                int expInYear = view.inputExpInYear();
                String proSkill = view.inputProSkill();

                Employee experience = new Experience(employee.getID(), employee.getFullName(), employee.getBirthDay(),
                                                     employee.getPhone(), employee.getEmail(), EMPLOYEE.getString(EMPLOYEE.EXPERIENCE),
                                                     expInYear,proSkill);
                experience.addCertificate();
                checkID(experience);
                break;

            case FRESHER:
                String graduationDate = view.inputGraduationDate();
                String graduationRank = view.inputGraduationRank();
                String education = view.inputEducation();

                Employee fresher = new Fresher(employee.getID(), employee.getFullName(), employee.getBirthDay(),
                                               employee.getPhone(), employee.getEmail(), EMPLOYEE.getString(EMPLOYEE.FRESHER),
                                               graduationDate,graduationRank,education);
                fresher.addCertificate();
                checkID(fresher);
                break;

            case INTERN:
                String majors = view.inputMajors();
                int semester = view.inputSemester();
                String university = view.inputUniversity();

                Employee intern = new Intern(employee.getID(), employee.getFullName(), employee.getBirthDay(),
                                             employee.getPhone(), employee.getEmail(),EMPLOYEE.getString(EMPLOYEE.INTERN),
                                             majors,semester,university);
                intern.addCertificate();
                checkID(intern);
        }
    }

    /*********************************
     *          deleteEmployee       *
     *********************************/
    public void deleteEmployee() {
        String ID = view.inputID();

        Optional<Employee> check = this.employeeSet.stream().filter(item -> item.equals(new Employee(ID))).findFirst();
        if (check.isPresent()) {
            this.employeeSet.remove(check.get());
            Employee.employeeCount--;
        }
        else
            view.showNoExistID();
    }

    /*********************************
     *          modifyEmployee       *
     *********************************/
    public void modifyEmployee() {
        String ID = view.inputID();

        Optional<Employee> check = this.employeeSet.stream().filter(item -> item.equals(new Employee(ID))).findFirst();
        if (check.isPresent())
            check.get().modifyInfor();
        else
            view.showNoExistID();
    }

    /*********************************
     *          searchEmployee       *
     *********************************/
    public void search(String employeeType) {
        Set<Employee> searchList = this.employeeSet.stream()
                .filter(item -> item.getEmployeeType().contains(employeeType))
                .collect(Collectors.toSet());
        view.showSearchedEmployee(employeeType,searchList);
    }

    public void searchEmployee() {
        view.printEmployeeOption();
        int employeeOption = new Scanner(System.in).nextInt();

        EMPLOYEE opt = EMPLOYEE.getEnumEmployee(employeeOption);
        search(EMPLOYEE.getString(opt));
    }
}
