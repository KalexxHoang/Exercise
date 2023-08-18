package Controller;

import Model.Car;
import Model.Motor;
import Model.Truck;
import Model.Vehicle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;
import java.util.Set;

import View.MENU;
import View.SEARCH;
import View.VEHICLE;
import View.View;

public class VehicleManager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Vehicle> vehicleSet;
    private View view;

    /*********************************
     *            Constructor        *
     *********************************/
    public VehicleManager() {
        this.view = new View();
        this.vehicleSet = new LinkedHashSet<>();
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
                case ADD_VEHICLE:
                    addVehicle();
                    break;

                case DELETE_VEHICLE:
                    deleteVehicle();
                    break;

                case SEARCH_VEHICLE:
                    searchVehicle();
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
    public void checkID(Vehicle vehicle) {
        Optional<Vehicle> check = this.vehicleSet.stream()
                .filter(item -> item.equals(vehicle))
                .findFirst();

        if (check.isPresent()) {
            view.printReplaceOption();
            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.vehicleSet.remove(check.get());
                    this.vehicleSet.add(vehicle);
                case 2:
                    return;
            }
        }
        this.vehicleSet.add(vehicle);
    }

    public void addVehicle() {
        view.printVehicleMenu();
        int vehicleOpt = new Scanner(System.in).nextInt();
        VEHICLE opt = VEHICLE.getEnumVehicle(vehicleOpt);

        Vehicle vehicle = view.createVehicle();

        switch (opt) {
            case CAR:
                int seatNumber = view.inputSeatNumber();
                String engineType = view.inputEngineType();

                Vehicle car = new Car(vehicle.getID(), vehicle.getBrand(),
                        vehicle.getProductionYear(), vehicle.getCost(),
                        vehicle.getColor(), seatNumber, engineType);
                checkID(car);
                break;

            case MOTOR:
                int power = view.inputPower();

                Vehicle motor = new Motor(vehicle.getID(), vehicle.getBrand(),
                        vehicle.getProductionYear(), vehicle.getCost(),
                        vehicle.getColor(), power);
                checkID(motor);
                break;

            case TRUCK:
                int grossTon = view.inputGrossTon();

                Vehicle truck = new Truck(vehicle.getID(), vehicle.getBrand(),
                        vehicle.getProductionYear(), vehicle.getCost(),
                        vehicle.getColor(), grossTon);
                checkID(truck);
                break;
        }
    }

    /*********************************
     *          deleteVehicle        *
     *********************************/
    public void deleteVehicle() {
        String ID = view.inputID();

        Optional<Vehicle> check = this.vehicleSet.stream()
                .filter(item -> item.equals(new Vehicle(ID)))
                .findFirst();
        if (check.isPresent())
            this.vehicleSet.remove(check.get());
        else
            view.showNoExistVehicle();
    }

    /*********************************
     *          seatchVehicle        *
     *********************************/
    public void searchBrand(String brand) {
        Set<Vehicle> vehicleList = this.vehicleSet.stream()
                .filter(item -> item.getBrand().contains(brand))
                .collect(Collectors.toSet());
        if (vehicleList.isEmpty()) {
            view.showNoExistVehicle();
        }else
            vehicleList.forEach(Vehicle::showInfor);
    }

    public void searchColor(String color) {
        Set<Vehicle> vehicleList = this.vehicleSet.stream()
                .filter(item -> item.getColor().contains(color))
                .collect(Collectors.toSet());
        if (vehicleList.isEmpty()) {
            view.showNoExistVehicle();
        }else
            vehicleList.forEach(Vehicle::showInfor);
    }

    public void searchVehicle() {
        view.showSearchOption();

        int searchOpt = new Scanner(System.in).nextInt();
        SEARCH opt = SEARCH.getEnumSEARCH(searchOpt);

        switch (opt) {
            case BRAND:
                String brand = view.inputBrand();
                searchBrand(brand);
                break;

            case COLOR:
                String color = view.inputColor();
                searchColor(color);
                break;
        }
    }
}
