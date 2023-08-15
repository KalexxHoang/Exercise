package View;

public enum MODIFY_OPTION {
    FULL_NAME,
    APARTMENT_NUMBER,
    POWERMETER_ID,
    EXIT;

    public static MODIFY_OPTION getEnumOption(int ordinal){
        for (MODIFY_OPTION MODIFY_OPTION : MODIFY_OPTION.values()){
            if (MODIFY_OPTION.ordinal() == (ordinal - 1))
                return MODIFY_OPTION;
        }
        throw new RuntimeException();
    }
}
