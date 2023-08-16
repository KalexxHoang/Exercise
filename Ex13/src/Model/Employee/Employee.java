package Model.Employee;

import Model.Certificate.Certificate;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class Employee {
    /**********************************
     *            Attribute           *
     **********************************/
    private String ID;
    private String fullName;
    private String birthDay;
    private int phone;
    private String email;
    private String employeeType;
    public static int employeeCount = 0;
    private Set<Certificate> certificateSet;

    /*********************************
     *            Constructor        *
     *********************************/
    public Employee(String ID) {
        this.ID = ID;
    }

    public Employee(String ID, String fullName, String birthDay, int phone, String email, String employeeType) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        Employee.employeeCount++;
        this.certificateSet = new LinkedHashSet<>();
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public LinkedHashSet<Certificate> getCertificateSet() {
        return (LinkedHashSet<Certificate>) certificateSet;
    }

    /*********************************
     *            showInfor          *
     *********************************/
    public void showInfor() {
        System.out.println("Information of employee:");
        System.out.println("ID: " + ID);
        System.out.println("Full name: " + fullName);
        System.out.println("Birthday: " + birthDay);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Type of employee: " + employeeType);
    }

    /*********************************
     *          modifyInfor          *
     *********************************/
    public void printModifyOption() {
        System.out.println("What attribute do you want to modify?");
        System.out.println("\t1: ID");
        System.out.println("\t2: Full name");
        System.out.println("\t3: Birthday");
        System.out.println("\t4: Phone");
        System.out.println("\t5: Email");
        System.out.println("\t6: Type of employee");
    }

    public void modifyInfor() {
        System.out.println("Information of employee:");
        showInfor();
    };

    /*********************************
     *         addCertificate        *
     *********************************/
    public Certificate createCertificate() {
        System.out.println("Certificate ID: ");
        String certificateID = new Scanner(System.in).nextLine();

        System.out.println("Certificate name: ");
        String certificateName = new Scanner(System.in).nextLine();

        System.out.println("Certificate rank: ");
        String certificateRank = new Scanner(System.in).nextLine();

        System.out.println("Certificate date: ");
        String certificateDate = new Scanner(System.in).nextLine();

        return new Certificate(certificateID,certificateName,certificateRank,certificateDate);
    }

    public void checkCertificateID(Certificate certificate) {
        Optional<Certificate> check =  this.certificateSet.stream()
                .filter(item -> item.equals(certificate))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("This certificate already exists!");
            System.out.println("Do you want to replace?");
            System.out.println("\t1: YES");
            System.out.println("\t2: NO");
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.certificateSet.remove(check.get());
                    this.certificateSet.add(certificate);
                case 2:
                    return;
            }
        }
        this.certificateSet.add(certificate);
    }

    public void addCertificate() {
        System.out.println("Quantity of certificate: ");
        int quantity = new Scanner(System.in).nextInt();

        for (int i=0; i<quantity; i++) {
            System.out.println("Certificate " + (i+1) + ":");
            checkCertificateID(createCertificate());
        }
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.ID.equals(((Employee) obj).getID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + ID.hashCode();

        return result;
    }
}
