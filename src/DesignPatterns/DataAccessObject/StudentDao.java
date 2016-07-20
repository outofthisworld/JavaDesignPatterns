package DesignPatterns.DataAccessObject;

import java.util.List;

/**
 * Created by Dale on 17/07/16.
 */
public interface StudentDao {

    List<Student> getAllStudents();
    boolean addStudent(Student student);
    boolean removeStudent(Student student);

}
