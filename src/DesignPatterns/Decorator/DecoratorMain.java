package DesignPatterns.Decorator;

/**
 * Created by Dale on 18/07/16.
 */
public class DecoratorMain {

    public static void main(String[] args) {

        Enrollable enrollable = new Student("Dale","19","29/10/1995");

        ShortCourseEnrollment shortCourseEnrollment = new ShortCourseEnrollment(enrollable);
        shortCourseEnrollment.enroll();

    }
}
