/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import interfaces.Dao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pojos.Coach;
import utilities.MySQLConnector;

public class CoachDao implements Serializable, Dao<String, Coach>
{
    @Override
    public void insert(Coach value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("INSERT INTO coaches VALUES(?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, value.getIdCoach());
        ps.setString(2, value.getIdSportName());
        ps.setString(3, value.getFirstName());
        ps.setString(4, value.getMiddleName());
        ps.setString(5, value.getLastName());
        ps.setDate(6, new java.sql.Date(value.getDateOfBirth().getTime()));
        ps.setString(7, value.getEmail());
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public void update(String oldKey, Coach value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("UPDATE coaches SET id_coach = ?, id_sport_name = ?, first_name = ?, middle_name = ?, last_name = ?, date_of_birth = ?, email = ? WHERE id_coach = ?");
        ps.setString(1, value.getIdCoach());
        ps.setString(2, value.getIdSportName());
        ps.setString(3, value.getFirstName());
        ps.setString(4, value.getMiddleName());
        ps.setString(5, value.getLastName());
        ps.setDate(6, new java.sql.Date(value.getDateOfBirth().getTime()));
        ps.setString(7, value.getEmail());
        ps.setString(8, oldKey);
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public void delete(String key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {  
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("DELETE FROM coaches WHERE id_coach = ?");
        ps.setString(1, key);
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public Coach retrieve(String key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;

        PreparedStatement ps = con.prepareStatement("SELECT * FROM coaches WHERE id_coach = ?");
        ps.setString(1, key);
        
        ResultSet rs = ps.executeQuery();
        Coach result = null;
        
        while(rs.next())
            result = new Coach(
                rs.getString(1), 
                rs.getString(2), 
                rs.getString(3), 
                rs.getString(4), 
                rs.getString(5), 
                new Date(rs.getDate(6).getTime()), 
                rs.getString(7)
            );
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }

    @Override
    public List<Coach> retrieveAll() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return null;
            
        PreparedStatement ps = con.prepareStatement("SELECT * FROM coaches");

        ResultSet rs = ps.executeQuery();
        List<Coach> results  = new ArrayList<>();
        
        while (rs.next())
            results.add(new Coach(
                rs.getString(1), 
                rs.getString(2), 
                rs.getString(3), 
                rs.getString(4), 
                rs.getString(5), 
                new Date(rs.getDate(6).getTime()), 
                rs.getString(7)
            ));

        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return results;
    }

    @Override
    public int count() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return 0;
            
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM coaches");
        int count = ps.executeQuery().getInt(1);

        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return count;
    }
}