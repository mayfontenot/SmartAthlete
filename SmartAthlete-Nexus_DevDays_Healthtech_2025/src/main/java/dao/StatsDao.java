/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import utilities.MySQLConnector;

public class StatsDao implements Serializable
{
    public Map<String, Number> getInjuriesByAge(Integer startAge, Integer endAge) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;
        
        PreparedStatement ps = con.prepareStatement("SELECT id_injury_type, COUNT(id_injury_type) FROM athletes JOIN athlete_injuries USING(id_athlete) WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN ? AND ? GROUP BY id_injury_type");
        ps.setInt(1, startAge);
        ps.setInt(2, endAge);
        
        ResultSet rs = ps.executeQuery();
        Map<String, Number> result = new HashMap<>();
        
        while(rs.next())
            result.put(rs.getString(1), rs.getInt(2));
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }
    
    public Map<String, Number> getInjuriesBySport(String sport) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;

        PreparedStatement ps = con.prepareStatement("SELECT id_injury_type, COUNT(id_injury_type) FROM athletes JOIN athlete_injuries USING(id_athlete) WHERE id_sport_name = ? GROUP BY id_injury_type");
        ps.setString(1, sport);
        
        ResultSet rs = ps.executeQuery();
        Map<String, Number> result = new HashMap<>();
        
        while(rs.next())
            result.put(rs.getString(1), rs.getInt(2));
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }
    
    public Map<String, Number> getInjuriesByCoach(String coach) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;

        PreparedStatement ps = con.prepareStatement("SELECT id_injury_type, COUNT(id_injury_type) FROM athletes JOIN athlete_injuries USING(id_athlete) WHERE id_coach = ? GROUP BY id_injury_type");
        ps.setString(1, coach);
        
        ResultSet rs = ps.executeQuery();
        Map<String, Number> result = new HashMap<>();
        
        while(rs.next())
            result.put(rs.getString(1), rs.getInt(2));
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }
}
