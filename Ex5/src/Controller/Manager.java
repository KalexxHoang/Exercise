package Controller;

import Model.Hotel;
import Model.Person;
import View.ROOM;
import View.MENU;
import View.View;

import java.util.Scanner;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Hotel manager;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.manager = new Hotel();
    }

    /*********************************
     *            userMenu           *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD_PERSON:
                    addPerson();
                    break;
                case DELETE_PERSON:
                    int CCCD = view.inputCCCD();
                    this.manager.deletePerson(CCCD);
                    break;
                case COMPUTE_RENT:
                    int CCCD1 = view.inputCCCD();
                    this.manager.computeRent(CCCD1);
                    break;
                case SHOW_INFOR:
                    this.manager.showInfor();
                    break;
                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *          addPerson            *
     *********************************/
    public void addPerson(){
        Person person1 = view.addPerson();
        this.manager.addPerson(person1);
    }
}
