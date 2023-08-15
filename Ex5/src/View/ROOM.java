package View;

public enum ROOM {
    ROOM_A (500,"A"),
    ROOM_B (300,"B"),
    ROOM_C (100,"C");

    /**********************************
     *    Modify value of ENUM        *
     **********************************/
    private int cost;
    private String value;

    ROOM(int cost, String value) {
        this.cost = cost;
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public static ROOM getEnumROOM(String room){
        for (ROOM item : ROOM.values()){
            if (item.value.equalsIgnoreCase(room))
                return item;
        }
        throw new RuntimeException();
    }
}
