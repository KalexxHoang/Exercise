import ENUM.CAN_BO;
import ENUM.MENU;
import Person.CanBo;
import Person.CongNhan;
import Person.KySu;
import Person.NhanVien;

import java.util.Scanner;

public class Manager {
    /*********************************
     *            Attribute           *
     **********************************/
    private QLCB qlcb;

    /*********************************
     *            Constructor        *
     *********************************/
    public Manager(){
        this.qlcb = new QLCB();
    }

    /*********************************
     *            userView           *
     *********************************/
    public void userView(){
        int menuOp;
        boolean condition = true;
        while (condition){
            printMenu();
            menuOp = new Scanner(System.in).nextInt();
            MENU menu = MENU.getEnumMenu(menuOp);
            switch (menu){
                case ADD_MEMBER:
                    addMember(this.qlcb);
                    break;
                case SEARCH_MEMBER:
                    System.out.println("Nhập tên cán bộ muốn tìm: ");
                    String name = new Scanner(System.in).nextLine();
                    this.qlcb.showSearched(name);
                    break;
                case SHOW_MEMBER:
                    this.qlcb.showCanBo();
                    break;
                case EXIT:
                    condition = false;
                    break;

            }
        }
    }

    /*********************************
     *            printMenu        *
     *********************************/
    public void printMenu(){
        System.out.println("Menu:");
        System.out.println("\t1: Add member");
        System.out.println("\t2: Search member");
        System.out.println("\t3: Show member");
        System.out.println("\t4: Exit");
    }

    /*********************************
     *            printJob           *
     *********************************/
    public void printJob(){
        System.out.println("What job do you want to add?");
        System.out.println("\t1: Nhân viên");
        System.out.println("\t2: Kỹ sư");
        System.out.println("\t3: Công nhân");
    }

    /*********************************
     *            addMember          *
     *********************************/
    public void addMember(QLCB qlcb){
        printJob();
        int jobOp = new Scanner(System.in).nextInt();
        CAN_BO job = CAN_BO.getEnumCanBo(jobOp);
        System.out.println("Nhập họ tên: ");
        String hoTen = new Scanner(System.in).nextLine();
        System.out.println("Nhập tuổi: ");
        int tuoi = new Scanner(System.in).nextInt();
        System.out.println("Nhập giới tính: ");
        String gioiTinh = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ: ");
        String diaChi = new Scanner(System.in).nextLine();

        switch (job) {
            case NHAN_VIEN:
                System.out.println("Nhập công việc của nhân viên: ");
                String congViec = new Scanner(System.in).nextLine();
                CanBo cb1 = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
                this.qlcb.add(cb1);
                break;
            case KY_SU:
                System.out.println("Nhập ngành đào tạo kỹ sư: ");
                String nganhDaoTao = new Scanner(System.in).nextLine();
                CanBo cb2 = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
                this.qlcb.add(cb2);
                break;
            case CONG_NHAN:
                System.out.println("Nhập bậc công nhân");
                int bac = new Scanner(System.in).nextInt();
                CanBo cb3 = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
                this.qlcb.add(cb3);
                break;
        }
    }
}
