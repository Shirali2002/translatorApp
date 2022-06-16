package com.company.dao.inter;

import com.company.entity.Aze;
import com.company.entity.Eng;

import java.util.ArrayList;

public interface EngDaoInter {
    public ArrayList<Eng> getAllEngWords();
    public Eng getEngWordById(int id);
    public int getIdByWord(String word);
    public boolean removeWordByEngId(int id);
    public boolean updateWord(Eng engWord);
    public boolean addWord(Eng engWord);
}
