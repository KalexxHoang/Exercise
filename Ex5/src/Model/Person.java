package Model;

import View.ROOM;

public class Person {
    /**********************************
     *            Attribute           *
     **********************************/
    private String fullName;
    private int age;
    // CCCD is the only one
    private int CCCD;
    private int rentalDays;
    private String typeRoom;

    /*********************************
     *            Constructor        *
     *********************************/
    public Person(int CCCD) {
        this.CCCD = CCCD;
    }

    public Person(String fullName, int age, int CCCD, int rentalDays, String typeRoom) {
        this.fullName = fullName;
        this.age = age;
        this.CCCD = CCCD;
        this.rentalDays = rentalDays;
        this.typeRoom = typeRoom;
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

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    /*********************************
     *          computeRent          *
     *********************************/
    public double computeRent() {
        return rentalDays*(ROOM.getEnumROOM(typeRoom).getCost());
    }

    /*********************************
     *          Show Infor           *
     *********************************/
    public void showInfor() {
        System.out.println("\tFull name: " + fullName);
        System.out.println("\tAge: " + age);
        System.out.println("\tCCCD: " + CCCD);
        System.out.println("\tRental days: " + rentalDays);
        System.out.println("\tType of room: " + typeRoom);
        System.out.println("------------------------------------------");
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
