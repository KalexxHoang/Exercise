package Model;

public class BlockC extends Contestant{
    /*********************************
     *            Constructor        *
     ********************************
     * @param SBD
     * @param fullName
     * @param address
     * @param priorityLevel*/
    public BlockC(String SBD, String fullName, String address, int priorityLevel) {
        super(SBD, fullName, address, priorityLevel);
        this.setBlock("C");
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("\tBlock: " + this.getBlock());
        System.out.println("\tExamine subject: Literature - History - Geography");
        System.out.println("-----------------------------------------------");
    }
}
