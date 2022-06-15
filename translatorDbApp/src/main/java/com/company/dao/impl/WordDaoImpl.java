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

    public ArrayList getWordByAzeId(int id) {
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

    public ArrayList getWordByEngId(int id) {
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

    @Override
    public boolean removeWordByAzeEngId(int id) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("DELETE FROM `aze_eng` ae WHERE ae.id = ?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeWordByAzeId(int id) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("DELETE ae, a FROM `aze_eng` ae INNER JOIN `aze` a WHERE ae.aze_id = ? AND a.id = ?");
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            return stmt.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeWordByEngId(int id) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("DELETE ae, e FROM `aze_eng` ae INNER JOIN `eng` e WHERE ae.eng_id = ? AND e.id = ?");
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            return stmt.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeWordByEngWord(String word) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("DELETE ae, e FROM `aze_eng` ae INNER JOIN `eng` e WHERE ae.eng_id = ( SELECT e.id WHERE e.word = ? ) AND e.word = ?");
            stmt.setString(1, word);
            stmt.setString(2, word);
            return stmt.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeWordByAzeWord(String word) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("DELETE ae, a FROM `aze_eng` ae INNER JOIN `aze` a WHERE ae.aze_id = ( SELECT a.id WHERE a.word = ? ) AND a.word = ?");
            stmt.setString(1, word);
            stmt.setString(2, word);
            return stmt.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateWord(Word word) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("UPDATE words set aze=?, eng=? WHERE id=?");
            stmt.setString(1, word.getAze());
            stmt.setString(2, word.getEng());
            stmt.setInt(3, word.getId());

            return stmt.execute();

        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addWord(Word word) {
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("INSERT words set aze=?, eng=?");
            stmt.setString(1, word.getAze());
            stmt.setString(2, word.getEng());

            return stmt.execute();

        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
