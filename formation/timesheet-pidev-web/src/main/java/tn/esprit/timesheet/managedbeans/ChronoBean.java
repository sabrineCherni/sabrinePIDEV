package tn.esprit.timesheet.managedbeans;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.timesheet.entity.Status;
import tn.esprit.timesheet.entity.Tache;
import tn.esprit.timesheet.services.impl.TimesheetService;
@ManagedBean(name = "chronoBean") 
@SessionScoped 
public class ChronoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long seconds,minutes,diff,Hours;
	long som;
	private String res="";
	private Date d1;
	private Date d2;
		
	private Integer progress;
	
	@EJB 
	TimesheetService timesheetService;
	 
    public Integer getProgress() {
        if(progress == null ) {
            progress = 0;
            som=0;
            d1= new Date();
        }
        else {
        	
        		d2=new Date();
       	 diff = d2.getTime() - d1.getTime();//as given

       	 seconds = diff / 1000 % 60;  
       	 minutes = diff / (60 * 1000) % 60; 
       	 Hours = diff / (60 * 60 * 1000);
       	 som=(((Hours*3600)+(minutes*60)+seconds)*100)/60;
            progress = (int) (som);
             
            if(progress > 100)
                progress = 100;
        }
         
        return progress;
    }
 
    public void setProgress(Integer progress) {
        this.progress = progress;
    }
    
    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task Completed"));
        
    
    }
     
 
	public void cancel(String id,String title) {
        progress = null;
        System.out.println("date 1 : "+d1+" date 2 : "+d2);
        timesheetService.updateTache(new Tache(id,title,Status.DONE,d1,d2,LoginBean.getEmployeSta()));
        d1=null;
    }
	public String getRes() {
		
		return res;
	}
	public void increment() {
		if(progress==null || progress==0)
		{res="00:00:00";}
		else
		{
    	d2= new Date();
    	 diff = d2.getTime() - d1.getTime();//as given

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
        }
    }
}
