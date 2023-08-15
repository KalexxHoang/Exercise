package Model;

public class Client {
    /**********************************
     *            Attribute           *
     **********************************/
    private String headHouseHold;
    private int apartmentNumber;
    private String powerMeterID;

    /*********************************
     *            Constructor        *
     *********************************/
    public Client(String powerMeterID) {
        this.powerMeterID = powerMeterID;
    }

    public Client(String headHouseHold, int apartmentNumber, String powerMeterID) {
        this.headHouseHold = headHouseHold;
        this.apartmentNumber = apartmentNumber;
        this.powerMeterID = powerMeterID;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getHeadHouseHold() {
        return headHouseHold;
    }

    public void setHeadHouseHold(String headHouseHold) {
        this.headHouseHold = headHouseHold;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPowerMeterID() {
        return powerMeterID;
    }

    public void setPowerMeterID(String powerMeterID) {
        this.powerMeterID = powerMeterID;
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.powerMeterID.equals(((Client) obj).getPowerMeterID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + powerMeterID.hashCode();

        return result;
    }
}
