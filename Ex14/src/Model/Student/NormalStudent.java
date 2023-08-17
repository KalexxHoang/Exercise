package Model.Student;

public class NormalStudent extends Student{
    /**********************************
     *            Attribute           *
     **********************************/
    private int englishScore;
    private double entryTestScore;

    /*********************************
     *            Constructor        *
     *********************************/
    public NormalStudent(String fullName, String doB, String sex, String phoneNumber, String university, String gradeLevel,
                         int englishScore, double entryTestScore) {
        super(fullName, doB, sex, phoneNumber, university, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    /*********************************
     *          showMyInfor          *
     *********************************/
    @Override
    public void showMyInfor() {
        super.showMyInfor();
        System.out.println("Toeic: " + englishScore);
        System.out.println("Entry test score: " + entryTestScore);
        System.out.println("-------------------------------------------");
    }
}
