package Model;

public class Person {
    /**********************************
     *            Attribute           *
     **********************************/
    private String fullName;
    private int age;
    private String job;
    // CCCD is the only one
    private int CCCD;

    /*********************************
     *            Constructor        *
     *********************************/
    public Person(String fullName, int age, String job, int CCCD) {
        this.fullName = fullName;
        this.age = age;
        this.job = job;
        this.CCCD = CCCD;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showInfor() {
        System.out.println("\tFull name: " + fullName);
        System.out.println("\tAge: " + age);
        System.out.println("\tJob: " + job);
        System.out.println("\tCCCD: " + CCCD);
        System.out.println();
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.CCCD == (((Person) obj).getCCCD());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + CCCD;

        return result;
    }
}
