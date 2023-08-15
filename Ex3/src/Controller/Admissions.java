package Controller;

import java.util.Scanner;

import Model.BlockA;
import Model.BlockB;
import Model.BlockC;
import Model.Contestant;
import View.BLOCK;
import View.MENU;

public class Admissions {
    /**********************************
     *            Attribute           *
     **********************************/
    private LogicAdmissions user;

    /*********************************
     *            Constructor        *
     *********************************/
    public Admissions() {
        this.user = new LogicAdmissions();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD_CONTESTANT:
                    System.out.println("Please enter information about contestant: ");
                    addContestant();
                    break;

                case SHOW_INFOR:
                    this.user.showContestant();
                    break;

                case SEARCH_SBD:
                    System.out.println("Please enter SBD you want to search: ");
                    searchSBD();
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *            printMenu        *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add Contestant");
        System.out.println("\t2: Show Contestant information");
        System.out.println("\t3: Search by SBD");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *          addContestant        *
     *********************************/
    public void addContestant(){
        System.out.println("SBD: ");
        String SBD = new Scanner(System.in).nextLine();

        System.out.println("Fullname: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.println("Address: ");
        String address = new Scanner(System.in).nextLine();

        System.out.println("Priority level: ");
        int priorityLevel = new Scanner(System.in).nextInt();

        System.out.println("Block: " );
        String block = new Scanner(System.in).nextLine();

        BLOCK block1 = BLOCK.getEnumBLOCK(block);

        switch (block1) {
            case BLOCK_A:
                Contestant contestant1 = new BlockA(SBD,fullName,address,priorityLevel);
                this.user.addDoc(contestant1);
                break;
            case BLOCK_B:
                Contestant contestant2= new BlockB(SBD,fullName,address,priorityLevel);
                this.user.addDoc(contestant2);
                break;
            case BLOCK_C:
                Contestant contestant3 = new BlockC(SBD,fullName,address,priorityLevel);
                this.user.addDoc(contestant3);
                break;
        }
    }

    /*********************************
     *            searchDoc          *
     *********************************/
    public void searchSBD() {
        String SBD =  new Scanner(System.in).nextLine();
        this.user.searchSBD(SBD);
    }
}
