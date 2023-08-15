package Controller;

import Model.Bill;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import Model.Client;
import View.MENU;
import View.MODIFY_OPTION;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Bill> bills;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.bills = new LinkedHashSet<>();
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
                case ADD_BILL:
                    addBill();
                    break;

                case DELETE_BILL:
                    deleteBill();
                    break;

                case MODIFY:
                    modifyInfor();
                    break;

                case MONEY_PAY:
                    computeMoney();
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add electricity bill");
        System.out.println("\t2: Delete bill");
        System.out.println("\t3: Modify clients information");
        System.out.println("\t4: Compute electricity money that client must pay");
        System.out.println("\t5: Exit");
    }

    /*********************************
     *            addBill            *
     *********************************/
    public void checkID(Bill bill) {
        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(bill))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("This ID already exists!");
            System.out.println("Do you want to replace?");
            System.out.println("\t1: YES");
            System.out.println("\t2: NO");
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.bills.remove(check.get());
                    this.bills.add(bill);
                case 2:
                    return;
            }
        }
        this.bills.add(bill);
    }

    public void addBill() {
        System.out.println("Please enter bill you want to add: ");
        System.out.println();
        System.out.println("Client: ");
        System.out.println("Full name: ");
        String headHouseHold = new Scanner(System.in).nextLine();

        System.out.println("Apartment number: ");
        int apartmentNumber = new Scanner(System.in).nextInt();

        System.out.println("Powermeter ID: ");
        String powerMeterID = new Scanner(System.in).nextLine();

        Client client = new Client(headHouseHold,apartmentNumber,powerMeterID);

        System.out.println();
        System.out.println("Electricity parameter:");
        System.out.println("Old index: ");
        double oldIndex = new Scanner(System.in).nextDouble();

        System.out.println("New index: ");
        double newIndex = new Scanner(System.in).nextDouble();

        Bill bill = new Bill(client,oldIndex,newIndex);
        checkID(bill);
    }

    /*********************************
     *          deleteBill           *
     *********************************/
    public void deleteBill() {
        System.out.println("Please enter powermeter ID of bill you want to add: ");
        String powerMeterID = new Scanner(System.in).nextLine();

        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(new Bill(new Client(powerMeterID))))
                .findFirst();
        if (check.isPresent())
            this.bills.remove(check.get());
        else
            System.out.println("This bill don't exists!");
    }

    /*********************************
     *          modifyInfor          *
     *********************************/
    public void modifyInfor() {
        System.out.println("Please enter powermeter ID of client you want to modify information: ");
        String powerMeterID = new Scanner(System.in).nextLine();

        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(new Bill(new Client(powerMeterID))))
                .findFirst();
        if (check.isPresent()) {
            handleModify(check.get());
        }
        else
            System.out.println("This bill don't exists!");
    }

    public void handleModify(Bill bill) {
        boolean condition = true;
        while (condition) {
            printOpt();
            int modifyOpt = new Scanner(System.in).nextInt();
            MODIFY_OPTION option = MODIFY_OPTION.getEnumOption(modifyOpt);
            switch (option){
                case FULL_NAME:
                    System.out.println("New full name: ");
                    String newFullName = new Scanner(System.in).nextLine();

                    bill.getClient().setHeadHouseHold(newFullName);
                    break;

                case APARTMENT_NUMBER:
                    System.out.println("New apartment number: ");
                    int newApartmentNumber = new Scanner(System.in).nextInt();

                    bill.getClient().setApartmentNumber(newApartmentNumber);
                    break;

                case POWERMETER_ID:
                    setPowerMeterID(bill);
                    break;

                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    public void printOpt() {
        System.out.println("What information do you want to modify?");
        System.out.println("1: Full name");
        System.out.println("2: Apartment number");
        System.out.println("3: Powermeter ID");
        System.out.println("4: Exit");
    }

    public void setPowerMeterID(Bill bill) {
        while (true) {
            System.out.println("New powermeter ID: ");
            String newPowerMeterID = new Scanner(System.in).nextLine();

            Optional<Bill> check = this.bills.stream()
                    .filter(item -> item.equals(new Bill(new Client(newPowerMeterID))))
                    .findFirst();

            if (check.isPresent()) {
                System.out.println("This powermeter ID already exists! Please enter powermeter ID again.");
            }else {
                bill.getClient().setPowerMeterID(newPowerMeterID);
                break;
            }
        }
    }

    /*********************************
     *          computeMoney         *
     *********************************/
    public void computeMoney() {
        System.out.println("Please enter powermeter ID you want to compute money: ");
        String powerMeterID = new Scanner(System.in).nextLine();

        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(new Bill(new Client(powerMeterID))))
                .findFirst();
        if (check.isPresent())
            System.out.println("Electricity money: " + check.get().getMoneyPay() + "$");
        else
            System.out.println("This powermeter ID don't exist!");
    }
}
