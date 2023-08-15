package Model;

public class BlockB extends Contestant{
    /*********************************
     *            Constructor        *
     ********************************
     * @param SBD
     * @param fullName
     * @param address
     * @param priorityLevel*/
    public BlockB(String SBD, String fullName, String address, int priorityLevel) {
        super(SBD, fullName, address, priorityLevel);
        this.setBlock("B");
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("\tBlock: " + this.getBlock());
        System.out.println("\tExamine subject: Math - Chemistry - Biology");
        System.out.println("-----------------------------------------------");
    }
}
