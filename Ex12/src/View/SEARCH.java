package View;

public enum SEARCH {
    BRAND,
    COLOR;

    public static SEARCH getEnumSEARCH(int ordinal){
        for (SEARCH search : SEARCH.values()){
            if (search.ordinal() == (ordinal - 1))
                return search;
        }
        throw new RuntimeException();
    }
}
