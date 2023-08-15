package Person;
public class CongNhan extends CanBo {
    /*********************************
     *            Attribute           *
     **********************************/
    private int bac;

    /*********************************
     *            Constructor        *
     *********************************/
    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    /*********************************
     *        showInfor              *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("\t Bậc: " + this.getBac());
    }
}
