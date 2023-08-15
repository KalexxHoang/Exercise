package Model;

public class BlockA extends Contestant{
    /*********************************
     *            Constructor        *
     ********************************
     * @param SBD
     * @param fullName
     * @param address
     * @param priorityLevel*/
    public BlockA(String SBD, String fullName, String address, int priorityLevel) {
        super(SBD, fullName, address, priorityLevel);
        this.setBlock("A");
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("\tBlock: " + this.getBlock());
        System.out.println("\tExamine subject: Math - Physic - Chemistry");
        System.out.println("-----------------------------------------------");
    }
}
