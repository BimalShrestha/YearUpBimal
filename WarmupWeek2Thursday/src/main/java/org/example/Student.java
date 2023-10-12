package org.example;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private int yearInCollege;
    private boolean isInternational;
    private String address;

    public Student(String firstName, String lastName, String studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
    }

    public Student(String firstName, String lastName, String studentId, int yearInCollege, boolean isInternational, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.yearInCollege = yearInCollege;
        this.isInternational = isInternational;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId(){
        return studentId;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public int getYearInCollege() {
        return yearInCollege;
    }

    public void setYearInCollege(int yearInCollege) {
        this.yearInCollege = yearInCollege;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String greeting(String firstName, String lastName){
        return "Hi my name is "+ firstName+" "+lastName;
    }
}
