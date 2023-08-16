package View;

public enum VEHICLE {
    CAR,
    MOTOR,
    TRUCK;

    public static VEHICLE getEnumVehicle(int ordinal){
        for (VEHICLE vehicle : VEHICLE.values()){
            if (vehicle.ordinal() == (ordinal - 1))
                return vehicle;
        }
        throw new RuntimeException();
    }
}
