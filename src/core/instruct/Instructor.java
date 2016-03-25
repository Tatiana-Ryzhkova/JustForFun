package core.instruct;

import core.InsufficientFundsException;
import core.Student;

import java.util.List;

public abstract class Instructor {
    protected int remainingLessonsToTeach;
    protected double totalEarnings;
    protected double lessonPrice;

    public Instructor(double lessonPrice, int numberOfPlannedLessons) {
        this.lessonPrice = lessonPrice;
        this.remainingLessonsToTeach = numberOfPlannedLessons;
        totalEarnings = 0;
    }

    public abstract void greetStudents(List<Student> students);

    public abstract String assignHomework();

    public abstract void askQuestion(Student student, String question);

    public abstract int testAllStudents(List<Student> students);

    public void teach() {
        System.out.println("teaching lesson");
    }

    public abstract void teach(int time);

    public void setLessonPrice(double newLessonPrice) {
        this.lessonPrice = newLessonPrice;
    }

    public void oneLessLessonToTeach() {
        remainingLessonsToTeach--;
    }

    public void collectPayments(List<Student> students) {
        for(Student s : students) {
            try {
                totalEarnings += s.pay(lessonPrice);
            } catch (InsufficientFundsException e) {
                //todo
            }
        }
    }
}
