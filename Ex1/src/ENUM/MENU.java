package ENUM;

public enum MENU {
    ADD_MEMBER,
    SEARCH_MEMBER,
    SHOW_MEMBER,
    EXIT;

    public static MENU getEnumMenu(int ordinal){
        for (MENU menu : MENU.values()){
            if (menu.ordinal() == (ordinal - 1))
                return menu;
        }
        throw new RuntimeException();
    }
}
