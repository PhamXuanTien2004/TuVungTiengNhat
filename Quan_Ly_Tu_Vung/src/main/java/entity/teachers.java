package entity;

public class teachers extends admin {
    private int levelNow;
    private int expInYear;
    private String country;

    public teachers(String fullName, Gender gender, int age, String email, String password, int levelNow, int expInYear, String country) {
        super(fullName, gender, age, email, password);
        this.levelNow = levelNow;
        this.expInYear = expInYear;
        this.country = country;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
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
                ", expInYear=" + expInYear +
                ", country='" + country + '\'' ;
    }
}
