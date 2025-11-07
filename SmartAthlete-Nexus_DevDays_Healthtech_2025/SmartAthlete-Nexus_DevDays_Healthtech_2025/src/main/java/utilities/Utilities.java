/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;

public class Utilities
{
    public synchronized static UIComponent findComponent(String id)
    {
        UIComponent result = null;
        UIComponent root = FacesContext.getCurrentInstance().getViewRoot();
        
        if (root != null)
            result = findComponent(root, id);
            
        return result;
    }
    
    public synchronized static UIComponent findComponent(UIComponent root, String id)
    {
        UIComponent result = null;
        
        if (root.getId().equals(id))
            return root;
        
        for (UIComponent child : root.getChildren())
        {
            if (child.getId().equals(id))
            {
                result = child;
                
                break;
            }
            
            result = findComponent(child, id);
            
            if (result != null)
                break;
        }
        
        return result;
    }
    
    public synchronized static void refreshComponent(String id)
    {
        UIComponent c = Utilities.findComponent(id);
        
        if (c != null)
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(c.getClientId());
        else
            System.out.println("component not found " + id);
    }
}
