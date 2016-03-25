package core;

import core.instruct.Alex;
import core.instruct.Instructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Begin test run");
        Instructor teacher = Alex.getInstance(30.00, 10, "good");

        Student student1 = new Student("Tom");
        Student student2 = new Student("Max", 90);
        Student student3 = new Student("Tamara");
        Student student4 = new Student("Alice", 200);
        Student lateStudent1 = new Student("Sam");
        Student lateStudent2 = new Student("Nick");
        Student lateStudent3 = new Student("Mike");
        //todo: add more students

        List<Student> groupOfStudents = new ArrayList<>();
        groupOfStudents.add(student1);
        groupOfStudents.add(student2);
        groupOfStudents.add(student3);
        groupOfStudents.add(student4);

        List<Student> lateStudents = new ArrayList<>();
        lateStudents.add(lateStudent1);
        lateStudents.add(lateStudent2);
        lateStudents.add(lateStudent3);

        LessonMeeting firstMeeting = new LessonMeeting(teacher, groupOfStudents);
        List<Student> attendees = firstMeeting.getAttendees();
        teacher.greetStudents(attendees);

        firstMeeting.addLateStudents(lateStudents);

        while(firstMeeting.isInSession()) {
            teacher.teach();
            for(Student student : attendees) {
                student.learn();
            }
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(attendees.size());
            teacher.askQuestion(attendees.get(randomInt), "Question");
        }
        int testSuccess = teacher.testAllStudents(attendees);
        if(testSuccess > (attendees.size()*2) ) {
            System.out.println("Good work!");
            System.out.println(teacher.assignHomework());
        } else {
            teacher.teach(10);
        }
        teacher.collectPayments(attendees);
        teacher.oneLessLessonToTeach();
        System.out.println("end of lesson meeting");
        System.out.println("End of test run");
    }
}
