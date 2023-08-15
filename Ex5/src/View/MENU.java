package View;

public enum MENU {
    ADD_PERSON,
    DELETE_PERSON,
    COMPUTE_RENT,
    SHOW_INFOR,
    EXIT;

    public static MENU getEnumMenu(int ordinal){
        for (MENU menu : MENU.values()){
            if (menu.ordinal() == (ordinal - 1))
                return menu;
        }
        throw new RuntimeException();
    }
}
