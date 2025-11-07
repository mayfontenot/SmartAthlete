package beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.Tab;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;
import utilities.Utilities;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable
{
    private String userId, password;
    private int activeIndex;

    public void addMessage(FacesMessage.Severity severity, String summary, String detail)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void onChange(TabChangeEvent event)
    {
        final Tab activeTab = event.getTab();
        final Integer activeIndex = ((TabView) event.getSource()).getChildren().indexOf(activeTab);
        this.activeIndex = activeIndex;
        
        UIComponent uicTabUsers = Utilities.findComponent("id_tva");
        if (uicTabUsers != null)
            PrimeFaces.current().ajax().update(uicTabUsers);
        
        UIComponent uicTabStats = Utilities.findComponent("id_tabStats");
        if (uicTabStats != null)
            PrimeFaces.current().ajax().update(uicTabStats);
        
        UIComponent uicTabAthleteInjuries = Utilities.findComponent("id_tabAthleteInjuries");
        if (uicTabAthleteInjuries != null)
            PrimeFaces.current().ajax().update(uicTabAthleteInjuries);
        
        UIComponent uicTabInjuries = Utilities.findComponent("id_tabInjuries");
        if (uicTabInjuries != null)
            PrimeFaces.current().ajax().update(uicTabInjuries);
        
        UIComponent uicTabSports = Utilities.findComponent("id_tabSports");
        if (uicTabSports != null)
            PrimeFaces.current().ajax().update(uicTabSports);
        
        UIComponent uicTabAthletes = Utilities.findComponent("id_tabAthletes");
        if (uicTabAthletes != null)
            PrimeFaces.current().ajax().update(uicTabAthletes);
        
        UIComponent uicTabCoaches = Utilities.findComponent("id_tabCoaches");
        if (uicTabCoaches != null)
            PrimeFaces.current().ajax().update(uicTabCoaches);
    }
    
    public String login()
    {
        if (!userId.equals("root") || !password.equals("password"))
        {
            addMessage(FacesMessage.SEVERITY_INFO, "Failed to login", "Invalid user ID or password!");
            
            return "";
        }
            
        return "index";
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public int getActiveIndex()
    {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex)
    {
        this.activeIndex = activeIndex;
    }
}