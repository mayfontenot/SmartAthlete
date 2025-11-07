/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import dao.StatsDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.ItemSelectEvent;

import software.xdev.chartjs.model.charts.BarChart;
import software.xdev.chartjs.model.color.RGBAColor;
import software.xdev.chartjs.model.data.BarData;
import software.xdev.chartjs.model.dataset.BarDataset;
import software.xdev.chartjs.model.enums.IndexAxis;
import software.xdev.chartjs.model.options.BarOptions;
import software.xdev.chartjs.model.options.Plugins;
import software.xdev.chartjs.model.options.Title;
import software.xdev.chartjs.model.options.scale.Scales;
import software.xdev.chartjs.model.options.scale.cartesian.CartesianScaleOptions;
import software.xdev.chartjs.model.options.scale.cartesian.CartesianTickOptions;

@Named(value = "statsBean")
@RequestScoped
public class StatsBean implements Serializable
{
    private static final Logger LOG = Logger.getLogger(StatsBean.class.getName());
    @Inject
    private StatsDao daoStats;
    private Map<String, Number> injuriesByAge;
    private Map<String, Number> injuriesBySport;
    private Map<String, Number> injuriesByCoach;
    private String injuriesByAgeModel, injuriesBySportModel, injuriesByCoachModel;
    private Integer startAge = 6, endAge = 18;
    private String sport = "FOOTBALL", coach = "US120";
    
    @PostConstruct
    public void init()
    {
        createModels();
    }
    
    public void addMessage(FacesMessage.Severity severity, String summary, String detail)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    public void createModels()
    {
        try
        {
            injuriesByAge = daoStats.getInjuriesByAge(startAge, endAge);
            injuriesBySport = daoStats.getInjuriesBySport(sport);
            injuriesByCoach = daoStats.getInjuriesByCoach(coach);
        }
        catch(Throwable e)
        {
            addMessage(FacesMessage.SEVERITY_ERROR, "Database error", "Failed to retrieve tuples");
            LOG.log(Level.SEVERE, e.getMessage());
        }
        
        injuriesByAgeModel = new BarChart()
                .setData(new BarData()
                .addDataset(new BarDataset()
                        .setData(injuriesByAge.values())
                        .setLabel("Total")
                        .setBackgroundColor(new RGBAColor(255, 99, 132, 0.2))
                        .setBorderColor(new RGBAColor(255, 99, 132))
                        .setBorderWidth(1))
                .setLabels(injuriesByAge.keySet()))
                .setOptions(new BarOptions()
                        .setResponsive(true)
                        .setMaintainAspectRatio(false)
                        .setIndexAxis(IndexAxis.X)
                        .setScales(new Scales().addScale(Scales.ScaleAxis.Y, new CartesianScaleOptions()
                                .setStacked(false)
                                .setTicks(new CartesianTickOptions()
                                        .setAutoSkip(true)
                                        .setMirror(true)))
                        )
                        .setPlugins(new Plugins()
                                .setTitle(new Title()
                                        .setDisplay(true)
                                        .setText("Injuries by Age")))
                ).toJson();
        
        injuriesBySportModel = new BarChart()
                .setData(new BarData()
                .addDataset(new BarDataset()
                        .setData(injuriesBySport.values())
                        .setLabel("Total")
                        .setBackgroundColor(new RGBAColor(255, 99, 132, 0.2))
                        .setBorderColor(new RGBAColor(255, 99, 132))
                        .setBorderWidth(1))
                .setLabels(injuriesBySport.keySet()))
                .setOptions(new BarOptions()
                        .setResponsive(true)
                        .setMaintainAspectRatio(false)
                        .setIndexAxis(IndexAxis.X)
                        .setScales(new Scales().addScale(Scales.ScaleAxis.Y, new CartesianScaleOptions()
                                .setStacked(false)
                                .setTicks(new CartesianTickOptions()
                                        .setAutoSkip(true)
                                        .setMirror(true)))
                        )
                        .setPlugins(new Plugins()
                                .setTitle(new Title()
                                        .setDisplay(true)
                                        .setText("Injuries by Sport")))
                ).toJson();
        
        injuriesByCoachModel = new BarChart()
                .setData(new BarData()
                .addDataset(new BarDataset()
                        .setData(injuriesByCoach.values())
                        .setLabel("Total")
                        .setBackgroundColor(new RGBAColor(255, 99, 132, 0.2))
                        .setBorderColor(new RGBAColor(255, 99, 132))
                        .setBorderWidth(1))
                .setLabels(injuriesByCoach.keySet()))
                .setOptions(new BarOptions()
                        .setResponsive(true)
                        .setMaintainAspectRatio(false)
                        .setIndexAxis(IndexAxis.X)
                        .setScales(new Scales().addScale(Scales.ScaleAxis.Y, new CartesianScaleOptions()
                                .setStacked(false)
                                .setTicks(new CartesianTickOptions()
                                        .setAutoSkip(true)
                                        .setMirror(true)))
                        )
                        .setPlugins(new Plugins()
                                .setTitle(new Title()
                                        .setDisplay(true)
                                        .setText("Injuries by Coach")))
                ).toJson();
    }

    public void itemSelect(ItemSelectEvent event)
    {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Value: " + event.getData()
                + ", Item Index: " + event.getItemIndex()
                + ", DataSet Index:" + event.getDataSetIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getInjuriesByAgeModel()
    {
        return injuriesByAgeModel;
    }

    public String getInjuriesBySportModel()
    {
        return injuriesBySportModel;
    }

    public String getInjuriesByCoachModel()
    {
        return injuriesByCoachModel;
    }

    public int getStartAge()
    {
        return startAge;
    }

    public void setStartAge(int startAge)
    {
        this.startAge = startAge;
    }

    public int getEndAge()
    {
        return endAge;
    }

    public void setEndAge(int endAge)
    {
        this.endAge = endAge;
    }

    public String getSport()
    {
        return sport;
    }

    public void setSport(String sport)
    {
        this.sport = sport;
    }

    public String getCoach()
    {
        return coach;
    }

    public void setCoach(String coach)
    {
        this.coach = coach;
    }
}
