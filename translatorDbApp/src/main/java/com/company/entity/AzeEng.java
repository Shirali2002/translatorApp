package com.company.entity;

public class AzeEng {
    private int id;
    private int azeId;
    private int engId;

    public AzeEng() {
    }

    public AzeEng(int id, int azeId, int engId) {
        this.id = id;
        this.azeId = azeId;
        this.engId = engId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAzeId() {
        return azeId;
    }

    public void setAzeId(int azeId) {
        this.azeId = azeId;
    }

    public int getEngId() {
        return engId;
    }

    public void setEngId(int engId) {
        this.engId = engId;
    }

    @Override
    public String toString() {
        return "AzeEng{" +
                "id=" + id +
                ", azeId=" + azeId +
                ", engId=" + engId +
                '}';
    }
}
