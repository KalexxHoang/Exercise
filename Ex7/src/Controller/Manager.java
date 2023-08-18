package Controller;

import Model.Teacher;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import View.MENU;
import View.View;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Teacher> teacherSet;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.teacherSet = new LinkedHashSet<>();
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
                case ADD_TEACHER:
                    addTeacher();
                    break;

                case SHOW_TEACHER:
                    showTeacher();
                    break;

                case DELETE_TEACHER:
                    String teachID = view.inputTeachID();
                    deleteTeacher(teachID);
                    break;

                case COMPUTE_SALARY:
                    String teachID1 = view.inputTeachID();
                    computeSalary(teachID1);
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *            addTeacher         *
     *********************************/
    public void checkTeacher(Teacher teacher) {
        Optional<Teacher> check = this.teacherSet
                .stream().filter(item -> item.equals(teacher))
                .findFirst();

        if (check.isPresent()) {
            view.printReplaceOption();
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
        Teacher teacher = view.addTeacher();
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
            view.showTeacherEmpty();
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
            view.showTeacherNoExist();
    }

    /*********************************
     *          computeSalary        *
     *********************************/
    public void computeSalary(String teachID) {
        Optional<Teacher> check = this.teacherSet.stream()
                .filter(item -> item.equals(new Teacher(teachID)))
                .findFirst();

        view.showSalary(check);
    }
}
