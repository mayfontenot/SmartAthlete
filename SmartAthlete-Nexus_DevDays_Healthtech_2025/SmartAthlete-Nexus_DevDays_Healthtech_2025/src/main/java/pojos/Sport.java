/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Objects;

public class Sport
{
    private String idSportName;

    public Sport(String idSportName)
    {
        this.idSportName = idSportName;
    }
    
    public String getIdSportName()
    {
        return idSportName;
    }

    public void setIdSportName(String idSportName)
    {
        this.idSportName = idSportName;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idSportName);
        
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        final Sport other = (Sport) obj;
        
        return Objects.equals(this.idSportName, other.idSportName);
    }
    
    @Override
    public String toString()
    {
        return "Sport{idSportName=" + idSportName + '}';
    }
}
