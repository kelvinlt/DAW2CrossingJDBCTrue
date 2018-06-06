package obj;


public class User {
    private String username;
    private String password;
    private int stucoins;
    private int level;
    private String place;
    private int points;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int stucoins, int level, String place, int points) {
        this.username = username;
        this.password = password;
        this.stucoins = stucoins;
        this.level = level;
        this.place = place;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStucoins() {
        return stucoins;
    }

    public void setStucoins(int stucoins) {
        this.stucoins = stucoins;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "{" + "username=" + username + ", password=" + password + ", stucoins=" + stucoins + ", level=" + level + ", place=" + place + ", points=" + points + '}';
    }
    
    
}
