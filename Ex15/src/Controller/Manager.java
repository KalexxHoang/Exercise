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
import View.View;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private List<School> schoolList;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.schoolList = new LinkedList<>();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printMenu();
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
     *          inputStudent         *
     *********************************/
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
        view.printStudentOption();

        int studentOption = new Scanner(System.in).nextInt();
        STUDENT opt = STUDENT.getEnumStudent(studentOption);

        String school = view.inputSchool();
        Student student = view.createStudent();

        switch (opt) {
            case STANDARD:
                checkSchool(school,student);
                break;

            case SERVICE:
                String trainningLink = view.inputTrainningLink();

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
        String studentID = view.inputStudentID();

        for (School school : this.schoolList) {
            Optional<Student> check = school.getStudentSet().stream()
                    .filter(item -> item.equals(new Student(studentID)))
                    .findFirst();
            if (check.isPresent()) {
                view.showStudentType(check);
            }
        }
        view.showNoExistStudent();
    }

    /*********************************
     *         countStandard         *
     *********************************/
    public int countStandard() {
        String school = view.inputSchool();

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
            view.showNoExistSchool();
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
        int semester = view.inputSemester();

        view.showSemesterGPA(student,semester);
    }

    public void searchSemesterPoint() {
        String studentID = view.inputStudentID();

        Student checkResult = checkID(studentID);

        if (checkResult == null) {
            view.showNoExistStudent();
        }else {
            searchPoint(checkResult);
        }
    }
}
