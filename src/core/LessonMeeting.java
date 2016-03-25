package core;

import core.instruct.Instructor;

import java.util.List;

public class LessonMeeting {
    private Instructor instructor;
    private List<Student> attendees;
    private int timeRemaining;


    public LessonMeeting(Instructor instructor, List<Student> students) {
        this.instructor = instructor;
        this.attendees = students;
        timeRemaining = 3;
        for(Student student : attendees) {
            student.resetKnowledgePoints(); //if there a more then one lesson meetings
        }
        //todo: record the teacher's name and all attendees to a file
    }

    public List<Student> getAttendees() {
        return attendees;
    }

    public void addLateStudents(List<Student> lateStudents) {
        for(Student student : lateStudents) {
            attendees.add(student);
        }
    }

    public boolean isInSession() {
        timeRemaining -= 1;
        return timeRemaining > 0;
    }

}
