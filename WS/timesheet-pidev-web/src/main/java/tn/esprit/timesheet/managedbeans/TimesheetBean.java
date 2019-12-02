package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import tn.esprit.timesheet.services.impl.TimesheetService;

@ManagedBean(name = "timesheetBean") 
@SessionScoped 
public class TimesheetBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LineChartModel areaModel;
	
	
	@EJB 
	TimesheetService timesheetService;
	
public int Nombredaywork(int lon) {
	Calendar cal = Calendar.getInstance();
    Date date=cal.getTime();
    int cont=0;
	for(int i=1;i<lon;i++) {
		cal.add(Calendar.DAY_OF_MONTH,-1);
        date=cal.getTime();
        
		cont = cont+  timesheetService.getdayByEmploye(LoginBean.getEmployeSta().getId(), date);
		
	}
	return cont;
		
		   }

public String Numberhourswork(int lon) {
	Calendar cal = Calendar.getInstance();
    Date date=cal.getTime();
    long seconds,minutes,Hours,diff=0;
    String res="";
	for(int i=0;i<lon;i++) {
		
       
        diff = diff+  timesheetService.getHoursByEmploye(LoginBean.getEmployeSta().getId(), date);
		cal.add(Calendar.DAY_OF_MONTH,-1);
        date=cal.getTime();
	}
	seconds = diff / 1000 % 60;  
	 minutes = diff / (60 * 1000) % 60; 
	 Hours = diff / (60 * 60 * 1000);
	 res="";
	 if(Hours<10)
		 res="0"+Hours;
	 else res=""+Hours;
	 if(minutes<10)
		 res=res+":0"+minutes;
	 else res=res+":"+minutes;
	 if(seconds<10)
		 res=res+":0"+seconds;
	 else res=res+":"+seconds;
	 
	return res;
		
		   }

@PostConstruct
public void init() {
    
    createAreaModel();
    
}
public CartesianChartModel getAreaModel() {
    return areaModel;
}	
private void createAreaModel() {
    areaModel = new LineChartModel();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");

    Calendar cal = Calendar.getInstance();
    Date date=cal.getTime();
    long Hours,diff=0;
    LineChartSeries hour = new LineChartSeries();
    hour.setFill(true);
    hour.setLabel("Employe "+LoginBean.getEmployeSta().getNom());
	for(int i=0;i<5;i++) {
		
        
        diff =   timesheetService.getHoursByEmploye(LoginBean.getEmployeSta().getId(), date);
        Hours = diff / (60 * 60 * 1000);
        if(Hours>8)
        	Hours=8;
        hour.set(sdf.format(date), Hours);
        cal.add(Calendar.DAY_OF_MONTH,-1);
        date=cal.getTime();
	}
	
	 

    
    
	
    
    

    areaModel.addSeries(hour);
    

    areaModel.setTitle("Area Chart Hours");
    areaModel.setLegendPosition("ne");
    areaModel.setStacked(true);
    areaModel.setShowPointLabels(true);

    Axis xAxis = new CategoryAxis("Days");
    areaModel.getAxes().put(AxisType.X, xAxis);
    Axis yAxis = areaModel.getAxis(AxisType.Y);
    yAxis.setLabel("Hours");
    yAxis.setMin(0);
    yAxis.setMax(8);
}

}
