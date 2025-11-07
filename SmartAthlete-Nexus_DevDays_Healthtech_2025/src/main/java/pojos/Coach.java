/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Date;
import java.util.Objects;

public class Coach
{
    private String idCoach, idSportName, firstName, middleName, lastName;
    private Date dateOfBirth;
    private String email;

    public Coach(String idCoach, String idSportName, String firstName, String middleName, String lastName, Date dateOfBirth, String email)
    {
        this.idCoach = idCoach;
        this.idSportName = idSportName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }
    
    public String getIdCoach()
    {
        return idCoach;
    }

    public void setIdCoach(String idCoach)
    {
        this.idCoach = idCoach;
    }

    public String getIdSportName()
    {
        return idSportName;
    }

    public void setIdSportName(String idSportName)
    {
        this.idSportName = idSportName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.idCoach);
        
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
        
        final Coach other = (Coach) obj;
        
        return Objects.equals(this.idCoach, other.idCoach);
    }

    @Override
    public String toString()
    {
        return "Coach{idCoach=" + idCoach + ", idSportName=" + idSportName + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", email=" + email + '}';
    }
}
