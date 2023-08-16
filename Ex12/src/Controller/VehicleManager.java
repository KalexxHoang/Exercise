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

public class VehicleManager {
    /**********************************
     *            Attribute           *
     **********************************/
    private Set<Vehicle> vehicleSet;

    /*********************************
     *            Constructor        *
     *********************************/
    public VehicleManager() {
        this.vehicleSet = new LinkedHashSet<>();
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
     *            printMenu          *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add vehicle");
        System.out.println("\t2: Delete vehicle");
        System.out.println("\t3: Search vehicle");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *            addBill            *
     *********************************/
    public void checkID(Vehicle vehicle) {
        Optional<Vehicle> check = this.vehicleSet.stream()
                .filter(item -> item.equals(vehicle))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("This ID already exists!");
            System.out.println("Do you want to replace?");
            System.out.println("\t1: YES");
            System.out.println("\t2: NO");
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

    public Vehicle subAdd() {
        System.out.println("ID: ");
        String ID = new Scanner(System.in).nextLine();

        System.out.println("Brand: ");
        String brand = new Scanner(System.in).nextLine();

        System.out.println("Year of Production: ");
        int productionYear = new Scanner(System.in).nextInt();

        System.out.println("Cost($): ");
        int cost = new Scanner(System.in).nextInt();

        System.out.println("Color: ");
        String color = new Scanner(System.in).nextLine();

        return new Vehicle(ID,brand,productionYear,cost,color);
    }

    public void printVehicleMenu() {
        System.out.println("What type of vehicle do you want to add:");
        System.out.println("\t1: Car");
        System.out.println("\t2: Motor");
        System.out.println("\t3: Truck");
    }

    public void addVehicle() {
        printVehicleMenu();
        int vehicleOpt = new Scanner(System.in).nextInt();
        VEHICLE opt = VEHICLE.getEnumVehicle(vehicleOpt);

        Vehicle vehicle = subAdd();

        switch (opt) {
            case CAR:
                System.out.println("Number of seat: ");
                int seatNumber = new Scanner(System.in).nextInt();

                System.out.println("Type of engine: ");
                String engineType = new Scanner(System.in).nextLine();

                Vehicle car = new Car(vehicle.getID(), vehicle.getBrand(),
                        vehicle.getProductionYear(), vehicle.getCost(),
                        vehicle.getColor(), seatNumber, engineType);
                checkID(car);
                break;

            case MOTOR:
                System.out.println("Power: ");
                int power = new Scanner(System.in).nextInt();

                Vehicle motor = new Motor(vehicle.getID(), vehicle.getBrand(),
                        vehicle.getProductionYear(), vehicle.getCost(),
                        vehicle.getColor(), power);
                checkID(motor);
                break;

            case TRUCK:
                System.out.println("Gross ton: ");
                int grossTon = new Scanner(System.in).nextInt();

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
        System.out.println("Please enter ID of vehicle you want to add: ");
        String ID = new Scanner(System.in).nextLine();

        Optional<Vehicle> check = this.vehicleSet.stream()
                .filter(item -> item.equals(new Vehicle(ID)))
                .findFirst();
        if (check.isPresent())
            this.vehicleSet.remove(check.get());
        else
            System.out.println("This vehicle don't exists!");
    }

    /*********************************
     *          seatchVehicle        *
     *********************************/
    public void searchBrand(String brand) {
        Set<Vehicle> vehicleList = this.vehicleSet.stream()
                .filter(item -> item.getBrand().contains(brand))
                .collect(Collectors.toSet());
        if (vehicleList.isEmpty()) {
            System.out.println("Thera isn't vehicle of this brand!");
        }else
            vehicleList.forEach(Vehicle::showInfor);
    }

    public void searchColor(String color) {
        Set<Vehicle> vehicleList = this.vehicleSet.stream()
                .filter(item -> item.getColor().contains(color))
                .collect(Collectors.toSet());
        if (vehicleList.isEmpty()) {
            System.out.println("Thera isn't vehicle of this color!");
        }else
            vehicleList.forEach(Vehicle::showInfor);
    }

    public void searchVehicle() {
        System.out.println("What do you want to search by?");
        System.out.println("\t1: Brand");
        System.out.println("\t2: Color");

        int searchOpt = new Scanner(System.in).nextInt();
        SEARCH opt = SEARCH.getEnumSEARCH(searchOpt);

        switch (opt) {
            case BRAND:
                System.out.println("What brand do you want to search?");
                String brand = new Scanner(System.in).nextLine();
                searchBrand(brand);
                break;

            case COLOR:
                System.out.println("What color do you want to search?");
                String color = new Scanner(System.in).nextLine();
                searchColor(color);
                break;
        }
    }
}
