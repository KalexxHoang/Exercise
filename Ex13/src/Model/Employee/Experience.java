package Model.Employee;

import Controller.Manager;
import Model.Certificate.Certificate;
import Model.ModifyEnum.MODIFY_EXPERIENCE;
import View.EMPLOYEE;
import View.Main;

import java.util.Scanner;

public class Experience extends Employee{
    /**********************************
     *            Attribute           *
     **********************************/
    private int expInYear;
    private String proSkill;

    /**********************************
     *            Constructor         *
     **********************************/
    public Experience(String ID, String fullName, String birthDay, int phone, String email, String employeeType,
                      int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employeeType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    /*********************************
     *            showInfor          *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Number years of experience: " + expInYear);
        System.out.println("Pro skill: " + proSkill);
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
            System.out.println("\t7: Number years of experience");
            System.out.println("\t8: Pro skill");
            System.out.println("\t9: Exit");

            int modifyOption = new Scanner(System.in).nextInt();
            MODIFY_EXPERIENCE opt = MODIFY_EXPERIENCE.getEnumModifyExperience(modifyOption);

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

                case EXPERIENCE_YEAR:
                    System.out.println("New experience year: ");
                    int newExpInYear = new Scanner(System.in).nextInt();
                    this.setExpInYear(newExpInYear);
                    break;

                case PRO_SKILL:
                    System.out.println("New pro skill: ");
                    String newProSkill = new Scanner(System.in).nextLine();
                    this.setEmail(newProSkill);
                    break;

                case EXIT:
                    condition = false;
                    break;
            }
        }
    }
}
