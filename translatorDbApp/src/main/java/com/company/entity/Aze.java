package com.company.entity;

public class Aze {
    private int id;
    private String word;

    public Aze() {
    }

    public Aze(int id, String word) {
        this.id = id;
        this.word = word;
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

    @Override
    public String toString() {
        return "Aze{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
