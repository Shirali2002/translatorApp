package com.company.dao.inter;

import com.company.entity.Aze;
import com.company.entity.Word;

import java.util.ArrayList;

public interface AzeDaoInter {
    public ArrayList<Aze> getAllAzeWords();
    public Aze getAzeWordById(int id);
    public int getIdByWord(String word);
    public boolean removeWordByAzeId(int id);
    public boolean updateWord(Aze azeWord);
    public boolean addWord(Aze azeWord);
}
