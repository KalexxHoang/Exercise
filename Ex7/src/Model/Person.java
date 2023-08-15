package Model;

public class Person {
    /**********************************
     *            Attribute           *
     **********************************/
    private String fullName;
    private int age;
    private String homeTown;

    /*********************************
     *            Constructor        *
     *********************************/
    public Person() {};

    public Person(String fullName, int age, String homeTown) {
        this.fullName = fullName;
        this.age = age;
        this.homeTown = homeTown;
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

    /*********************************
     *          showInfor            *
     *********************************/
    public void showInfor() {
        System.out.println("Full name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Hometown: " + homeTown);
    }
}
