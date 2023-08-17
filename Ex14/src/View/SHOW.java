package View;

public enum SHOW {
    NAME,
    PHONE;

    public static SHOW getEnumMenu(int ordinal){
        for (SHOW show : SHOW.values()){
            if (show.ordinal() == (ordinal - 1))
                return show;
        }
        throw new RuntimeException();
    }
}
