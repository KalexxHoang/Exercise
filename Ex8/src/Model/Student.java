package Model;

public class Student {
    /**********************************
     *            Attribute           *
     **********************************/
    private String fullName;
    private int age;
    private String classs;

    /*********************************
     *            Constructor        *
     *********************************/
    public Student(String fullName, int age, String classs) {
        this.fullName = fullName;
        this.age = age;
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

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    public void showInfor() {
        System.out.println("\tFull name: " + fullName);
        System.out.println("\tAge: " + age);
        System.out.println("\tClass: " + classs);
    }
}
