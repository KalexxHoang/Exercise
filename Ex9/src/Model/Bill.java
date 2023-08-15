package Model;

public class Bill {
    /**********************************
     *            Attribute           *
     **********************************/
    private Client client;
    private double oldIndex;
    private double newIndex;
    private double moneyPay;

    /*********************************
     *            Constructor        *
     *********************************/
    public Bill(Client client) {
        this.client = client;
    }

    public Bill(Client client, double oldIndex, double newIndex) {
        this.client = client;
        this.oldIndex = oldIndex;
        this.newIndex = newIndex;
        this.moneyPay = (newIndex - oldIndex)*5;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getOldIndex() {
        return oldIndex;
    }

    public void setOldIndex(double oldIndex) {
        this.oldIndex = oldIndex;
    }

    public double getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(double newIndex) {
        this.newIndex = newIndex;
    }

    public double getMoneyPay() {
        return moneyPay;
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.client.getPowerMeterID().equals(((Bill) obj).getClient().getPowerMeterID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + this.client.getPowerMeterID().hashCode();

        return result;
    }
}
