/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Date;
import java.util.Objects;

public class AthleteInjury
{
    private String idAthlete, idInjuryType;
    private Date dateOfInjury;
    private String description;

    public AthleteInjury(String idAthlete, String idInjuryType, Date dateOfInjury, String description)
    {
        this.idAthlete = idAthlete;
        this.idInjuryType = idInjuryType;
        this.dateOfInjury = dateOfInjury;
        this.description = description;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getDateOfInjury()
    {
        return dateOfInjury;
    }

    public void setDateOfInjury(Date dateOfInjury)
    {
        this.dateOfInjury = dateOfInjury;
    }

    public String getIdInjuryType()
    {
        return idInjuryType;
    }

    public void setIdInjuryType(String idInjuryType)
    {
        this.idInjuryType = idInjuryType;
    }
    
    public String getIdAthlete()
    {
        return idAthlete;
    }

    public void setIdAthlete(String idAthlete)
    {
        this.idAthlete = idAthlete;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idAthlete);
        hash = 41 * hash + Objects.hashCode(this.idInjuryType);
        
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
        
        final AthleteInjury other = (AthleteInjury) obj;
        
        if (!Objects.equals(this.idAthlete, other.idAthlete))
            return false;
        
        if (!Objects.equals(this.idInjuryType, other.idInjuryType))
            return false;
        
        return Objects.equals(this.dateOfInjury, other.dateOfInjury);
    }

    @Override
    public String toString()
    {
        return "AthleteInjury{idAthlete=" + idAthlete + ", idInjuryType=" + idInjuryType + ", dateOfInjury=" + dateOfInjury + ", description=" + description + '}';
    }
}
