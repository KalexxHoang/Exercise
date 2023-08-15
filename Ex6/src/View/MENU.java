package View;

public enum MENU {
    ADD_STUDENT,
    SHOW_STUDENT,
    SHOW_AGE,
    COUNT_AGE_HOMETOWN,
    EXIT;

    public static MENU getEnumMenu(int ordinal){
        for (MENU menu : MENU.values()){
            if (menu.ordinal() == (ordinal - 1))
                return menu;
        }
        throw new RuntimeException();
    }
}
