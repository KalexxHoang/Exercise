package View;

import Model.School.School;
import Model.Student.ServiceStudent;
import Model.Student.Student;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class View {
    /*********************************
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add student");
        System.out.println("\t2: Check standard student");
        System.out.println("\t3: Modify clients information");
        System.out.println("\t4: Compute electricity money that client must pay");
        System.out.println("\t5: Exit");
    }

    /*********************************
     *       printStudentOption      *
     *********************************/
    public void printStudentOption() {
        System.out.println("What is type of student?");
        System.out.println("\t1: Standard Student");
        System.out.println("\t2: Service Student");
    }

    /*********************************
     *         createStudent         *
     *********************************/
    public Student createStudent() {
        String studentID = this.inputStudentID();

        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Birthday: ");
        String birthDay = new Scanner(System.in).nextLine();

        System.out.println("Entry year: ");
        int entryYear = new Scanner(System.in).nextInt();

        System.out.println("Entry point: ");
        double entryPoint = new Scanner(System.in).nextDouble();

        return new Student(studentID,fullName,birthDay,entryYear,entryPoint);
    }

    /*********************************
     *           Input Infor         *
     *********************************/
    public String inputStudentID() {
        System.out.println("Student ID: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputSchool() {
        System.out.println("School: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputTrainningLink() {
        System.out.println("Trainning link: ");
        return new Scanner(System.in).nextLine();
    }

    public int inputSemester() {
        System.out.println("Semester: ");
        return new Scanner(System.in).nextInt();
    }

    /*********************************
     *        showStudentType        *
     *********************************/
    public void showStudentType(Optional<Student> check) {
        if (check.get() instanceof ServiceStudent)
            System.out.println("The student is a service student!");
        else
            System.out.println("The student is a standard student!");
    }

    /*********************************
     *       showNoExistStudent      *
     *********************************/
    public void showNoExistStudent() {
        System.out.println("This student ID don't exist!");
    }

    /*********************************
     *       showNoExistSchool       *
     *********************************/
    public void showNoExistSchool() {
        System.out.println("This school don't exist!");
    }

    /*********************************
     *         showSemesterGPA       *
     *********************************/
    public void showSemesterGPA(Student student, int semester) {
        if (student.getPointMap().containsKey(semester))
            System.out.println("Semester " + semester + ": " + student.getPointMap().get(semester));
        else
            System.out.println("This semester don't exist!");
    }

    /*********************************
     *     searchHighestPoint       *
     *********************************/
    public void searchHighestPoint(List<School> schoolList) {
        System.out.println("The highest entry point:");
        for (School school : schoolList) {
            System.out.println(school.getSchoolName());
            System.out.println("\t" + school.sortStudent().get(0).getFullName() + ": " + school.sortStudent().get(0).getEntryPoint());
        }
    }
}
