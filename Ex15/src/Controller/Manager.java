package Controller;

import Model.School.School;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Model.Student.ServiceStudent;
import Model.Student.Student;
import View.MENU;
import View.STUDENT;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private List<School> schoolList;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.schoolList = new LinkedList<>();
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
                case ADD:
                    inputStudent();
                    break;

                case CHECK_STANDARD:
                    checkStandard();
                    break;

                case COUNT_STANDARD:
                    countStandard();
                    break;

                case SEARCH_POINT:
                    searchSemesterPoint();
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
        System.out.println("\t1: Add student");
        System.out.println("\t2: Check standard student");
        System.out.println("\t3: Modify clients information");
        System.out.println("\t4: Compute electricity money that client must pay");
        System.out.println("\t5: Exit");
    }

    /*********************************
     *          inputStudent         *
     *********************************/
    public Student createStudent() {
        System.out.println("Student ID: ");
        String studentID = new Scanner(System.in).nextLine();

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

    public void checkSchool(String school, Student student) {
        Optional<School> check = this.schoolList.stream()
                .filter(item -> item.getSchoolName().contains(school))
                .findFirst();

        if (check.isPresent()) {
            check.get().addStudent(student);
        } else {
            School newSchool = new School(school);
            newSchool.addStudent(student);
            this.schoolList.add(newSchool);
        }
    }

    public void inputStudent() {
        System.out.println("What is type of student?");
        System.out.println("\t1: Standard Student");
        System.out.println("\t2: Service Student");

        int studentOption = new Scanner(System.in).nextInt();
        STUDENT opt = STUDENT.getEnumStudent(studentOption);

        System.out.println("School: ");
        String school = new Scanner(System.in).nextLine();

        Student student = createStudent();

        switch (opt) {
            case STANDARD:
                checkSchool(school,student);
                break;

            case SERVICE:
                System.out.println("Trainning link: ");
                String trainningLink = new Scanner(System.in).nextLine();

                Student serviceStudent = new ServiceStudent(student.getStudentID(),student.getFullName(),student.getBirthDay(),
                                                            student.getEntryYear(),student.getEntryPoint(),trainningLink);
                checkSchool(school,serviceStudent);
                break;
        }
    }

    /*********************************
     *         checkStandard         *
     *********************************/
    public void checkStandard() {
        System.out.println("Please enter student ID you want to check: ");
        String studentID = new Scanner(System.in).nextLine();

        for (School school : this.schoolList) {
            Optional<Student> check = school.getStudentSet().stream()
                    .filter(item -> item.equals(new Student(studentID)))
                    .findFirst();
            if (check.isPresent()) {
                if (check.get() instanceof ServiceStudent)
                    System.out.println("The student is a service student!");
                else
                    System.out.println("The student is a standard student!");
            }
        }
        System.out.println("This student ID don't exist!");
    }

    /*********************************
     *         countStandard         *
     *********************************/
    public int countStandard() {
        System.out.println("Please enter school you want to count standard student");
        String school = new Scanner(System.in).nextLine();

        Optional<School> check = this.schoolList.stream()
                .filter(item -> item.getSchoolName().contains(school)
                ).findFirst();

        if (check.isPresent()) {
            int count = 0;
            for (Student student : check.get().getStudentSet()) {
                if (student instanceof ServiceStudent)
                    continue;
                else
                    count++;
            }
            return count;
        }else {
            System.out.println("This school don't exist!");
            return 0;
        }
    }

    /*********************************
     *     searchSemesterPoint       *
     *********************************/
    public Student checkID(String studentID) {
        for (School school : this.schoolList) {
            Optional<Student> check = school.getStudentSet().stream()
                    .filter(item -> item.equals(new Student(studentID)))
                    .findFirst();

            if (check.isPresent())
                return check.get();
        }
        return null;
    }

    public void searchPoint(Student student) {
        System.out.println("Please enter semester you want to search point: ");
        int semester = new Scanner(System.in).nextInt();

        if (student.getPointMap().containsKey(semester))
            System.out.println("Semester " + semester + ": " + student.getPointMap().get(semester));
        else
            System.out.println("This semester don't exist!");
    }

    public void searchSemesterPoint() {
        System.out.println("Please enter student ID you want to search semester point: ");
        String studentID = new Scanner(System.in).nextLine();

        Student checkResult = checkID(studentID);

        if (checkResult == null) {
            System.out.println("This student ID don't exist!");
        }else {
            searchPoint(checkResult);
        }
    }

    /*********************************
     *     searchHighestPoint       *
     *********************************/
    public void searchHighestPoint() {
        System.out.println("The highest entry point:");
        for (School school : this.schoolList) {
            System.out.println(school.getSchoolName());
            System.out.println("\t" + school.sortStudent().get(0).getFullName() + ": " + school.sortStudent().get(0).getEntryPoint());
        }
    }
}
