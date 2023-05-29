package Domain.Entity;

import java.util.Date;

public class Exam {
    private int id;
    private Date date;
    private int duration;
    private String description;
    private int numberOfQuestions;

    public Exam(int id, String description, Date date, int duration, int numberOfQuestions) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.duration = duration;
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}
