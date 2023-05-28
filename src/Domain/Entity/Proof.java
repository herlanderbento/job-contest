package Domain.Entity;

import java.util.Date;

public class Proof {
    private int id;
    private String name;
    private Date date;
    private int duration;

    public Proof(int id, String name, Date date, int duration) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
