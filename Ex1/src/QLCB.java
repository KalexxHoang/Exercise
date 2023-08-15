import Person.CanBo;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class QLCB {
    /*********************************
    *            Attribute           *
    **********************************/
    private ArrayList<CanBo> canBo;

    /*********************************
     *            Constructor        *
     *********************************/
    public QLCB(){
        this.canBo = new ArrayList<>();
    }

    /*********************************
     *            Add Member         *
     *********************************/
    public void add(CanBo canBo){
        this.canBo.add(canBo);
    }

    /*********************************
     *            Search Member      *
     *********************************/
    public ArrayList<CanBo> searchCanBo(String hoTen) {
        return (ArrayList<CanBo>) this.canBo.stream().filter(i -> i.getHoTen().contains(hoTen)).collect(Collectors.toList());
    }

    public void showSearched(String hoTen){
        ArrayList<CanBo> cb = searchCanBo(hoTen);
        for (CanBo canBo : cb){
            canBo.showInfor();
        }
    }

    /*********************************
     *            Show Member        *
     *********************************/
    public void showCanBo(){
        for (CanBo canBo : this.canBo){
            canBo.showInfor();
        }
    }
}
