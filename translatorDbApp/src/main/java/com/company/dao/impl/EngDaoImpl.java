package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.EngDaoInter;
import com.company.entity.Eng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EngDaoImpl extends AbstractDao implements EngDaoInter {
    public Eng getEngWord(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String word = rs.getString("word");
        return new Eng(id, word);
    }

    @Override
    public ArrayList<Eng> getAllEngWords() {
        ArrayList<Eng> result = new ArrayList<>();
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * From eng");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result.add(getEngWord(rs));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public Eng getEngWordById(int id) {
        Eng result = null;
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM eng WHERE eng.id = ?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = getEngWord(rs);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public int getIdByWord(String word) {
        int result = -1;
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("SELECT id FROM eng WHERE eng.word = ?");
            stmt.setString(1, word);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = rs.getInt("id");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
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
    public boolean updateWord(Eng engWord) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE `eng` e SET e.word = ? WHERE e.id = ?");
            stmt.setString(1, engWord.getWord());
            stmt.setInt(2, engWord.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addWord(Eng engWord) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO `eng` (word) VALUES(?)");
            stmt.setString(1, engWord.getWord());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
