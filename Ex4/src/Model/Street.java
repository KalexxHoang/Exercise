package Model;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Street {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Family> street;

    /*********************************
     *            Constructor        *
     *********************************/
    public Street() {
        this.street = new LinkedHashSet<>();
    }

    /*********************************
     *            addFamily          *
     *********************************/
    public void checkApartmentNumber(Family family) {
        for (Family item : this.street) {
            if (item.equals(family)) {
                System.out.println("This apartment number already exists!");
                System.out.println("Do you want to replace?");
                System.out.println("\t1: YES");
                System.out.println("\t2: NO");
                int option = new Scanner(System.in).nextInt();

                switch (option) {
                    case 1:
                        this.street.add(family);
                    case 2:
                        return;
                }
            }
        }
        this.street.add(family);
    }

    public void addFamily() {
        System.out.println("Please enter information about the family");
        System.out.println("\tNumber of Member: ");
        int numberMember = new Scanner(System.in).nextInt();

        System.out.println("\tApartment Number: ");
        String apartmentNumber = new Scanner(System.in).nextLine();

        Family family = new Family(numberMember,apartmentNumber);
        family.addMember();

        checkApartmentNumber(family);
    }

    /*********************************
     *          Show Family          *
     *********************************/
    public void showFamily() {
        this.street.forEach(Family::showMember);
    }
}
