package entity;

public class Vocabulary {
    private int id;
    private String word;
    private String speak;
    private int level;

    public Vocabulary(int id, String word, String speak, int level) {
        this.id = id;
        this.word = word;
        this.speak = speak;
        this.level = level;
    }

    public Vocabulary(String word, String speak, int level) {
        this.word = word;
        this.speak = speak;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(String speak) {
        this.speak = speak;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", speak='" + speak + '\'' +
                ", level=" + level +
                '}';
    }
}
