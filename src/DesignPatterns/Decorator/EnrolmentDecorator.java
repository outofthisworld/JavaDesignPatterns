package DesignPatterns.Decorator;

/**
 * Created by Dale on 18/07/16.
 */
public class EnrolmentDecorator {

    protected final Enrollable enrollable;

    public EnrolmentDecorator(Enrollable enrollable) {
        this.enrollable = enrollable;
    }

    public void enroll() {
        enrollable.enroll();
    }

}

