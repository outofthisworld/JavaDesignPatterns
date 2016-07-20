package DesignPatterns.DataAccessObject;

import java.util.List;

/**
 * Created by Dale on 17/07/16.
 */
public class Controller {

    private final StudentDao studentDao;


    public Controller(StudentDao studentDao){
        this.studentDao = studentDao;
    }


    public List<Student> listStudents(){
        return studentDao.getAllStudents();
    }

    public boolean addStudent(Student student){
        return studentDao.addStudent(student);
    }

    public boolean removeStudent(Student student){
        return studentDao.removeStudent(student);
    }

    public boolean addStudent(String name, int age){
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return addStudent(student);
    }

    public boolean addStudent(String name, String age){
        return addStudent(name, Integer.parseInt(age));
    }
}
