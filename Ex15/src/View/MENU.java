package View;

public enum MENU {
    ADD,
    CHECK_STANDARD,
    COUNT_STANDARD,
    SEARCH_POINT,
    EXIT;

    public static MENU getEnumMenu(int ordinal){
        for (MENU menu : MENU.values()){
            if (menu.ordinal() == (ordinal - 1))
                return menu;
        }
        throw new RuntimeException();
    }
}
