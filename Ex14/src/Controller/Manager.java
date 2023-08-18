package Controller;

import Model.Exception.InvalidDOBException;
import Model.Exception.InvalidFullNameException;
import Model.Exception.InvalidPhoneNumberException;
import Model.Student.GoodStudent;
import Model.Student.NormalStudent;
import Model.Student.Student;

import java.util.*;
import java.util.stream.Collectors;

import View.GRADE_LEVEL;
import View.MENU;
import View.SHOW;
import View.View;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private List<Student> studentList;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.studentList = new LinkedList<>();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu() throws InvalidPhoneNumberException, InvalidFullNameException, InvalidDOBException {
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD:
                    addStudent();
                    break;

                case CHOOSE:
                    chooseCandidate().forEach(Student::showMyInfor);
                    break;

                case SHOW:
                    showBy();
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
    public void addStudent() throws InvalidFullNameException, InvalidDOBException, InvalidPhoneNumberException {
        Student student = view.addStudent();

        view.printGradeOption();
        int levelOption = new Scanner(System.in).nextInt();
        GRADE_LEVEL opt = GRADE_LEVEL.getEnumGradeLevel(levelOption);

        switch (opt) {
            case GOOD:
                double GPA = view.inputGPA();
                String bestRewardName = view.inputBestRewardName();

                Student goodStudent = new GoodStudent(student.getFullName(),student.getDoB(),student.getSex(), student.getPhoneNumber(),
                                                      student.getUniversity(),GRADE_LEVEL.getString(GRADE_LEVEL.GOOD),
                                                      GPA,bestRewardName);
                this.studentList.add(goodStudent);
                break;

            case NORMAL:
                int englishScore = view.inputEnglishScore();
                double entryTestScore = view.inputEntryScore();

                Student normalStudent = new NormalStudent(student.getFullName(),student.getDoB(),student.getSex(), student.getPhoneNumber(),
                                                          student.getUniversity(),GRADE_LEVEL.getString(GRADE_LEVEL.NORMAL),
                                                          englishScore,entryTestScore);
                this.studentList.add(normalStudent);
                break;
        }
    }

    /*********************************
     *        chooseCandidate        *
     *********************************/
    public List<Student> filtGood() {
        return this.studentList.stream()
                .filter(item -> item.getGradeLevel().contains("Good"))
                .collect(Collectors.toList());
    }

    public List<Student> filtNormal() {
        return this.studentList.stream()
                .filter(item -> item.getGradeLevel().contains("Normal"))
                .collect(Collectors.toList());
    }

    public List<Student> sortGoodList(List<Student> goodList) {
        Collections.sort(goodList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (((GoodStudent) o1).getGPA() > ((GoodStudent) o2).getGPA())
                    return -1;
                else if (((GoodStudent) o1).getGPA() < ((GoodStudent) o2).getGPA())
                    return 1;
                else
                    return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        return goodList;
    }

    public List<Student> sortNormalStudent(List<Student> normalList) {
        Collections.sort(normalList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (((NormalStudent) o1).getEntryTestScore() > ((NormalStudent) o2).getEntryTestScore())
                    return -1;
                else if (((NormalStudent) o1).getEntryTestScore() < ((NormalStudent) o2).getEntryTestScore())
                    return 1;
                else {
                    if (((NormalStudent) o1).getEnglishScore() > ((NormalStudent) o2).getEnglishScore())
                        return -1;
                    else if (((NormalStudent) o1).getEnglishScore() < ((NormalStudent) o2).getEnglishScore())
                        return 1;
                    else
                        return o1.getFullName().compareTo(o2.getFullName());
                }
            }
        });
        return normalList;
    }

    public List<Student> chooseCandidate() {
        int numberCandidate = view.inputQuantity();

        List<Student> goodList = sortGoodList(filtGood());
        List<Student> normalList = sortNormalStudent(filtNormal());

        if (goodList.size() <= numberCandidate) {
            List<Student> chooseList = goodList;
            for (int i=0; i<(numberCandidate - goodList.size()); i++) {
                chooseList.add(normalList.get(i));
            }
            return chooseList;
        }
        else {
            return goodList.stream()
                    .filter(item -> goodList.indexOf(item) < numberCandidate)
                    .collect(Collectors.toList());
        }
    }

    /*********************************
     *             sortShow          *
     *********************************/
    public void sortNameShow() {
        Collections.sort(this.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getFullName().compareTo(o2.getFullName());
            }
        });

        this.studentList.forEach(Student::showNamePhone);
    }

    public void sortPhoneShow() {
        Collections.sort(this.studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
            }
        });

        this.studentList.forEach(Student::showNamePhone);
    }

    public void showBy() {
        view.printShowOption();

        int showOpt = new Scanner(System.in).nextInt();
        SHOW opt = SHOW.getEnumMenu(showOpt);
        switch (opt) {
            case NAME:
                sortNameShow();
                break;

            case PHONE:
                sortPhoneShow();
                break;
        }
    }
}
