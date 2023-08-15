package Model;

public class Contestant {
    /**********************************
     *            Attribute           *
     **********************************/
    // SBD is the only one
    private String SBD;
    private String fullName;
    private String address;
    private int priorityLevel;
    private String block;

    /*********************************
     *            Constructor        *
     *********************************/
    public Contestant(String SBD) {
        this.SBD = SBD;
    }

    public Contestant(String SBD, String fullName, String address, int priorityLevel) {
        this.SBD = SBD;
        this.fullName = fullName;
        this.address = address;
        this.priorityLevel = priorityLevel;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getSBD() {
        return SBD;
    }

    public void setSBD(String SBD) {
        this.SBD = SBD;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showInfor() {
        System.out.println("Information about contestant");
        System.out.println("\tSBD: " + SBD);
        System.out.println("\tFullname: " + fullName);
        System.out.println("\tAddress: " + address);
        System.out.println("\tPriority level: " + priorityLevel);
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.SBD.equals(((Contestant) obj).getSBD());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + SBD.hashCode();

        return result;
    }
}
