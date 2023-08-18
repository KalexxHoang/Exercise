package Controller;

import Model.Street;
import View.View;

import java.util.Scanner;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Street manager;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.manager = new Street();
    }

    /*********************************
     *            User               *
     *********************************/
    public void user() {
        int quantityFamily = view.inputQuantity();

        for (int i=0; i<quantityFamily; i++) {
            this.manager.addFamily();
        }

        // Show information about family of the street
        this.manager.showFamily();
    }
}
