package com.company.dao.inter;

import com.company.entity.Aze;
import com.company.entity.Eng;

import java.util.ArrayList;

public interface EngDaoInter {
    public ArrayList<Eng> getAllEngWords();
    public Eng getEngWordById(int id);
    public Eng getEngWordByWord(String word);
    public boolean removeWordByEngId(int id);
    public boolean removeWordByEngWord(String word);
    public boolean updateWord(Eng engWord);
    public boolean addWord(Eng engWord);
}
