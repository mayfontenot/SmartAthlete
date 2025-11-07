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
import pojos.Injury;
import utilities.MySQLConnector;

public class InjuryDao implements Serializable, Dao<String, Injury>
{
    @Override
    public void insert(Injury value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("INSERT INTO injuries VALUES(?)");
        ps.setString(1, value.getIdInjuryType());
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public void update(String oldKey, Injury value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return;

        PreparedStatement ps = con.prepareStatement("UPDATE injuries SET id_injury_type = ? WHERE id_injury_type = ?");
        ps.setString(1, value.getIdInjuryType());
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

        PreparedStatement ps = con.prepareStatement("DELETE FROM injuries WHERE id_injury_type = ?");
        ps.setString(1, key);
        ps.execute();
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
    }

    @Override
    public Injury retrieve(String key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();

        if (con == null)
            return null;

        PreparedStatement ps = con.prepareStatement("SELECT * FROM injuries WHERE id_injury_type = ?");
        ps.setString(1, key);
        
        ResultSet rs = ps.executeQuery();
        Injury result = null;
        
        while(rs.next())
            result = new Injury(
                rs.getString(1)
            );
        
        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return result;
    }

    @Override
    public List<Injury> retrieveAll() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
    {
        Connection con = MySQLConnector.connection();
        
        if (con == null)
            return null;
            
        PreparedStatement ps = con.prepareStatement("SELECT * FROM injuries");

        ResultSet rs = ps.executeQuery();
        List<Injury> results  = new ArrayList<>();
        
        while (rs.next())
            results.add(new Injury(
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
            
        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM injuries");
        int count = ps.executeQuery().getInt(1);

        ps.close();
        MySQLConnector.closeDatabaseConnection(con);
        
        return count;
    }
}
