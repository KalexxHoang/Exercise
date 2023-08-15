package Model;

import java.util.ArrayList;
import java.util.List;

public class Classs {
    /**********************************
     *            Attribute           *
     **********************************/
    private List<Student> classList;
    private String className;

    /*********************************
     *            Constructor        *
     *********************************/
    public Classs(String className) {
        this.classList = new ArrayList<>();
        this.className = className;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<Student> getClassList() {
        return (ArrayList<Student>) classList;
    }
}
