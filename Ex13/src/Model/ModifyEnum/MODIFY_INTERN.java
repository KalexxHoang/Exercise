package Model.ModifyEnum;

public enum MODIFY_INTERN {
    ID,
    FULLNAME,
    BIRTHDAY,
    PHONE,
    EMAIL,
    TYPE_EMPLOYEE,
    MAJORS,
    SEMESTER,
    UNIVERSITY,
    EXIT;

    public static MODIFY_INTERN getEnumModifyIntern(int ordinal) {
        for (MODIFY_INTERN modify : MODIFY_INTERN.values()) {
            if (modify.ordinal() == (ordinal - 1))
                return modify;
        }
        throw new RuntimeException();
    }
}
