/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.List;
import pojos.AthleteInjury;
import interfaces.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import utilities.MySQLConnector;

public class AthleteInjuryDao implements Serializable, Dao<List<Object>, AthleteInjury>
{
    @Override
    public void insert(AthleteInjury value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("INSERT INTO athlete_injuries VALUES(?, ?, ?, ?)");
        ps.setString(1, value.getIdAthlete());
        ps.setString(2, value.getIdInjuryType());
        ps.setDate(3, new java.sql.Date(value.getDateOfInjury().getTime()));
        ps.setString(4, value.getDescription());
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public void update(List<Object> oldKey, AthleteInjury value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("UPDATE athlete_injuries SET id_athlete = ?, id_injury_type = ?, date_of_injury = ?, description = ? WHERE id_athlete = ? AND id_injury_type = ? AND date_of_injury = ?");
        ps.setString(1, value.getIdAthlete());
        ps.setString(2, value.getIdInjuryType());
        ps.setDate(3, new java.sql.Date(value.getDateOfInjury().getTime()));
        ps.setString(4, value.getDescription());
        ps.setString(5, (String)oldKey.get(0));
        ps.setString(6, (String)oldKey.get(1));
        ps.setDate(7, new java.sql.Date(((Date)oldKey.get(2)).getTime()));
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public void delete(List<Object> key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {  
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("DELETE FROM athlete_injuries WHERE id_athlete = ? AND id_injury_type = ? AND date_of_injury = ?");
        ps.setString(1, (String)key.get(0));
        ps.setString(2, (String)key.get(1));
        ps.setDate(3, new java.sql.Date(((Date)key.get(2)).getTime()));
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public AthleteInjury retrieve(List<Object> key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;

        PreparedStatement ps = con.prepareStatement("SELECT * FROM athlete_injuries WHERE id_athlete = ? AND id_injury_type = ? and date_of_injury = ?");
        ps.setString(1, (String)key.get(0));
        ps.setString(2, (String)key.get(1));
        ps.setDate(3, new java.sql.Date(((Date)key.get(2)).getTime()));
        
        ResultSet rs = ps.executeQuery();
        AthleteInjury result = null;
        
        while(rs.next())
            result = new AthleteInjury(
                rs.getString(1), 
                rs.getString(2), 
                new Date(rs.getDate(3).getTime()), 
                rs.getString(4)
            );
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }

    @Override
    public List<AthleteInjury> retrieveAll() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return null;
            
        PreparedStatement ps = con.prepareStatement("SELECT * FROM athlete_injuries");

        ResultSet rs = ps.executeQuery();
        List<AthleteInjury> results  = new ArrayList<>();
        
        while (rs.next())
            results.add(new AthleteInjury(
                rs.getString(1), 
                rs.getString(2), 
                new Date(rs.getDate(3).getTime()), 
                rs.getString(4)
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
            
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM athlete_injuries");
        int count = ps.executeQuery().getInt(1);

        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return count;
    }
}
