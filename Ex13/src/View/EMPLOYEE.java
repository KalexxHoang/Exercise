package View;

public enum EMPLOYEE {
    EXPERIENCE (0,"Experience"),
    FRESHER (1,"Fresher"),
    INTERN (2,"Intern");

    private int value1;
    private String value2;

    EMPLOYEE(int value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public static EMPLOYEE getEnumEmployee(int ordinal) {
        for (EMPLOYEE employee : EMPLOYEE.values()) {
            if (employee.value1 == (ordinal - 1))
                return employee;
        }
        throw new RuntimeException();
    }

    public static String getString(EMPLOYEE employee) {
        return employee.value2;
    }
}
