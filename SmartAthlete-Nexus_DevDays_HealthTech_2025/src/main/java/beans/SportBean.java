/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.SportDao;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.RowEditEvent;
import pojos.Sport;

@Named(value = "sportBean")
@SessionScoped
public class SportBean implements Serializable
{
    private static final Logger LOG = Logger.getLogger(SportBean.class.getName());
    @Inject
    private SportDao dao;
    private List<Sport> listOfTuples;
    private Sport newTuple = new Sport("");
    private String oldIdSportName;
    
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

    public void insertTuple(Sport value)
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
    
    public void onRowEdit(RowEditEvent<Sport> event)
    {
        Sport value = event.getObject();
        String key = oldIdSportName == null ? value.getIdSportName() : oldIdSportName;
        
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
    
    public void deleteTuple(Sport value)
    {
        try
        {
            dao.delete(value.getIdSportName());
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple deleted", "");
        }
        catch (Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to delete tuple");
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void onValueChangedSportName(ValueChangeEvent event)
    {
        oldIdSportName = (String)event.getOldValue();
    }
    
    public List<String> getSportNameIds()
    {
        List<String> keys = new ArrayList<>();
        
        for (Sport e : listOfTuples)
            keys.add(e.getIdSportName());
        
        return keys;
    }
    
    public List<Sport> getListOfTuples()
    {
        return listOfTuples;
    }

    public Sport getNewTuple()
    {
        return newTuple;
    }
}
