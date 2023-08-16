package Model.ModifyEnum;

public enum MODIFY_EXPERIENCE {
    ID,
    FULLNAME,
    BIRTHDAY,
    PHONE,
    EMAIL,
    TYPE_EMPLOYEE,
    EXPERIENCE_YEAR,
    PRO_SKILL,
    EXIT;

    public static MODIFY_EXPERIENCE getEnumModifyExperience(int ordinal) {
        for (MODIFY_EXPERIENCE modify : MODIFY_EXPERIENCE.values()) {
            if (modify.ordinal() == (ordinal - 1))
                return modify;
        }
        throw new RuntimeException();
    }
}
