package View;

import Controller.Check;
import Model.Exception.InvalidDOBException;
import Model.Exception.InvalidFullNameException;
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
        System.out.println("\t3: Count standard student");
        System.out.println("\t4: Search semester point");
        System.out.println("\t5: Show the highest entry point");
        System.out.println("\t6: Search service student");
        System.out.println("\t7: Search student have last semester point over 8.0");
        System.out.println("\t8: Search student have the highest semester point");
        System.out.println("\t9: Show by entry year");
        System.out.println("\t10: Count by entry year");
        System.out.println("\t11: Exit");
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
     *       printReplaceOption      *
     *********************************/
    public void printReplaceOption() {
        System.out.println("This student ID already exist! Do you want to replace?");
        System.out.println("\t1: Yes");
        System.out.println("\t2: No");
    }

    /*********************************
     *         createStudent         *
     *********************************/
    public Student createStudent() throws InvalidFullNameException, InvalidDOBException {
        String studentID = this.inputStudentID();

        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();
        Check.checkFullName(fullName);

        System.out.println("Birthday: ");
        String birthDay = new Scanner(System.in).nextLine();
        Check.checkDOB(birthDay);

        int entryYear = this.inputEntryYear();

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

    public int inputEntryYear() {
        System.out.println("Entry year: ");
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
     *     searchHighestEntryPoint   *
     *********************************/
    public void searchHighestEntryPoint(List<School> schoolList) {
        System.out.println("The highest entry point:");
        for (School school : schoolList) {
            System.out.println(school.getSchoolName());
            System.out.println("\t" + school.sortStudent().get(0).getFullName() + ": " + school.sortStudent().get(0).getEntryPoint());
        }
    }

    /*********************************
     *      showServiceStudent       *
     *********************************/
    public void showServiceStudent(School school, List<Student> searchedList) {
        System.out.println("--------------" + school.getSchoolName() + "--------------");
        for (Student student : searchedList) {
            System.out.println(student.getFullName());
        }
        System.out.println("-----------------------------------------------------------");
    }

    /*********************************
     *         showPointOver8        *
     *********************************/
    public void showPointOver8(School school, List<Student> overList) {
        System.out.println("--------------" + school.getSchoolName() + "--------------");
        if (overList.isEmpty())
            System.out.println("No student!");
        else
            for (Student student : overList) {
                System.out.println(student.getFullName() + ": "
                        + student.getLastSemester() + " - "
                        + student.getLastSemesterPoint(student.getLastSemester()));
            }
        System.out.println("-----------------------------------------------------------");
    }

    /*********************************
     *    showHighestSemesterPoint   *
     *********************************/
    public void showHighestSemesterPoint(School school, Student student) {
        System.out.println("--------------" + school.getSchoolName() + "--------------");
        System.out.println(student.getFullName() + ": " + student.searchHighestSemesterPoint());
        System.out.println("-----------------------------------------------------------");
    }

    /*********************************
     *        showByEntryYear        *
     *********************************/
    public void showByEntryYear(School school, List<Student> studentList) {
        System.out.println("--------------" + school.getSchoolName() + "--------------");
        for (Student student : studentList) {
            System.out.println(student.getFullName() + ": " + student.getEntryYear());
        }
        System.out.println("-----------------------------------------------------------");
    }

    /*********************************
     *        countByEntryYear       *
     *********************************/
    public void countByEntryYear(School school, int entryYear, int count) {
        System.out.println("--------------" + school.getSchoolName() + "--------------");
        System.out.println(entryYear + ": " + count + " students");
        System.out.println("-----------------------------------------------------------");
    }
}
