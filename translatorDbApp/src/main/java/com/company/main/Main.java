/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.main;

import com.company.dao.inter.AzeEngDaoInter;
import com.company.dao.inter.WordDaoInter;
import com.company.entity.Word;

import java.util.ArrayList;

/**
 *
 * @author Shireli
 */
public class Main {
    public static void main(String[] args) {
//        WordDaoInter wordDao = Context.instanceWordDao();
//        ArrayList<Word> wordList = wordDao.
//
//        for (Word word: wordList) {
//            System.out.println(word);
//        }

        AzeEngDaoInter azeEngDao = Context.instanceAzeEngDao();
        while (true) {
            int n = azeEngDao.randomIdGenerator();
            System.out.println(n);
            System.out.println(azeEngDao.getAzeEngById(n));
        }

    }
    
}
