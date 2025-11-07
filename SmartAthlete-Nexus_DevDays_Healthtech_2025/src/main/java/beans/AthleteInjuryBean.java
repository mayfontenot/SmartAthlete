/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AthleteInjuryDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.RowEditEvent;
import pojos.AthleteInjury;

@Named(value = "athleteInjuryBean")
@SessionScoped
public class AthleteInjuryBean implements Serializable
{
    private static final Logger LOG = Logger.getLogger(AthleteInjuryBean.class.getName());
    @Inject
    private AthleteInjuryDao dao;
    private List<AthleteInjury> listOfTuples;
    private AthleteInjury newTuple = new AthleteInjury("", "", new Date(), "");
    private Object oldIdAthlete, oldIdInjuryType, oldDateOfInjury;
    
    @PostConstruct
    public void init()
    {
        try
        {
            listOfTuples = dao.retrieveAll();
        }
        catch(Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to retrieve tuples");
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public void insertTuple(AthleteInjury value)
    {
        try
        {
            dao.insert(value);
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple inserted", "");
        }
        catch (Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to insert tuple");
            Logger.getLogger(InjuryBean.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void onRowEdit(RowEditEvent<AthleteInjury> event)
    {
        AthleteInjury value = event.getObject();
        List<Object> key = new ArrayList<>(Arrays.asList(new Object[] {
            oldIdAthlete == null ? value.getIdAthlete() : oldIdAthlete, 
            oldIdInjuryType == null ? value.getIdInjuryType() : oldIdInjuryType, 
            oldDateOfInjury == null ? value.getDateOfInjury() : oldDateOfInjury
        }));
        
        try
        {
            dao.update(key, value);
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple updated", "");
        }
        catch (Throwable e)
        {
            LOG.log(Level.SEVERE, e.getMessage());
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to update tuple");
        }
    }
    
    public void deleteTuple(AthleteInjury value)
    {
        List<Object> key = new ArrayList<>(Arrays.asList(new Object[] {value.getIdAthlete(), value.getIdInjuryType(), value.getDateOfInjury()}));
        
        try
        {
            dao.delete(key);
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple deleted", "");
        }
        catch (Throwable e)
        {
            LOG.log(Level.SEVERE, e.getMessage());
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to delete tuple");
        }
    }
    
    public void onValueChangedIdAthlete(ValueChangeEvent event)
    {
        oldIdAthlete = event.getOldValue();
    }
    
    public void onValueChangedIdInjuryType(ValueChangeEvent event)
    {
        oldIdInjuryType = event.getOldValue();
    }
    
    public void onValueChangedDateOfInjury(ValueChangeEvent event)
    {
        oldDateOfInjury = event.getOldValue();
    }
    
    public List<AthleteInjury> getListOfTuples()
    {
        return listOfTuples;
    }

    public AthleteInjury getNewTuple()
    {
        return newTuple;
    }
}
