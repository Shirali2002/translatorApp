package com.company.main;

import com.company.dao.impl.WordDaoImpl;
import com.company.dao.inter.WordDaoInter;

public class Context {
    public static WordDaoInter instanceWordDao(){
        return new WordDaoImpl();
    }
}
