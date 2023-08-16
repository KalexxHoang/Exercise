package Model.Employee;

import Controller.Manager;
import Model.Certificate.Certificate;
import Model.ModifyEnum.MODIFY_FRESHER;
import View.EMPLOYEE;
import View.Main;

import java.util.Scanner;

public class Fresher extends Employee{
    /**********************************
     *            Attribute           *
     **********************************/
    private String graduationDate;
    private String graduationRank;
    private String education;

    /**********************************
     *            Constructor         *
     **********************************/
    public Fresher(String ID, String fullName, String birthDay, int phone, String email, String employeeType,
                   String graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    /*********************************
     *            showInfor          *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Graduation date: " + graduationDate);
        System.out.println("Graduation rank: " + graduationRank);
        System.out.println("Education: " + education);
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
            System.out.println("\t7: Graduation date");
            System.out.println("\t8: Graduation rank");
            System.out.println("\t9: Education");
            System.out.println("\t10: Exit");

            int modifyOption = new Scanner(System.in).nextInt();
            MODIFY_FRESHER opt = MODIFY_FRESHER.getEnumModifyFresher(modifyOption);

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

                case GRAD_DATE:
                    System.out.println("New graduation date: ");
                    String newGradDate = new Scanner(System.in).nextLine();
                    this.setGraduationDate(newGradDate);
                    break;

                case GRAD_RANK:
                    System.out.println("New graduation rank: ");
                    String newGradRank = new Scanner(System.in).nextLine();
                    this.setGraduationDate(newGradRank);
                    break;

                case EDUCATION:
                    System.out.println("New education: ");
                    String newEducation = new Scanner(System.in).nextLine();
                    this.setEducation(newEducation);
                    break;

                case EXIT:
                    condition = false;
                    break;
            }
        }
    }
}
