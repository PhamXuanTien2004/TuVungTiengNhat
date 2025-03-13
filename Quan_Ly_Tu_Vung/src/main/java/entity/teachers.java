package entity;

public class teachers extends admin {
    private int levelNow;
    private String country;

    public teachers(String fullName, Gender gender, int age, String email, String password, int levelNow, String country) {
        super(fullName, gender, age, email, password);
        this.levelNow = levelNow;
        this.country = country;
    }

    public int getLevelNow() {
        return levelNow;
    }

    public void setLevelNow(int levelNow) {
        this.levelNow = levelNow;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return  "levelNow=" + levelNow +
                ", country='" + country ;
    }
}
