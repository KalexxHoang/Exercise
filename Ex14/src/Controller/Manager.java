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

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private List<Student> studentList;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.studentList = new LinkedList<>();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu() throws InvalidPhoneNumberException, InvalidFullNameException, InvalidDOBException {
        int menuOp;
        boolean condition = true;
        while (condition){
            printMenu();
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
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add student");
        System.out.println("\t2: Show choosed candidates");
        System.out.println("\t3: Show total candidates list");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *            addStudent         *
     *********************************/
    public void addStudent() throws InvalidFullNameException, InvalidDOBException, InvalidPhoneNumberException {
        System.out.println("Please enter information of student you want to add:");
        System.out.println("Full name: ");
        String fullName = new Scanner(System.in).nextLine();
        Check.checkFullName(fullName);

        System.out.println("Date of Birth: ");
        String doB = new Scanner(System.in).nextLine();
        Check.checkDOB(doB);

        System.out.println("Sex: ");
        String sex = new Scanner(System.in).nextLine();

        System.out.println("Phone number: ");
        String phoneNumber = new Scanner(System.in).nextLine();
        Check.checkPhoneNumber(phoneNumber);

        System.out.println("University: ");
        String university = new Scanner(System.in).nextLine();

        System.out.println("Grade level: ");
        System.out.println("\t1: Good");
        System.out.println("\t2: Normal");

        int levelOption = new Scanner(System.in).nextInt();
        GRADE_LEVEL opt = GRADE_LEVEL.getEnumGradeLevel(levelOption);

        switch (opt) {
            case GOOD:
                System.out.println("GPA: ");
                double GPA = new Scanner(System.in).nextDouble();

                System.out.println("Best reward: ");
                String bestRewardName = new Scanner(System.in).nextLine();

                Student goodStudent = new GoodStudent(fullName,doB,sex,phoneNumber,university,GRADE_LEVEL.getString(GRADE_LEVEL.GOOD),
                                                      GPA,bestRewardName);
                this.studentList.add(goodStudent);
                break;

            case NORMAL:
                System.out.println("Toeic: ");
                int englishScore = new Scanner(System.in).nextInt();

                System.out.println("Entry test score: ");
                double entryTestScore = new Scanner(System.in).nextDouble();

                Student normalStudent = new NormalStudent(fullName,doB,sex,phoneNumber,university,GRADE_LEVEL.getString(GRADE_LEVEL.NORMAL),
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
        System.out.println("Please enter quantity of candidate (11 <= n <= 15) you want to choose: ");
        int numberCandidate = new Scanner(System.in).nextInt();

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
        System.out.println("Do you want to show by?");
        System.out.println("\t1: Full name");
        System.out.println("\t2: Phone number");

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
