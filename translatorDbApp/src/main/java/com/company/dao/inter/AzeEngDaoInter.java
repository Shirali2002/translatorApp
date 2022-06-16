package com.company.dao.inter;

import com.company.entity.AzeEng;

import java.util.ArrayList;

public interface AzeEngDaoInter {
    public ArrayList<AzeEng> getAllAzeEng();
    public AzeEng getAzeEngById(int id);
    public boolean removeAzeEng(int id);
    public boolean updateAzeEng(AzeEng azeEng);
    public boolean addAzeEng(AzeEng azeEng);
}
