package Controller;

import Model.School;
import Model.Student;
import Model.Classs;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import View.MENU;
import View.View;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private School school;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.school = new School();
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
                case ADD_STUDENT:
                    addStudent();
                    break;

                case SHOW_STUDENT:
                    view.showStudent(this.school);
                    break;

                case SHOW_AGE:
                    int age = view.inputAge();
                    showStudentAge(age);
                    break;

                case COUNT_AGE_HOMETOWN:
                    int age1 = view.inputAge();
                    String homeTown = view.inputHomeTown();

                    countStudentAgeHomeTown(age1,homeTown);
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
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
        Student student = view.addStudent();
        checkClass(student);
    }

    /*********************************
     *         showStudentAge        *
     *********************************/
    public void showStudentAge(int age) {
        int sum = 0;
        for (Classs classs : this.school.getSchoolList()) {
            ArrayList<Student> listAge = (ArrayList<Student>) classs.getClassList()
                    .stream().filter(student -> student.getAge()==age)
                    .collect(Collectors.toList());

            Optional<Student> check = listAge.stream().findFirst();
            if (check.isPresent()) {
                view.showStudentAge(classs,listAge);
                sum += listAge.size();
            }
        }
        view.showCountedStudent(age,sum);
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
        view.showCountedStudent(age,homeTown,sum);
    }
}
