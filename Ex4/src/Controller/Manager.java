package Controller;

import Model.Street;

import java.util.Scanner;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Street manager;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.manager = new Street();
    }

    /*********************************
     *            User               *
     *********************************/
    public void user() {
        System.out.println("Please enter quantity of family of the street");
        int quantityFamily = new Scanner(System.in).nextInt();

        for (int i=0; i<quantityFamily; i++) {
            this.manager.addFamily();
        }

        // Show information about family of the street
        this.manager.showFamily();
    }
}
