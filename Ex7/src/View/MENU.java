package View;

public enum MENU {
    ADD_TEACHER,
    SHOW_TEACHER,
    DELETE_TEACHER,
    COMPUTE_SALARY,
    EXIT;

    public static MENU getEnumMenu(int ordinal){
        for (MENU menu : MENU.values()){
            if (menu.ordinal() == (ordinal - 1))
                return menu;
        }
        throw new RuntimeException();
    }
}
