package Model;

public class Teacher extends Person{
    /**********************************
     *            Attribute           *
     **********************************/
    private String teachID;
    private int baseSalary;
    private int bonus;
    private int realSalary;
    private int amercement;

    /*********************************
     *            Constructor        *
     *********************************/
    public Teacher(String teachID) {
        super();
        this.teachID = teachID;
    }

    public Teacher(String fullName, int age, String homeTown, String teachID, int baseSalary, int bonus, int amercement) {
        super(fullName, age, homeTown);
        this.teachID = teachID;
        this.amercement = amercement;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.realSalary = baseSalary + bonus - amercement;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getTeachID() {
        return teachID;
    }

    public void setTeachID(String teachID) {
        this.teachID = teachID;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getAmercement() {
        return amercement;
    }

    public void setAmercement(int amercement) {
        this.amercement = amercement;
    }

    public int getRealSalary() {
        return realSalary;
    }

    /*********************************
     *            equals             *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.teachID.equals(((Teacher) obj).getTeachID());
    }

    /*********************************
     *            hashCode           *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + teachID.hashCode();

        return result;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("TeachID: " + teachID);
        System.out.println("Real salary: " + realSalary);
        System.out.println("---------------------------------------------");
    }
}
