package Person;
public class KySu extends CanBo {
    /*********************************
     *            Attribute           *
     **********************************/
    private String nganhDaoTao;

    /*********************************
     *            Constructor        *
     *********************************/
    public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    /*********************************
     *        showInfor              *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("\t Ngành đào tạo: " + this.getNganhDaoTao());
    }
}
