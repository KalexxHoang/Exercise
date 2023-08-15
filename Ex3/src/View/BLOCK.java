package View;

public enum BLOCK {
    BLOCK_A ("A"),
    BLOCK_B ("B"),
    BLOCK_C ("C");

    /**********************************
     *    Modify value of ENUM        *
     **********************************/
    private String value;
    BLOCK(String value) {
        this.value = value;
    }

    public static BLOCK getEnumBLOCK(String block){
        for (BLOCK b : BLOCK.values()){
            if (b.value.equalsIgnoreCase(block))
                return b;
        }
        throw new RuntimeException();
    }
}
