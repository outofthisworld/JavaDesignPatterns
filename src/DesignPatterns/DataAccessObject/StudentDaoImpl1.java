package DesignPatterns.DataAccessObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dale on 17/07/16.
 */
public class StudentDaoImpl1 implements StudentDao {
    private final ArrayList<Student> studentArrayList = new ArrayList<>();


    @Override
    public List<Student> getAllStudents() {
        System.out.println("Getting students from array list database");
        return (List<Student>) studentArrayList.clone();
    }

    @Override
    public boolean addStudent(Student student) {
        System.out.println("Adding student to array list database");
        return studentArrayList.add(student);
    }

    @Override
    public boolean removeStudent(Student student) {
        System.out.println("Removing student from array list database");
        return studentArrayList.remove(student);
    }
}
