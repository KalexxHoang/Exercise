package View;

public enum MENU {
    ADD_DOC,
    DELETE_DOC,
    SHOW_DOC,
    SEARCH_DOC,
    EXIT;

    public static MENU getEnumMenu(int ordinal){
        for (MENU menu : MENU.values()){
            if (menu.ordinal() == (ordinal - 1))
                return menu;
        }
        throw new RuntimeException();
    }
}
