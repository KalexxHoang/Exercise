package Model.Student;

public class ServiceStudent extends Student{
    /**********************************
     *            Attribute           *
     **********************************/
    private String trainningLink;

    /*********************************
     *            Constructor        *
     *********************************/
    public ServiceStudent(String studentID, String fullName, String birthDay, int entryYear, double entryPoint, String trainningLink) {
        super(studentID, fullName, birthDay, entryYear, entryPoint);
        this.trainningLink = trainningLink;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getTrainningLink() {
        return trainningLink;
    }

    public void setTrainningLink(String trainningLink) {
        this.trainningLink = trainningLink;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    @Override
    public void showInfor() {
        super.showInfor();
        System.out.println("Trainning link: " + trainningLink);
    }
}
