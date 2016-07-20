package DesignPatterns.Decorator;

/**
 * Created by Dale on 18/07/16.
 */
public class ShortCourseEnrollment extends EnrolmentDecorator {
    public ShortCourseEnrollment(Enrollable enrollable) {
        super(enrollable);
    }

    @Override
    public void enroll() {
        super.enroll();
        enrollForShortCourse();
    }

    private void enrollForShortCourse(){
        System.out.println(enrollable.getEnrollmentID() + " is enrolled for a short course");
    }
}
