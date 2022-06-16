package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.AzeEngDaoInter;
import com.company.entity.AzeEng;

import java.util.ArrayList;

public class AzeEngDaoImpl extends AbstractDao implements AzeEngDaoInter {
    @Override
    public ArrayList<AzeEng> getAllAzeEng() {
        return null;
    }

    @Override
    public AzeEng getAzeEngById(int id) {
        return null;
    }

    @Override
    public boolean removeAzeEng(int id) {
        return false;
    }

    @Override
    public boolean updateAzeEng(AzeEng azeEng) {
        return false;
    }

    @Override
    public boolean addAzeEng(AzeEng azeEng) {
        return false;
    }
}
