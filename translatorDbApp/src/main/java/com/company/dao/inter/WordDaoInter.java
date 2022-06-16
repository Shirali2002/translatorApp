/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import com.company.entity.Word;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shireli
 */
public interface WordDaoInter {
    public ArrayList<Word> getAllWords();
    public Word getWordByAzeEngId(int id);
    public ArrayList<Word> getWordByAzeId(int id);
    public ArrayList<Word> getWordByEngId(int id);
    public ArrayList<Integer> getAEIdByAzeId(int id);
    public ArrayList<Integer> getAEIdByEngId(int id);
}
