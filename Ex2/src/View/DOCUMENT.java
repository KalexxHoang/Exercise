package View;

public enum DOCUMENT {
    BOOK,
    MAGAZINE,
    NEWSPAPER;

    public static DOCUMENT getEnumDocument(int ordinal){
        for (DOCUMENT document : View.DOCUMENT.values()){
            if (document.ordinal() == (ordinal - 1))
                return document;
        }
        throw new RuntimeException();
    }
}
