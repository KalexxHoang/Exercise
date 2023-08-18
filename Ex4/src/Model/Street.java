package Model;

import View.View;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Street {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Family> street;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Street() {
        this.view = new View();
        this.street = new LinkedHashSet<>();
    }

    /*********************************
     *            addFamily          *
     *********************************/
    public void checkApartmentNumber(Family family) {
        for (Family item : this.street) {
            if (item.equals(family)) {
                view.showReplaceOption();
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
        int numberMember = view.inputNumberMember();
        String apartmentNumber = view.inputApartmentNumber();

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
