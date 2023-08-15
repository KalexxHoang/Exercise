package Controller;

import Model.Teacher;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import View.MENU;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Teacher> teacherSet;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.teacherSet = new LinkedHashSet<>();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD_TEACHER:
                    addTeacher();
                    break;

                case SHOW_TEACHER:
                    showTeacher();
                    break;

                case DELETE_TEACHER:
                    System.out.println("Please enter teachID of teacher you want to delete: ");
                    String teachID = new Scanner(System.in).nextLine();
                    deleteTeacher(teachID);
                    break;

                case COMPUTE_SALARY:
                    System.out.println("Please enter teachID of teacher you want to compute salary: ");
                    String teachID1 = new Scanner(System.in).nextLine();
                    computeSalary(teachID1);
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *            printMenu        *
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
     *            addTeacher         *
     *********************************/
    public void checkTeacher(Teacher teacher) {
        Optional<Teacher> check = this.teacherSet
                .stream().filter(item -> item.equals(teacher))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("This ID already exists!");
            System.out.println("Do you want to replace?");
            System.out.println("\t1: YES");
            System.out.println("\t2: NO");
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.teacherSet.remove(check.get());
                    this.teacherSet.add(teacher);
                case 2:
                    return;
            }
        }
        this.teacherSet.add(teacher);
    }

    public void addTeacher() {
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

        Teacher teacher = new Teacher(fullName,age,homeTown,teachID,baseSalary,bonus,amercement);
        checkTeacher(teacher);
    }

    /*********************************
     *           showTeacher         *
     *********************************/
    public void showTeacher() {
        Optional<Teacher> check = this.teacherSet.stream().findFirst();
        if (check.isPresent())
            this.teacherSet.forEach(Teacher::showInfor);
        else
            System.out.println("The teacher list is empty!");
    }

    /*********************************
     *          deleteTeacher        *
     *********************************/
    public void deleteTeacher(String teachID) {
        Optional<Teacher> check = this.teacherSet.stream()
                .filter(item -> item.equals(new Teacher(teachID)))
                .findFirst();

        if (check.isPresent()) {
            this.teacherSet.remove(check.get());
        }else
            System.out.println("The teacher don't exists!");
    }

    /*********************************
     *          computeSalary        *
     *********************************/
    public void computeSalary(String teachID) {
        Optional<Teacher> check = this.teacherSet.stream()
                .filter(item -> item.equals(new Teacher(teachID)))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("Salary of the teacher " + check.get().getFullName() + ": " + check.get().getRealSalary());;
        }else
            System.out.println("The teacher don't exists!");
    }
}
