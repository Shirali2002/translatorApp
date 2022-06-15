/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.entity;

/**
 *
 * @author Shireli
 */
public class Word {
    private int id;
    private int aze_id;
    private int eng_id;
    private String aze;
    private String eng;

    public Word() {
    }

    public Word(int id, int aze_id, int eng_id, String aze, String eng) {
        this.id = id;
        this.aze_id = aze_id;
        this.eng_id = eng_id;
        this.aze = aze;
        this.eng = eng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAze() {
        return aze;
    }

    public void setAze(String aze) {
        this.aze = aze;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public int getAze_id() {
        return aze_id;
    }

    public void setAze_id(int aze_id) {
        this.aze_id = aze_id;
    }

    public int getEng_id() {
        return eng_id;
    }

    public void setEng_id(int eng_id) {
        this.eng_id = eng_id;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", aze_id=" + aze_id +
                ", eng_id=" + eng_id +
                ", aze='" + aze + '\'' +
                ", eng='" + eng + '\'' +
                '}';
    }
}
