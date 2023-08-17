package Model.School;

import Model.Student.Student;

import java.util.*;

public class School {
    /**********************************
     *            Attribute           *
     **********************************/
    private String schoolName;
    private Set<Student> studentSet;

    /*********************************
     *            Constructor        *
     *********************************/
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.studentSet = new LinkedHashSet<>();
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    /*********************************
     *          addStudent           *
     *********************************/
    public void addStudent(Student student) {
        Optional<Student> check = this.studentSet.stream()
                .filter(item -> item.equals(student))
                .findFirst();

        if (check.isPresent()) {
            System.out.println("This student ID already exist! Do you want to replace?");
            System.out.println("\t1: Yes");
            System.out.println("\t2: No");

            int option = new Scanner(System.in).nextInt();

            switch (option) {
                case 1:
                    this.studentSet.remove(check.get());
                    this.studentSet.add(student);

                case 2:
                    return;
            }
        }
        this.studentSet.add(student);
    }

    /*********************************
     *          sortStudent          *
     *********************************/
    public List<Student> sortStudent() {
        List<Student> studentList = new ArrayList<>(this.studentSet);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getEntryPoint() > o2.getEntryPoint())
                    return -1;
                else if (o1.getEntryPoint() < o2.getEntryPoint())
                    return 1;
                else
                    return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        return studentList;
    }
}
