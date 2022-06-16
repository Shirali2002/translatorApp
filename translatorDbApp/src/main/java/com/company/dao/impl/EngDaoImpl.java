package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.EngDaoInter;
import com.company.entity.Eng;

import java.util.ArrayList;

public class EngDaoImpl extends AbstractDao implements EngDaoInter {
    @Override
    public ArrayList<Eng> getAllEngWords() {
        return null;
    }

    @Override
    public Eng getEngWordById(int id) {
        return null;
    }

    @Override
    public Eng getEngWordByWord(String word) {
        return null;
    }

    @Override
    public boolean removeWordByEngId(int id) {
        return false;
    }

    @Override
    public boolean removeWordByEngWord(String word) {
        return false;
    }

    @Override
    public boolean updateWord(Eng engWord) {
        return false;
    }

    @Override
    public boolean addWord(Eng engWord) {
        return false;
    }
}
