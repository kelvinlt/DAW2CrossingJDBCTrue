package obj;

import java.time.LocalDate;

public class Contact {
    private User user;
    private Character character;
    private LocalDate date;
    private int level;
    private int points;

    public Contact() {
    }

    public Contact(User user, Character character, LocalDate date, int level, int points) {
        this.user = user;
        this.character = character;
        this.date = date;
        this.level = level;
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Contact{" + "user=" + user + ", character=" + character + ", date=" + date + ", level=" + level + ", points=" + points + '}';
    }
}
