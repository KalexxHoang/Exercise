package Model.ModifyEnum;

public enum MODIFY_FRESHER {
    ID,
    FULLNAME,
    BIRTHDAY,
    PHONE,
    EMAIL,
    TYPE_EMPLOYEE,
    GRAD_DATE,
    GRAD_RANK,
    EDUCATION,
    EXIT;

    public static MODIFY_FRESHER getEnumModifyFresher(int ordinal) {
        for (MODIFY_FRESHER modify : MODIFY_FRESHER.values()) {
            if (modify.ordinal() == (ordinal - 1))
                return modify;
        }
        throw new RuntimeException();
    }
}
