/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao <KT, VT>
{
    void insert(VT value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
    void update(KT oldKey, VT value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
    void delete(KT key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
    VT retrieve(KT key) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
    List<VT> retrieveAll() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
    int count() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException;
}
