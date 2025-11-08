/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.AthleteDao;
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
import pojos.Athlete;

@Named(value = "athleteBean")
@SessionScoped
public class AthleteBean implements Serializable
{
    private static final Logger LOG = Logger.getLogger(AthleteBean.class.getName());
    @Inject
    private AthleteDao dao;
    private List<Athlete> listOfTuples;
    private Athlete newTuple = new Athlete("", "", "", "", "", "", new Date(), "");
    private String oldIdAthlete;
    
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

    public void insertTuple(Athlete value)
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
    
    public void onRowEdit(RowEditEvent<Athlete> event)
    {
        Athlete value = event.getObject();
        String key = oldIdAthlete == null ? value.getIdAthlete() : oldIdAthlete;
        
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
    
    public void deleteTuple(Athlete value)
    {
        try
        {
            dao.delete(value.getIdAthlete());
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple deleted", "");
        }
        catch (Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to delete tuple");
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void onValueChangedIdAthlete(ValueChangeEvent event)
    {
        oldIdAthlete = (String)event.getOldValue();
    }
    
    public List<String> getAthleteIds()
    {
        List<String> keys = new ArrayList<>();
        
        for (Athlete e : listOfTuples)
            keys.add(e.getIdAthlete());
        
        return keys;
    }
    
    public List<Athlete> getListOfTuples()
    {
        return listOfTuples;
    }

    public Athlete getNewTuple()
    {
        return newTuple;
    }
}
