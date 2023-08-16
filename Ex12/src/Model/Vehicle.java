package Model;

public class Vehicle {
    /**********************************
     *            Attribute           *
     **********************************/
    private String ID;
    private String brand;
    private int productionYear;
    private int cost;
    private String color;

    /*********************************
     *            Constructor        *
     *********************************/
    public Vehicle(String ID) {
        this.ID = ID;
    }

    public Vehicle(String ID, String brand, int productionYear, int cost, String color) {
        this.ID = ID;
        this.brand = brand;
        this.productionYear = productionYear;
        this.cost = cost;
        this.color = color;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    public void showInfor() {
        System.out.println("ID: " + ID);
        System.out.println("Brand: " + brand);
        System.out.println("Year of Production: " + productionYear);
        System.out.println("Cost: " + cost);
        System.out.println("Color: " + color);
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.ID.equals(((Vehicle) obj).getID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + ID.hashCode();

        return result;
    }
}
