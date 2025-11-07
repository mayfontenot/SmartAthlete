/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.CoachDao;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.RowEditEvent;
import pojos.Coach;

@Named(value = "coachBean")
@SessionScoped
public class CoachBean implements Serializable
{
    private static final Logger LOG = Logger.getLogger(CoachBean.class.getName());
    @Inject
    private CoachDao dao;
    private List<Coach> listOfTuples;
    private Coach newTuple = new Coach("", "", "", "", "", new Date(), "");
    private String oldIdCoach;
    
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

    public void insertTuple(Coach value)
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
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void onRowEdit(RowEditEvent<Coach> event)
    {
        Coach value = event.getObject();
        String key = oldIdCoach == null ? value.getIdCoach() : oldIdCoach;
        
        try
        {
            dao.update(key, value);
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple updated", "");
        }
        catch (Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to update tuple");
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void deleteTuple(Coach value)
    {
        try
        {
            dao.delete(value.getIdCoach());
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple deleted", "");
        }
        catch (Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to delete tuple");
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void onValueChangedIdCoach(ValueChangeEvent event)
    {
        oldIdCoach = (String)event.getOldValue();
    }
    
    public List<String> getCoachIds()
    {
        List<String> keys = new ArrayList<>();
        
        for (Coach e : listOfTuples)
            keys.add(e.getIdCoach());
        
        return keys;
    }
    
    public List<Coach> getListOfTuples()
    {
        return listOfTuples;
    }

    public Coach getNewTuple()
    {
        return newTuple;
    }
}
