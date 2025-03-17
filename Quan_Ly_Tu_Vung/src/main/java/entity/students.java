package entity;

public class Students extends Users {
    private int levelNow;
    private int finishedWord;

    public Students(String fullName, Gender gender, int age, String email, String password, int levelNow, int finishedWord) {
        super(fullName, gender, age, email, password);
        this.levelNow = levelNow;
        this.finishedWord = finishedWord;
    }

    public Students(String fullName, Gender gender, int age, String email, int levelNow, int finishedWord) {
        super(fullName, gender, age, email);
        this.levelNow = levelNow;
        this.finishedWord = finishedWord;
    }

    public int getLevelNow() {
        return levelNow;
    }

    public void setLevelNow(int levelNow) {
        this.levelNow = levelNow;
    }

    public int getFinishedWord() {
        return finishedWord;
    }

    public void setFinishedWord(int finishedWord) {
        this.finishedWord = finishedWord;
    }

    @Override
    public String toString() {
        return  "levelNow=" + levelNow +
                ", finishedWord=" + finishedWord ;
    }
}
