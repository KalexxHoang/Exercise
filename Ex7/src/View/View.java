package View;

import Model.Teacher;

import java.util.Optional;
import java.util.Scanner;

public class View {
    /*********************************
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add teacher");
        System.out.println("\t2: Show teacher");
        System.out.println("\t3: Delete teacher");
        System.out.println("\t4: Compute salary of teacher");
        System.out.println("\t5: Exit");
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
     *          Input Infor          *
     *********************************/
    public String inputTeachID() {
        System.out.println("TeachID: ");
        return new Scanner(System.in).nextLine();
    }

    /*********************************
     *           addTeacher          *
     *********************************/
    public Teacher addTeacher() {
        System.out.println("Please enter information of teacher you want to add");
        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Age: ");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Home town: ");
        String homeTown = new Scanner(System.in).nextLine();

        System.out.println("TeachID: ");
        String teachID = new Scanner(System.in).nextLine();

        System.out.println("Base salary: ");
        int baseSalary = new Scanner(System.in).nextInt();

        System.out.println("Bonus: ");
        int bonus = new Scanner(System.in).nextInt();

        System.out.println("Amercement: ");
        int amercement = new Scanner(System.in).nextInt();

        return new Teacher(fullName,age,homeTown,teachID,baseSalary,bonus,amercement);
    }

    /*********************************
     *        showTeacherEmpty       *
     *********************************/
    public void showTeacherEmpty() {
        System.out.println("The teacher list is empty!");
    }

    /*********************************
     *       showTeacherNoExist      *
     *********************************/
    public void showTeacherNoExist() {
        System.out.println("The teacher don't exists!");
    }

    /*********************************
     *           showSalary          *
     *********************************/
    public void showSalary(Optional<Teacher> check) {
        if (check.isPresent()) {
            System.out.println("Salary of the teacher " + check.get().getFullName() + ": " + check.get().getRealSalary());;
        }else
            System.out.println("The teacher don't exists!");
    }
}
