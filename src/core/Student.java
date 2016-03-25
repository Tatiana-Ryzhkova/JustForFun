package core;

import java.util.Random;

public class Student {
    private String name;
    private double remainingFunds;
    private int knowledgePoints;
    private final static double DEFAULT_AMOUNT = 100.00;

    public Student(String name, double planningToSpendAmount) {
        this.name = name;
        this.knowledgePoints = 0;
        this.remainingFunds = planningToSpendAmount;
    }

    public Student(String name) {
        this.name = name;
        this.knowledgePoints = 0;
        this.remainingFunds = DEFAULT_AMOUNT;
    }

    public String getName() {
        return name;
    }

    public int getKnowledgePoints() {
        return knowledgePoints;
    }

    public void resetKnowledgePoints() {
        knowledgePoints = 0;
    }

    public void learn() {
        Random ran = new Random();
        int randomPoints = ran.nextInt(6);
        knowledgePoints += randomPoints;
    }

    public double pay(double amountToPay) throws InsufficientFundsException {
        if(amountToPay > remainingFunds) {
            throw new InsufficientFundsException("not enough money left");
        }
        remainingFunds -= amountToPay;
        return amountToPay;
    }

    public String answerQuestion(String question) {
        if(knowledgePoints > 0) {
            return "good answer to a question: " + question;
        } else {
            return ""; //empty question
        }
    }
}
