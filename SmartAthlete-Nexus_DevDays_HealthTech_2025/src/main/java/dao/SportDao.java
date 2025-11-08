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
import java.util.List;
import pojos.Sport;
import utilities.MySQLConnector;

public class SportDao implements Serializable, Dao<String, Sport>
{
    @Override
    public void insert(Sport value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("INSERT INTO sports VALUES(?)");
        ps.setString(1, value.getIdSportName());
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public void update(String oldKey, Sport value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("UPDATE sports SET id_sport_name = ? WHERE id_sport_name = ?");
        ps.setString(1, value.getIdSportName());
        ps.setString(2, oldKey);
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

        PreparedStatement ps = con.prepareStatement("DELETE FROM sports WHERE id_sport_name = ?");
        ps.setString(1, key);
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public Sport retrieve(String key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;

        PreparedStatement ps = con.prepareStatement("SELECT * FROM sports WHERE id_sport_name = ?");
        ps.setString(1, key);
        
        ResultSet rs = ps.executeQuery();
        Sport result = null;
        
        while(rs.next())
            result = new Sport(
                rs.getString(1)
            );
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }

    @Override
    public List<Sport> retrieveAll() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return null;
            
        PreparedStatement ps = con.prepareStatement("SELECT * FROM sports");

        ResultSet rs = ps.executeQuery();
        List<Sport> results  = new ArrayList<>();
        
        while (rs.next())
            results.add(new Sport(
                rs.getString(1)
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
            
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM sports");
        int count = ps.executeQuery().getInt(1);

        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return count;
    }
}