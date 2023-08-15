package Model;

public class Student {
    /**********************************
     *            Attribute           *
     **********************************/
    private String fullName;
    private int age;
    private String homeTown;
    private String classs;

    /*********************************
     *            Constructor        *
     *********************************/
    public Student(String fullName, int age, String homeTown, String classs) {
        this.fullName = fullName;
        this.age = age;
        this.homeTown = homeTown;
        this.classs = classs;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showInfor() {
        System.out.println("\tFull name: " + fullName);
        System.out.println("\tAge: " + age);
        System.out.println("\tHome town: " + homeTown);
        System.out.println("\tClass: " + classs);
        System.out.println();
    }
}
