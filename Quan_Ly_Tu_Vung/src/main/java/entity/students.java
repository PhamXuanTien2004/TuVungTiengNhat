package entity;

public class students extends admin{
    private int levelNow;
    private int finished;

    public students(String fullName, Gender gender, int age, String email, String password, int levelNow) {
        super(fullName, gender, age, email, password);
        this.levelNow = levelNow;
    }

    public int getLevelNow() {
        return levelNow;
    }

    public void setLevelNow(int levelNow) {
        this.levelNow = levelNow;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return  "levelNow=" + levelNow +
                ", finished=" + finished ;
    }
}
