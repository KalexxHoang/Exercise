package Model.Employee;

import Controller.Manager;
import Model.Certificate.Certificate;
import Model.ModifyEnum.MODIFY_INTERN;
import View.EMPLOYEE;
import View.Main;

import java.util.Scanner;

public class Intern extends Employee{
    /**********************************
     *            Attribute           *
     **********************************/
    private String majors;
    private int semester;
    private String university;

    /*********************************
     *            Constructor        *
     *********************************/
    public Intern(String ID, String fullName, String birthDay, int phone, String email, String employeeType,
                  String majors, int semester, String university) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.majors = majors;
        this.semester = semester;
        this.university = university;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    /*********************************
     *            showInfor          *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Majors: " + majors);
        System.out.println("Semester: " + semester);
        System.out.println("University: " + university);
        this.getCertificateSet().forEach(Certificate::showCertificate);
        System.out.println("---------------------------------------------------");
    }

    /*********************************
     *          modifyInfor          *
     *********************************/
    @Override
    public void modifyInfor() {
        super.modifyInfor();
        boolean condition = true;
        while (condition) {
            this.printModifyOption();
            System.out.println("\t7: Majors");
            System.out.println("\t8: Semester");
            System.out.println("\t9: University");
            System.out.println("\t10: Exit");

            int modifyOption = new Scanner(System.in).nextInt();
            MODIFY_INTERN opt = MODIFY_INTERN.getEnumModifyIntern(modifyOption);

            switch (opt) {
                case ID:
                    String newID;
                    while (true) {
                        System.out.println("New ID: ");
                        newID = new Scanner(System.in).nextLine();
                        String finalNewID = newID;
                        if (Main.employeeSet.stream().anyMatch(item -> item.equals(new Employee(finalNewID))))
                            System.out.println("This ID already exist!");
                        else
                            break;
                    }
                    this.setID(newID);
                    break;

                case FULLNAME:
                    System.out.println("New full name: ");
                    String newFullName = new Scanner(System.in).nextLine();
                    this.setFullName(newFullName);
                    break;

                case BIRTHDAY:
                    System.out.println("New birthday: ");
                    String newBirthDay = new Scanner(System.in).nextLine();
                    this.setBirthDay(newBirthDay);
                    break;

                case PHONE:
                    System.out.println("New phone: ");
                    int newPhone = new Scanner(System.in).nextInt();
                    this.setPhone(newPhone);
                    break;

                case EMAIL:
                    System.out.println("New email: ");
                    String newEmail = new Scanner(System.in).nextLine();
                    this.setEmail(newEmail);
                    break;

                case TYPE_EMPLOYEE:
                    System.out.println("New type of employee: ");
                    System.out.println("\t1: Experience");
                    System.out.println("\t2: Fresher");
                    System.out.println("\t3: Intern");

                    int typeOpt = new Scanner(System.in).nextInt();
                    this.setEmployeeType(EMPLOYEE.getString(EMPLOYEE.getEnumEmployee(typeOpt)));
                    break;

                case MAJORS:
                    System.out.println("New majors: ");
                    String newMajors = new Scanner(System.in).nextLine();
                    this.setMajors(newMajors);
                    break;

                case SEMESTER:
                    System.out.println("New semester: ");
                    int newSemester = new Scanner(System.in).nextInt();
                    this.setSemester(newSemester);
                    break;

                case UNIVERSITY:
                    System.out.println("New university: ");
                    String newUniversity = new Scanner(System.in).nextLine();
                    this.setUniversity(newUniversity);
                    break;

                case EXIT:
                    condition = false;
                    break;
            }
        }
    }
}
