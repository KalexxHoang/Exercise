package Model.Student;

public class Student {
    /**********************************
     *            Attribute           *
     **********************************/
    private String fullName;
    private String doB;
    private String sex;
    private String phoneNumber;
    private String university;
    private String gradeLevel;

    /*********************************
     *            Constructor        *
     *********************************/
    public Student(String fullName, String doB, String sex, String phoneNumber, String university, String gradeLevel) {
        this.fullName = fullName;
        this.doB = doB;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.university = university;
        this.gradeLevel = gradeLevel;
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    /*********************************
     *          showMyInfor          *
     *********************************/
    public void showMyInfor() {
        System.out.println("Full name: " + fullName);
        System.out.println("Date of Birth: " + doB);
        System.out.println("Sex: " + sex);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("University: " + university);
        System.out.println("Grade level: " + gradeLevel);
    }

    /*********************************
     *         showNamePhone         *
     *********************************/
    public void showNamePhone() {
        System.out.println(fullName + " | " + phoneNumber);
    }
}
