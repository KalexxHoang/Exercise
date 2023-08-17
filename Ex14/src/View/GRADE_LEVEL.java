package View;

public enum GRADE_LEVEL {
    GOOD (1,"Good"),
    NORMAL (2,"Normal");

    private int value;
    private String string;

    GRADE_LEVEL(int value, String string) {
        this.value = value;
        this.string = string;
    }

    public static String getString(GRADE_LEVEL gradeLevel) {
        return gradeLevel.string;
    }

    public static GRADE_LEVEL getEnumGradeLevel(int value){
        for (GRADE_LEVEL level : GRADE_LEVEL.values()){
            if (level.value == value)
                return level;
        }
        throw new RuntimeException();
    }
}
