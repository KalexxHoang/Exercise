package View;

import Model.Classs;
import Model.School;
import Model.Student;

import java.util.List;
import java.util.Scanner;

public class View {
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
    public Student addStudent() {
        System.out.println("Please enter information of student you want to add");
        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();

        int age = this.inputAge();
        String homeTown = this.inputHomeTown();

        System.out.println("Class: ");
        String classs = new Scanner(System.in).nextLine();

        return new Student(fullName,age,homeTown,classs);
    }

    /*********************************
     *            Input Infor        *
     *********************************/
    public int inputAge() {
        System.out.println("Please enter age of student you want to show: ");
        return new Scanner(System.in).nextInt();
    }

    public String inputHomeTown() {
        System.out.println("Home town: ");
        return new Scanner(System.in).nextLine();
    }

    /*********************************
     *           showStudent         *
     *********************************/
    public void showStudent(School school) {
        for (Classs item : school.getSchoolList()) {
            System.out.println("Class " + item.getClassName());
            item.getClassList().forEach(Student::showInfor);
            System.out.println("--------------------------------------------------------");
        }
    }

    /*********************************
     *         showStudentAge        *
     *********************************/
    public void showStudentAge(Classs classs, List<Student> listAge) {
        System.out.println("Class " + classs.getClassName() + ": " + listAge.size() + " students");
        listAge.forEach(Student::showInfor);
        System.out.println("--------------------------------------------------------");
    }

    /*********************************
     *       showCountedStudent      *
     *********************************/
    public void showCountedStudent(int age, int sum) {
        System.out.println("In all, there are " + sum + " students " + age + " years old");
    }

    public void showCountedStudent(int age, String homeTown, int sum) {
        System.out.println("In all, there are " + sum + " students " + age + " years old, home town " + homeTown);
    }
}
