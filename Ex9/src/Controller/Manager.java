package Controller;

import Model.Bill;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import Model.Client;
import View.MENU;
import View.MODIFY_OPTION;
import View.View;

public class Manager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Bill> bills;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager() {
        this.view = new View();
        this.bills = new LinkedHashSet<>();
    }

    /*********************************
     *            Menu               *
     *********************************/
    public void userMenu(){
        int menuOp;
        boolean condition = true;
        while (condition){
            view.printMenu();
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
     *            addBill            *
     *********************************/
    public void checkID(Bill bill) {
        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(bill))
                .findFirst();

        if (check.isPresent()) {
            view.printReplaceOption();
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
        Bill bill = view.addBill();
        checkID(bill);
    }

    /*********************************
     *          deleteBill           *
     *********************************/
    public void deleteBill() {
        String powerMeterID = view.inputPowerMeterID();

        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(new Bill(new Client(powerMeterID))))
                .findFirst();
        if (check.isPresent())
            bills.remove(check.get());
        else
            view.showNoExistBill();
    }

    /*********************************
     *          modifyInfor          *
     *********************************/
    public void modifyInfor() {
        String powerMeterID = view.inputPowerMeterID();

        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(new Bill(new Client(powerMeterID))))
                .findFirst();
        if (check.isPresent()) {
            handleModify(check.get());
        }
        else
            view.showNoExistBill();
    }

    public void handleModify(Bill bill) {
        boolean condition = true;
        while (condition) {
            view.printModifyOption();
            int modifyOpt = new Scanner(System.in).nextInt();
            MODIFY_OPTION option = MODIFY_OPTION.getEnumOption(modifyOpt);
            switch (option){
                case FULL_NAME:
                    String newFullName = view.inputFullName();
                    bill.getClient().setHeadHouseHold(newFullName);
                    break;

                case APARTMENT_NUMBER:
                    int newApartmentNumber = view.inputApartmentNumber();
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

    public void setPowerMeterID(Bill bill) {
        while (true) {
            String newPowerMeterID = view.inputPowerMeterID();
            Optional<Bill> check = this.bills.stream()
                    .filter(item -> item.equals(new Bill(new Client(newPowerMeterID))))
                    .findFirst();

            view.showResultModifyID(check,bill,newPowerMeterID);
        }
    }

    /*********************************
     *          computeMoney         *
     *********************************/
    public void computeMoney() {
        String powerMeterID = view.inputPowerMeterID();

        Optional<Bill> check = this.bills.stream()
                .filter(item -> item.equals(new Bill(new Client(powerMeterID))))
                .findFirst();

        view.outputShowMoney(check);
    }
}
