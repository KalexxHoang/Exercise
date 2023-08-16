package Model;

public class Motor extends Vehicle{
    /**********************************
     *            Attribute           *
     **********************************/
    private int power;

    /*********************************
     *            Constructor        *
     *********************************/
    public Motor(String ID, String brand, int productionYear, int cost, String color, int power) {
        super(ID, brand, productionYear, cost, color);
        this.power = power;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    @Override
    public void showInfor() {
        System.out.println("-------------Motor-------------");
        super.showInfor();
        System.out.println("Power: " + power);
        System.out.println("-------------------------------");
    }
}
