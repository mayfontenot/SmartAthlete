/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Objects;

public class Injury
{
    private String idInjuryType;

    public Injury(String idInjuryType)
    {
        this.idInjuryType = idInjuryType;
    }

    public String getIdInjuryType()
    {
        return idInjuryType;
    }

    public void setIdInjuryType(String idInjuryType)
    {
        this.idInjuryType = idInjuryType;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idInjuryType);
        
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
            
        final Injury other = (Injury) obj;
        
        return Objects.equals(this.idInjuryType, other.idInjuryType);
    }
    
    @Override
    public String toString()
    {
        return "Injury{idInjuryType=" + idInjuryType + '}';
    }
}
