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
    private String aze;
    private String eng;

    public Word() {
    }

    public Word(int id, String aze, String eng) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", aze='" + aze + '\'' +
                ", eng='" + eng + '\'' +
                '}';
    }
}
