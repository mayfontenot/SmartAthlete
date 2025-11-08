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
import pojos.Athlete;
import utilities.MySQLConnector;

public class AthleteDao implements Serializable, Dao<String, Athlete>
{
    @Override
    public void insert(Athlete value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("INSERT INTO athletes VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, value.getIdAthlete());
        ps.setString(2, value.getIdCoach());
        ps.setString(3, value.getIdSportName());
        ps.setString(4, value.getFirstName());
        ps.setString(5, value.getMiddleName());
        ps.setString(6, value.getLastName());
        ps.setDate(7, new java.sql.Date(value.getDateOfBirth().getTime()));
        ps.setString(8, value.getEmail());
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public void update(String oldKey, Athlete value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("UPDATE athletes SET id_athlete = ?, id_coach = ?, id_sport_name = ?, first_name = ?, middle_name = ?, last_name = ?, date_of_birth = ?, email = ? WHERE id_athlete = ?");
        ps.setString(1, value.getIdAthlete());
        ps.setString(2, value.getIdCoach());
        ps.setString(3, value.getIdSportName());
        ps.setString(4, value.getFirstName());
        ps.setString(5, value.getMiddleName());
        ps.setString(6, value.getLastName());
        ps.setDate(7, new java.sql.Date(value.getDateOfBirth().getTime()));
        ps.setString(8, value.getEmail());
        ps.setString(9, oldKey);
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

        PreparedStatement ps = con.prepareStatement("DELETE FROM athletes WHERE id_athlete = ?");
        ps.setString(1, key);
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public Athlete retrieve(String key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;

        PreparedStatement ps = con.prepareStatement("SELECT * FROM athletes WHERE id_athlete = ?");
        ps.setString(1, key);
        
        ResultSet rs = ps.executeQuery();
        Athlete result = null;
        
        while(rs.next())
            result = new Athlete(
                rs.getString(1), 
                rs.getString(2), 
                rs.getString(3), 
                rs.getString(4), 
                rs.getString(5), 
                rs.getString(6), 
                new Date(rs.getDate(7).getTime()), 
                rs.getString(8)
            );
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }

    @Override
    public List<Athlete> retrieveAll() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return null;
            
        PreparedStatement ps = con.prepareStatement("SELECT * FROM athletes");

        ResultSet rs = ps.executeQuery();
        List<Athlete> results  = new ArrayList<>();
        
        while (rs.next())
            results.add(new Athlete(
                rs.getString(1), 
                rs.getString(2), 
                rs.getString(3), 
                rs.getString(4), 
                rs.getString(5), 
                rs.getString(6), 
                new Date(rs.getDate(7).getTime()), 
                rs.getString(8)
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
            
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM athletes");
        int count = ps.executeQuery().getInt(1);

        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return count;
    }
}