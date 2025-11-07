/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.InjuryDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.RowEditEvent;
import pojos.Injury;

@Named(value = "injuryBean")
@SessionScoped
public class InjuryBean implements Serializable
{
    private static final Logger LOG = Logger.getLogger(InjuryBean.class.getName());
    @Inject
    private InjuryDao dao;
    private List<Injury> listOfTuples;
    private Injury newTuple = new Injury("");
    private String oldIdInjuryType;
    
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

    public void insertTuple(Injury value)
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
    
    public void onRowEdit(RowEditEvent<Injury> event)
    {
        Injury value = event.getObject();
        String key = oldIdInjuryType == null ? value.getIdInjuryType() : oldIdInjuryType;
        
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
    
    public void deleteTuple(Injury value)
    {
        try
        {
            dao.delete(value.getIdInjuryType());
            listOfTuples = dao.retrieveAll();
            
            addMessage(FacesMessage.SEVERITY_INFO, "Tuple deleted", "");
        }
        catch (Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to delete tuple");
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }
    
    public void onValueChangedIdInjuryType(ValueChangeEvent event)
    {
        oldIdInjuryType = (String)event.getOldValue();
    }
    
    public List<String> getInjuryIds()
    {
        List<String> keys = new ArrayList<>();
        
        for (Injury e : listOfTuples)
            keys.add(e.getIdInjuryType());
        
        return keys;
    }
    
    public List<Injury> getListOfTuples()
    {
        return listOfTuples;
    }

    public Injury getNewTuple()
    {
        return newTuple;
    }
}
