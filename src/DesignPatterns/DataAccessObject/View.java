package DesignPatterns.DataAccessObject;

/**
 * Created by Dale on 17/07/16.
 */
public class View {

    private final Controller controller;
    private String studentNameTextBox = "";
    private String studentAgeTextBox = "";


    public View(Controller controller){
        this.controller = controller;
    }


    public void showAllStudents(){
        for(Student s:controller.listStudents()){
            System.out.println("Name: " + s.getName() + " Age:" + s.getAge());
        }
    }

    public void onAddButtonClick(){
        controller.addStudent(studentNameTextBox,studentAgeTextBox);
    }

    public void setStudentNameTextBox(String name){
        this.studentNameTextBox = name;
    }

    public void setStudentAgeTextBox(String age){
        this.studentAgeTextBox = age;
    }


    public static void main(String[] args) {

        View viewWithFirstStudentImpl = new View(new Controller(new StudentDaoImpl1()));
        View viewWithSecondStudentImpl = new View(new Controller(new StudentDaoImpl2()));


        //Simulate a user clicking a view and the clicked students details being set
        viewWithFirstStudentImpl.setStudentNameTextBox("John");
        viewWithFirstStudentImpl.setStudentAgeTextBox("20");

        //Simulate a click on a button to add the selected student
        viewWithFirstStudentImpl.onAddButtonClick();

        viewWithFirstStudentImpl.setStudentNameTextBox("Sally");
        viewWithFirstStudentImpl.setStudentAgeTextBox("16");

        viewWithFirstStudentImpl.onAddButtonClick();




        viewWithSecondStudentImpl.setStudentNameTextBox("Peter");
        viewWithSecondStudentImpl.setStudentAgeTextBox("22");

        viewWithSecondStudentImpl.onAddButtonClick();

        viewWithSecondStudentImpl.setStudentNameTextBox("Natasha");
        viewWithSecondStudentImpl.setStudentAgeTextBox("34");

        viewWithSecondStudentImpl.onAddButtonClick();


        System.out.println("First view students");
        viewWithFirstStudentImpl.showAllStudents();
        System.out.println();
        System.out.println("Second view students");
        viewWithSecondStudentImpl.showAllStudents();

    }
}
