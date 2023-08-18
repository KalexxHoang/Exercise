package Model.Student;

import java.util.*;

public class Student {
    /**********************************
     *            Attribute           *
     **********************************/
    private String studentID;
    private String fullName;
    private String birthDay;
    private int entryYear;
    private double entryPoint;
    private Map<Integer,Double> pointMap;

    /*********************************
     *            Constructor        *
     *********************************/
    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String fullName, String birthDay, int entryYear, double entryPoint) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.entryYear = entryYear;
        this.entryPoint = entryPoint;
        this.pointMap = new HashMap<>();
    }

    /*********************************
     *        Getter vs Setter       *
     *********************************/
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(int entryYear) {
        this.entryYear = entryYear;
    }

    public double getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(double entryPoint) {
        this.entryPoint = entryPoint;
    }

    public Map<Integer, Double> getPointMap() {
        return pointMap;
    }

    public void setPointMap(Map<Integer, Double> pointMap) {
        this.pointMap = pointMap;
    }

    /*********************************
     *          equals               *
     *********************************/
    @Override
    public boolean equals(Object obj) {
        return this.studentID.equals(((Student) obj).getStudentID());
    }

    /*********************************
     *          hashCode             *
     *********************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + studentID.hashCode();

        return result;
    }

    /*********************************
     *          showInfor            *
     *********************************/
    public void showInfor() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Full name: " + fullName);
        System.out.println("Birthday: " + birthDay);
        System.out.println("Entry year: " + entryYear);
        System.out.println("Entry point: " + entryPoint);
    }

    public void showPoint() {
        for (Map.Entry<Integer,Double> point : pointMap.entrySet()) {
            System.out.println("Semester " + point.getKey() + ": " + point.getValue());
        }
    }

    /*********************************
     *     getLastSemesterPoint      *
     *********************************/
    public int getLastSemester() {
        List<Integer> semesterList = new ArrayList<>();
        for (Map.Entry<Integer,Double> point : pointMap.entrySet()) {
            semesterList.add(point.getKey());
        }

        Collections.sort(semesterList);
        return semesterList.get(semesterList.size() - 1);
    }

    public Double getLastSemesterPoint(int lastSemester) {
        return this.pointMap.get(lastSemester);
    }

    /*********************************
     *   searchHighestSemesterPoint  *
     *********************************/
    public double searchHighestSemesterPoint() {
        List<Double> pointList = new ArrayList<>();
        for (Map.Entry<Integer,Double> point : pointMap.entrySet()) {
            pointList.add(point.getValue());
        }
        Collections.sort(pointList);
        return pointList.get(pointList.size() - 1);
    }
}
