package Model.Student;

public class GoodStudent extends Student{
    /**********************************
     *            Attribute           *
     **********************************/
    private double GPA;
    private String bestRewardName;

    /*********************************
     *            Constructor        *
     *********************************/
    public GoodStudent(String fullName, String doB, String sex, String phoneNumber, String university, String gradeLevel,
                       double GPA, String bestRewardName) {
        super(fullName, doB, sex, phoneNumber, university, gradeLevel);
        this.GPA = GPA;
        this.bestRewardName = bestRewardName;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    /*********************************
     *          showMyInfor          *
     *********************************/
    @Override
    public void showMyInfor() {
        super.showMyInfor();
        System.out.println("GPA: " + GPA);
        System.out.println("Best reward: " + bestRewardName);
        System.out.println("-------------------------------------------");
    }
}
