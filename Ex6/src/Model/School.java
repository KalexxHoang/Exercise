package Model;

import java.util.ArrayList;
import java.util.List;

public class School {
    /**********************************
     *            Attribute           *
     **********************************/
    private List<Classs> schoolList;

    /*********************************
     *            Constructor        *
     *********************************/
    public School() {
        this.schoolList = new ArrayList<>();
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public ArrayList<Classs> getSchoolList() {
        return (ArrayList<Classs>) schoolList;
    }
}
