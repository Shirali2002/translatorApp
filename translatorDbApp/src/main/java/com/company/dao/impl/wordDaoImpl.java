/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.abstractDao;
import com.company.dao.inter.wordDaoInter;
import com.company.entity.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shireli
 */
public class wordDaoImpl extends abstractDao implements wordDaoInter {

    public Word getWord(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        String aze = rs.getString("aze");
        String eng = rs.getString("eng");

        return new Word(id, aze, eng);

    }

    @Override
    public List<Word> getAllWords() {
        ArrayList<Word> result = new ArrayList<>();
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT w.id , w.aze , w.eng FROM `words` w");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                result.add(getWord(rs));
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public Word getWordById(int id) {
        Word result = null;
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT w.id , w.aze , w.eng FROM `words` w WHERE w.id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                result = getWord(rs);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean removeWord(int id) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("DELETE FROM `words` w WHERE w.id=?");
            stmt.setInt(1, id);

            return stmt.execute();

        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateWord(Word word) {
        return false;
    }

    @Override
    public boolean addWord(Word word) {
        return false;
    }
}
