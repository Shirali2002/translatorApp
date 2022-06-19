package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.AzeEngDaoInter;
import com.company.entity.Aze;
import com.company.entity.AzeEng;
import com.company.entity.Word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AzeEngDaoImpl extends AbstractDao implements AzeEngDaoInter {
    public AzeEng getAzeEng(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        int azeId = rs.getInt("aze_id");
        int engId = rs.getInt("eng_id");
        return new AzeEng(id, azeId, engId);
    }
    @Override
    public ArrayList<AzeEng> getAllAzeEng() {
        ArrayList<AzeEng> result = new ArrayList<>();
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM aze_eng");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                result.add(getAzeEng(rs));
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public AzeEng getAzeEngById(int id) {
        AzeEng result = null;
        try (Connection c = connection()){
            PreparedStatement stmt = c.prepareStatement("SELECT * FROM aze_eng WHERE id=?");
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()){
                result = getAzeEng(rs);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean removeAzeEng(int id) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("DELETE ae FROM `aze_eng` ae WHERE ae.id = ?");
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateAzeEng(AzeEng azeEng) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("UPDATE `aze_eng` SET aze_id = ?, eng_id = ? WHERE id = ?");
            stmt.setInt(1, azeEng.getAzeId());
            stmt.setInt(2, azeEng.getId());
            stmt.setInt(3, azeEng.getId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addAzeEng(AzeEng azeEng) {
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("INSERT INTO `aze_eng` (aze_id, eng_id) VALUES(?, ?)");
            stmt.setInt(1, azeEng.getAzeId());
            stmt.setInt(2, azeEng.getEngId());
            return stmt.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public int randomIdGenerator() {
        int maxId = -1;
        int minId = -1;
        try (Connection c = connection()) {
            PreparedStatement stmt = c.prepareStatement("SELECT MAX(id) as max, MIN(id) as min FROM `aze_eng`");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                maxId = rs.getInt("max");
                minId = rs.getInt("min");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        int randomNumber = minId+(int)(Math.random()*maxId);

        if (getAzeEngById(randomNumber) == null){
            return randomIdGenerator();
        }else {
            return randomNumber;
        }
    }
}
