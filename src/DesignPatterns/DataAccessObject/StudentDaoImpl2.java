package DesignPatterns.DataAccessObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dale on 17/07/16.
 */
public class StudentDaoImpl2 implements StudentDao{

    private LinkedList<Student> students = new LinkedList<>();


    @Override
    public List<Student> getAllStudents() {
        System.out.println("Getting students from linked list database");
        return (List<Student>) students.clone();
    }

    @Override
    public boolean addStudent(Student student) {
        System.out.println("Adding student to linked list database");
        return students.add(student);
    }

    @Override
    public boolean removeStudent(Student student) {
        System.out.println("Removing student from linked list database");
        return students.remove(student);
    }
}
