/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.WordDaoInter;
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
public class WordDaoImpl extends AbstractDao implements WordDaoInter {

    public Word getWord(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        int azeId = rs.getInt("aze_id");
        int engId = rs.getInt("eng_id");
        String aze = rs.getString("aze");
        String eng = rs.getString("eng");

        return new Word(id, azeId, engId, aze, eng);

    }

    @Override
    public ArrayList<Word> getAllWords() {
        ArrayList<Word> result = new ArrayList<>();
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT ae.*,  " +
                    " a.word AS aze,  " +
                    " e.word AS eng  " +
                    "FROM `aze_eng` ae " +
                    " LEFT JOIN `aze` a ON a.id = ae.aze_id " +
                    " LEFT JOIN `eng` e ON e.id = ae.eng_id");
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
    public Word getWordByAzeEngId(int id) {
        Word result = null;
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT ae.*,  " +
                    " a.word AS aze,  " +
                    " e.word AS eng  " +
                    "FROM `aze_eng` ae " +
                    " LEFT JOIN `aze` a ON a.id = ae.aze_id " +
                    " LEFT JOIN `eng` e ON e.id = ae.eng_id " +
                    " WHERE ae.id = ?");
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
    public ArrayList<Integer> getAEIdByAzeId(int id){
        ArrayList<Integer> result = new ArrayList<>();
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT id FROM aze_eng where aze_id = ?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                result.add(rs.getInt("id"));
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public ArrayList<Integer> getAEIdByEngId(int id){
        ArrayList<Integer> result = new ArrayList<>();
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT id FROM aze_eng where eng_id = ?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                result.add(rs.getInt("id"));
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public ArrayList<Word> getWordByAzeId(int id) {
        ArrayList<Word> result = new ArrayList<>();
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT ae.*,  " +
                    " a.word AS aze,  " +
                    " e.word AS eng  " +
                    "FROM `aze_eng` ae " +
                    " LEFT JOIN `aze` a ON a.id = ae.aze_id " +
                    " LEFT JOIN `eng` e ON e.id = ae.eng_id " +
                    " WHERE a.id = ?");
            stmt.setInt(1, id);
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
    public ArrayList<Word> getWordByEngId(int id) {
        ArrayList<Word> result = new ArrayList<>();
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT ae.*,  " +
                    " a.word AS aze,  " +
                    " e.word AS eng  " +
                    "FROM `aze_eng` ae " +
                    " LEFT JOIN `aze` a ON a.id = ae.aze_id " +
                    " LEFT JOIN `eng` e ON e.id = ae.eng_id " +
                    " WHERE e.id = ?");
            stmt.setInt(1, id);
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
}
