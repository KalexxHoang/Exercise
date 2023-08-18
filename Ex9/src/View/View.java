package View;

import Model.Bill;
import Model.Client;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class View {
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
     *      printReplaceOption       *
     *********************************/
    public void printReplaceOption() {
        System.out.println("This ID already exists!");
        System.out.println("Do you want to replace?");
        System.out.println("\t1: YES");
        System.out.println("\t2: NO");
    }

    /*********************************
     *       printModifyOption       *
     *********************************/
    public void printModifyOption() {
        System.out.println("What information do you want to modify?");
        System.out.println("1: Full name");
        System.out.println("2: Apartment number");
        System.out.println("3: Powermeter ID");
        System.out.println("4: Exit");
    }

    /*********************************
     *            addBill            *
     *********************************/
    public Bill addBill() {
        System.out.println("Please enter bill you want to add: ");
        System.out.println();
        System.out.println("Client: ");
        String headHouseHold = this.inputFullName();
        int apartmentNumber = this.inputApartmentNumber();
        String powerMeterID = this.inputPowerMeterID();

        Client client = new Client(headHouseHold,apartmentNumber,powerMeterID);

        System.out.println();
        System.out.println("Electricity parameter:");
        System.out.println("Old index: ");
        double oldIndex = new Scanner(System.in).nextDouble();

        System.out.println("New index: ");
        double newIndex = new Scanner(System.in).nextDouble();

        return new Bill(client,oldIndex,newIndex);
    }

    /*********************************
     *           inputInfor          *
     *********************************/
    public String inputPowerMeterID() {
        System.out.println("Powermeter ID: ");
        return new Scanner(System.in).nextLine();
    }

    public String inputFullName() {
        System.out.println("Full name: ");
        return new Scanner(System.in).nextLine();
    }

    public int inputApartmentNumber() {
        System.out.println("Apartment number: ");
        return new Scanner(System.in).nextInt();
    }

    /*********************************
     *        showNoExistBill        *
     *********************************/
    public void showNoExistBill() {
        System.out.println("This bill don't exists!");
    }

    /*********************************
     *      showResultModifyID       *
     *********************************/
    public void showResultModifyID(Optional<Bill> check, Bill bill, String newPowerMeterID) {
        if (check.isPresent()) {
            System.out.println("This powermeter ID already exists! Please enter powermeter ID again.");
        }else {
            bill.getClient().setPowerMeterID(newPowerMeterID);
        }
    }

    /*********************************
     *           showMoney           *
     *********************************/
    public void outputShowMoney(Optional<Bill> check) {
        if (check.isPresent())
            System.out.println("Electricity money: " + check.get().getMoneyPay() + "$");
        else
            System.out.println("This powermeter ID don't exist!");
    }
}
