package Person;
public class CanBo {
    /*********************************
     *            Attribute           *
     **********************************/
    private String hoTen;
    private int tuoi;
    private String gioiTinh;
    private String diaChi;

    /*********************************
     *            Constructor        *
     *********************************/
    public CanBo(String hoTen, int tuoi, String gioiTinh, String diaChi){
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /*********************************
     *        showInfor              *
     *********************************/
    public void showInfor(){
        System.out.println("Nhân viên:");
        System.out.println("\t Tên: " + this.getHoTen());
        System.out.println("\t Tuổi: " + this.getTuoi());
        System.out.println("\t Giới tính: " + this.getGioiTinh());
        System.out.println("\t Địa chỉ: " + this.getDiaChi());
    }
}
