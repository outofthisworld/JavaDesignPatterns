package DesignPatterns.Decorator;

import java.util.Objects;

/**
 * Created by Dale on 18/07/16.
 */
public class Student implements Enrollable {

    private String name;
    private String age;
    private String dob;
    private boolean isEnrolled = false;

    public Student(String name,String age,String dob){
        this.name = name;
        this.age = age;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isEnrolled() {
        return isEnrolled;
    }

    @Override
    public void enroll() {
        this.isEnrolled = true;
    }

    @Override
    public int getEnrollmentID() {
        return Objects.hash(name,age,dob);
    }
}
