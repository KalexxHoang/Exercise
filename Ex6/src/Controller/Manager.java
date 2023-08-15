package Controller;

import Model.School;
import Model.Student;
import Model.Classs;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import View.MENU;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private School school;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.school = new School();
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
                case ADD_STUDENT:
                    addStudent();
                    break;

                case SHOW_STUDENT:
                    showStudent();
                    break;

                case SHOW_AGE:
                    System.out.println("Please enter age of student you want to show: ");
                    int age = new Scanner(System.in).nextInt();
                    showStudentAge(age);
                    break;

                case COUNT_AGE_HOMETOWN:
                    System.out.println("Please enter age and hometown of student you want to count: ");
                    System.out.println("Age: ");
                    int age1 = new Scanner(System.in).nextInt();

                    System.out.println("Hometown: ");
                    String homeTown = new Scanner(System.in).nextLine();

                    countStudentAgeHomeTown(age1,homeTown);
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
        System.out.println("\t1: Add Student");
        System.out.println("\t2: Show Student");
        System.out.println("\t3: Show Student by age");
        System.out.println("\t4: Count Student by age and hometown");
        System.out.println("\t5: Exit");
    }

    /*********************************
     *            addStudent         *
     *********************************/
    public void checkClass(Student student) {
        Optional<Classs> check = this.school.getSchoolList()
                .stream().filter(item -> item.getClassName()
                .contains(student.getClasss()))
                .findFirst();

        if (check.isPresent())
            check.get().getClassList().add(student);
        else {
            Classs classs = new Classs(student.getClasss());
            classs.getClassList().add(student);
            this.school.getSchoolList().add(classs);
        }
    }

    public void addStudent() {
        System.out.println("Please enter information of student you want to add");
        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Age: ");
        int age = new Scanner(System.in).nextInt();

        System.out.println("Home town: ");
        String homeTown = new Scanner(System.in).nextLine();

        System.out.println("Class: ");
        String classs = new Scanner(System.in).nextLine();

        Student student = new Student(fullName,age,homeTown,classs);
        checkClass(student);
    }

    /*********************************
     *           showStudent         *
     *********************************/
    public void showStudent() {
        for (Classs item : this.school.getSchoolList()) {
            System.out.println("Class " + item.getClassName());
            item.getClassList().forEach(Student::showInfor);
            System.out.println("--------------------------------------------------------");
        }
    }

    /*********************************
     *         showStudentAge        *
     *********************************/
    public void showStudentAge(int age) {
        System.out.println("Student are " + age + " years old:");
        int sum = 0;
        for (Classs classs : this.school.getSchoolList()) {
            ArrayList<Student> listAge = (ArrayList<Student>) classs.getClassList()
                    .stream().filter(student -> student.getAge()==age)
                    .collect(Collectors.toList());

            Optional<Student> check = listAge.stream().findFirst();
            if (check.isPresent()) {
                System.out.println("Class " + classs.getClassName() + ": " + listAge.size() + " students");
                listAge.forEach(Student::showInfor);
                System.out.println("--------------------------------------------------------");
                sum += listAge.size();
            }
        }
        System.out.println("In all, there are " + sum + " students " + age + " years old.");
    }

    /*********************************
     *   countStudentAgeHomeTown     *
     *********************************/
    public void countStudentAgeHomeTown(int age, String homeTown) {
        int sum = 0;
        for (Classs classs : this.school.getSchoolList()) {
            ArrayList<Student> listAge = (ArrayList<Student>) classs.getClassList()
                    .stream()
                    .filter(student -> (student.getAge()==age && student.getHomeTown().contains(homeTown)))
                    .collect(Collectors.toList());

            Optional<Student> check = listAge.stream().findFirst();
            if (check.isPresent()) {
                sum += listAge.size();
            }
        }
        System.out.println("In all, there are " + sum + " students " + age + " years old, home town " + homeTown);
    }
}
