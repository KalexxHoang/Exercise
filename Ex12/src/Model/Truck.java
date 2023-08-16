package Model;

public class Truck extends Vehicle{
    /**********************************
     *            Attribute           *
     **********************************/
    private int grossTon;

    /*********************************
     *            Constructor        *
     *********************************/
    public Truck(String ID, String brand, int productionYear, int cost, String color, int grossTon) {
        super(ID, brand, productionYear, cost, color);
        this.grossTon = grossTon;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getGrossTon() {
        return grossTon;
    }

    public void setGrossTon(int grossTon) {
        this.grossTon = grossTon;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    @Override
    public void showInfor() {
        System.out.println("-------------Truck-------------");
        super.showInfor();
        System.out.println("Gross ton: " + grossTon);
        System.out.println("-------------------------------");
    }
}
