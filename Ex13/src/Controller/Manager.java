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

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Employee> employeeSet;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu() throws PhoneException, EmailException, BirthDayException {
        int menuOp;
        boolean condition = true;
        while (condition){
            printMenu();
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
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add employee");
        System.out.println("\t2: Delete employee");
        System.out.println("\t3: Modify employees information");
        System.out.println("\t4: Search employee");
        System.out.println("\t5: Exit");
    }

    /*********************************
     *      printEmployeeOption      *
     *********************************/
    public void printEmployeeOption() {
        System.out.println("\t1: Experience");
        System.out.println("\t2: Fresher");
        System.out.println("\t3: Intern");
    }

    /*********************************
     *            addBill            *
     *********************************/
    public void checkID(Employee employee) {
        Optional<Employee> check = this.employeeSet.stream()
                .filter(item -> item.equals(employee))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("This ID already exists!");
            System.out.println("Do you want to replace?");
            System.out.println("\t1: YES");
            System.out.println("\t2: NO");
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
        System.out.println("Type of employee you want to add:");
        printEmployeeOption();
        int employeeOption = new Scanner(System.in).nextInt();
        EMPLOYEE opt = EMPLOYEE.getEnumEmployee(employeeOption);

        System.out.println("ID: ");
        String ID = new Scanner(System.in).nextLine();

        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Birthday: ");
        String birthDay = new Scanner(System.in).nextLine();
        Check.checkDate(birthDay);

        System.out.println("Phone: ");
        int phone = new Scanner(System.in).nextInt();
        Check.checkPhone(phone);

        System.out.println("Email: ");
        String email = new Scanner(System.in).nextLine();
        Check.checkEmail(email);

        switch (opt) {
            case EXPERIENCE:
                System.out.println("Number years of experience: ");
                int expInYear = new Scanner(System.in).nextInt();

                System.out.println("Pro skill: ");
                String proSkill = new Scanner(System.in).nextLine();

                Employee experience = new Experience(ID,fullName,birthDay,phone,email,EMPLOYEE.getString(EMPLOYEE.EXPERIENCE),
                                                     expInYear,proSkill);
                experience.addCertificate();
                checkID(experience);
                break;

            case FRESHER:
                System.out.println("Graduation date: ");
                String graduationDate = new Scanner(System.in).nextLine();

                System.out.println("Graduation rank: ");
                String graduationRank = new Scanner(System.in).nextLine();

                System.out.println("Education: ");
                String education = new Scanner(System.in).nextLine();

                Employee fresher = new Fresher(ID,fullName,birthDay,phone,email,EMPLOYEE.getString(EMPLOYEE.FRESHER),
                                               graduationDate,graduationRank,education);
                fresher.addCertificate();
                checkID(fresher);
                break;

            case INTERN:
                System.out.println("Majors: ");
                String majors = new Scanner(System.in).nextLine();

                System.out.println("Semester: ");
                int semester = new Scanner(System.in).nextInt();

                System.out.println("University: ");
                String university = new Scanner(System.in).nextLine();

                Employee intern = new Intern(ID,fullName,birthDay,phone,email,EMPLOYEE.getString(EMPLOYEE.INTERN),
                                             majors,semester,university);
                intern.addCertificate();
                checkID(intern);
        }
    }

    /*********************************
     *          deleteEmployee       *
     *********************************/
    public void deleteEmployee() {
        System.out.println("Please enter ID of employee you want to delete: ");
        String ID = new Scanner(System.in).nextLine();

        Optional<Employee> check = this.employeeSet.stream().filter(item -> item.equals(new Employee(ID))).findFirst();
        if (check.isPresent()) {
            this.employeeSet.remove(check.get());
            Employee.employeeCount--;
        }
        else
            System.out.println("This ID don't exist!");
    }

    /*********************************
     *          modifyEmployee       *
     *********************************/
    public void modifyEmployee() {
        System.out.println("Please enter ID of employee you want to modify: ");
        String ID = new Scanner(System.in).nextLine();

        Optional<Employee> check = this.employeeSet.stream().filter(item -> item.equals(new Employee(ID))).findFirst();
        if (check.isPresent())
            check.get().modifyInfor();
        else
            System.out.println("This ID don't exist!");
    }

    /*********************************
     *          searchEmployee       *
     *********************************/
    public void search(String employeeType) {
        Set<Employee> searchList = this.employeeSet.stream()
                .filter(item -> item.getEmployeeType().contains(employeeType))
                .collect(Collectors.toSet());
        if (searchList.isEmpty())
            System.out.println("Don't exist " + employeeType + " employee!");
        else {
            System.out.println(employeeType + " employee:");
            searchList.forEach(Employee::showInfor);
        }
    }

    public void searchEmployee() {
        System.out.println("Type of employee you want to search:");
        printEmployeeOption();
        int employeeOption = new Scanner(System.in).nextInt();

        EMPLOYEE opt = EMPLOYEE.getEnumEmployee(employeeOption);
        search(EMPLOYEE.getString(opt));
    }
}
