package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.AzeDaoInter;
import com.company.entity.Aze;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AzeDaoImpl extends AbstractDao implements AzeDaoInter {
    public Aze getAzeWord(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String word = rs.getString("word");
        return new Aze(id, word);
    }

    @Override
    public ArrayList<Aze> getAllAzeWords() {
        ArrayList<Aze> result = new ArrayList<>();
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * From aze");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result.add(getAzeWord(rs));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public Aze getAzeWordById(int id) {
        Aze result = null;
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM aze WHERE aze.id = ?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                result = getAzeWord(rs);
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
            PreparedStatement stmt = c.prepareStatement("SELECT id FROM aze WHERE aze.word = ?");
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
    public boolean removeWordByAzeId(int id) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("DELETE ae, a FROM `aze_eng` ae INNER JOIN `aze` a WHERE ae.aze_id = ? AND a.id = ?");
            stmt.setInt(1, id);
            stmt.setInt(2, id);
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean updateWord(Aze azeWord) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE `aze` a SET a.word = ? WHERE a.id = ?");
            stmt.setString(1, azeWord.getWord());
            stmt.setInt(2, azeWord.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addWord(Aze azeWord) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO `aze` (word) VALUES(?)");
            stmt.setString(1, azeWord.getWord());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
