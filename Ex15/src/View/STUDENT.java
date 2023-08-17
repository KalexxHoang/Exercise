package View;

public enum STUDENT {
    STANDARD,
    SERVICE;

    public static STUDENT getEnumStudent(int ordinal){
        for (STUDENT student : STUDENT.values()){
            if (student.ordinal() == (ordinal - 1))
                return student;
        }
        throw new RuntimeException();
    }
}
