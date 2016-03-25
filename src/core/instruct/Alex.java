package core.instruct;

import core.JokeGenerator;
import core.Student;
import java.util.List;

public class Alex extends Instructor {
    private String mood;
    private JokeGenerator humor = new JokeGenerator();
    private static Alex instance = null;

    private Alex(double lessonPrice, int numberOfPlannedLessons, String mood) {
        super(lessonPrice, numberOfPlannedLessons);
        this.mood = mood.toLowerCase();
    }

    public static Alex getInstance(double lessonPrice, int numberOfPlannedLessons, String mood) {
        if(instance == null) {
            instance = new Alex(lessonPrice, numberOfPlannedLessons, mood);
        }
        return instance;
    }

    @Override
    public void greetStudents(List<Student> students) {
        for(Student student : students) {
            System.out.println("Hi " + student.getName());
        }
    }

    @Override
    public String assignHomework() {
        return "New homework";
    }

    @Override
    public void askQuestion(Student student, String question) {
        if(student.answerQuestion(question).equals("")) {
            mood = "not happy";
            System.out.println("not happy mood");
        } else {
            mood = "good mood";
            System.out.println(humor.tellTheJoke("student answer"));
        }
    }

    @Override
    public int testAllStudents(List<Student> students) {
        int totalKnowledgePoints = 0;
        for(Student student : students) {
            totalKnowledgePoints += student.getKnowledgePoints();
        }
        if(totalKnowledgePoints > 0) {
            mood = "good";
            System.out.println(humor.tellTheJoke("another random topic"));
        }
        return totalKnowledgePoints;
    }

    public void teach() {
        super.teach();
        if(mood.equals("good")) {
            System.out.println(humor.tellTheJoke("random topic"));
        }
        super.teach();
    }

    @Override
    public void teach(int time) {
        System.out.println(time + " min review");
    }


}
