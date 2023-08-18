package View;

import Controller.Check;
import Model.Employee.Employee;
import Model.Exception.BirthDayException;
import Model.Exception.EmailException;
import Model.Exception.PhoneException;

import java.util.Scanner;
import java.util.Set;

public class View {
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
        System.out.println("Type of employee:");
        System.out.println("\t1: Experience");
        System.out.println("\t2: Fresher");
        System.out.println("\t3: Intern");
    }

    /*********************************
     *       printReplaceOption      *
     *********************************/
    public void printReplaceOption() {
        System.out.println("This ID already exists!");
        System.out.println("Do you want to replace?");
        System.out.println("\t1: YES");
        System.out.println("\t2: NO");
    }

    /*********************************
     *         createEmployee        *
     *********************************/
    public Employee createEmployee() throws BirthDayException, PhoneException, EmailException {
        String ID = this.inputID();

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

        return new Employee(ID,fullName,birthDay,phone,email);
    }

    /*********************************
     *          Input Infor          *
     *********************************/
    public String inputID() {
        System.out.println("ID: ");
        return new Scanner(System.in).nextLine();
    }

    public int inputExpInYear() {
        System.out.println("Number years of experience: ");
        return new Scanner(System.in).nextInt();
    }

    public String inputProSkill() {
        System.out.println("Pro skill: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputGraduationDate() {
        System.out.println("Graduation date: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputGraduationRank() {
        System.out.println("Graduation rank: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputEducation() {
        System.out.println("Education: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputMajors() {
        System.out.println("Majors: ");
        return new Scanner(System.in).nextLine();
    }

    public int inputSemester() {
        System.out.println("Semester: ");
        return new Scanner(System.in).nextInt();
    }

    public String inputUniversity() {
        System.out.println("University: ");
        return new Scanner(System.in).nextLine();
    }

    /*********************************
     *          showNoExistID        *
     *********************************/
    public void showNoExistID() {
        System.out.println("This ID don't exist!");
    }

    /*********************************
     *      showSearchedEmployee     *
     *********************************/
    public void showSearchedEmployee(String employeeType, Set<Employee> searchList) {
        if (searchList.isEmpty())
            System.out.println("Don't exist " + employeeType + " employee!");
        else {
            System.out.println(employeeType + " employee:");
            searchList.forEach(Employee::showInfor);
        }
    }
}
