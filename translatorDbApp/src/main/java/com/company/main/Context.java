package com.company.main;

import com.company.dao.impl.AzeDaoImpl;
import com.company.dao.impl.AzeEngDaoImpl;
import com.company.dao.impl.EngDaoImpl;
import com.company.dao.impl.WordDaoImpl;
import com.company.dao.inter.AzeDaoInter;
import com.company.dao.inter.AzeEngDaoInter;
import com.company.dao.inter.EngDaoInter;
import com.company.dao.inter.WordDaoInter;

public class Context {
    public static WordDaoInter instanceWordDao(){
        return new WordDaoImpl();
    }
    public static AzeDaoInter instanceAzeDao(){
        return new AzeDaoImpl();
    }
    public static EngDaoInter instanceEngDao(){
        return new EngDaoImpl();
    }
    public static AzeEngDaoInter instanceAzeEngDao(){
        return new AzeEngDaoImpl();
    }
}
