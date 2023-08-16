package Model;

public class Car extends Vehicle{
    /**********************************
     *            Attribute           *
     **********************************/
    private int seatNumber;
    private String engineType;

    /*********************************
     *            Constructor        *
     *********************************/
    public Car(String ID, String brand, int productionYear, int cost, String color, int seatNumber, String engineType) {
        super(ID, brand, productionYear, cost, color);
        this.seatNumber = seatNumber;
        this.engineType = engineType;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    @Override
    public void showInfor() {
        System.out.println("-------------Car-------------");
        super.showInfor();
        System.out.println("Number of seat: " + seatNumber);
        System.out.println("Type of engine: " + engineType);
        System.out.println("-----------------------------");
    }
}
