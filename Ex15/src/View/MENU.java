package View;

public enum MENU {
    ADD,
    CHECK_STANDARD,
    COUNT_STANDARD,
    SEARCH_POINT,
    SHOW_HIGHEST_POINT,
    SEARCH_SERVICE_STUDENT,
    SEARCH_POINT_OVER8,
    SEARCH_HIGHEST_SEMESTER_POINT,
    EXIT;

    public static MENU getEnumMenu(int ordinal){
        for (MENU menu : MENU.values()){
            if (menu.ordinal() == (ordinal - 1))
                return menu;
        }
        throw new RuntimeException();
    }
}
