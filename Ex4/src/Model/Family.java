package Model;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Family {
    /**********************************
     *            Attribute           *
     **********************************/
    private int numberMember;
    private String apartmentNumber;
    private Set<Person> member;

    /*********************************
     *            Constructor        *
     *********************************/
    public Family(int numberMember, String apartmentNumber) {
        this.numberMember = numberMember;
        this.apartmentNumber = apartmentNumber;
        this.member = new LinkedHashSet<>();
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getNumberMember() {
        return numberMember;
    }

    public void setNumberMember(int numberMember) {
        this.numberMember = numberMember;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.apartmentNumber.equals(((Family) obj).getApartmentNumber());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + this.apartmentNumber.hashCode();

        return result;
    }

    /*********************************
     *          addMember            *
     *********************************/
    public boolean checkCCCD(Person person) {
        for (Person item : this.member) {
            if (item.equals(person)) {
                System.out.println("This CCCD already exists!");
                System.out.println("Do you want to replace?");
                System.out.println("\t1: YES");
                System.out.println("\t2: NO");
                int option = new Scanner(System.in).nextInt();

                switch (option) {
                    case 1:
                        this.member.remove(item);
                        return true;
                    case 2:
                        return false;
                }
            }
        }
        return true;
    }

    public void addInfor() {
        System.out.println("Please enter information about the member");
        System.out.println("\tFull name: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("\tAge: ");
        int age = new Scanner(System.in).nextInt();

        System.out.println("\tJob: ");
        String job = new Scanner(System.in).nextLine();

        System.out.println("\tCCCD: ");
        int CCCD = new Scanner(System.in).nextInt();

        Person person = new Person(fullName,age,job,CCCD);
        if (checkCCCD(person))
            this.member.add(person);
        else
            return;
    }

    public void addMember() {
        for (int i=0; i<this.numberMember; i++) {
            addInfor();
        }
    }

    /*********************************
     *          Show Member          *
     *********************************/
    public void showMember() {
        System.out.println("Apartment number: " + apartmentNumber);
        System.out.println("Number of member: " + numberMember);
        System.out.println("Information about members of the Family");
        this.member.forEach(Person::showInfor);
        System.out.println("---------------------------------------------");
    }
}
