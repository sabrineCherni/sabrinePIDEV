package tn.esprit.competence.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.competence.entity.Competence;
import tn.esprit.competence.services.impl.CompetenceService;
import tn.esprit.competence.services.interfaces.CompetenceServiceRemote;
 
@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable{

	public static String favColor1;
	public static String favColor2;
	public static String favColor3;
	public static int result;

	//getter and setter methods 

	public String getFavColor1() {
		return favColor1;
	}

	public void setFavColor1(String favColor1) {
		this.favColor1 = favColor1;
	}

	public String getFavColor2() {
		return favColor2;
	}

	public void setFavColor2(String favColor2) {
		this.favColor2 = favColor2;
	}

	public String getFavColor3() {
		return favColor3;
	}

	public void setFavColor3(String favColor3) {
		this.favColor3 = favColor3;
	}
	

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}


	//Generated by Map
	private static Map<String,Object> color2Value;
	static{
		color2Value = new LinkedHashMap<String,Object>();
		color2Value.put("Through rote memorization", "Reponse1"); //label, value
		color2Value.put("Through collaboration", "Reponse2");
		color2Value.put("Through repetition", "Reponse3");
	}
	
	public Map<String,Object> getFavColor2Value() {
		return color2Value;
	}
	
	//Generated by Object array
	public static class Color{
		public String colorLabel;
		public String colorValue;
		
		public Color(String colorLabel, String colorValue){
			this.colorLabel = colorLabel;
			this.colorValue = colorValue;
		}
		
		public String getColorLabel(){
			return colorLabel;
		}
		
		public String getColorValue(){
			return colorValue;
		}
		
	}
	
	public Color[] color3List;
	
	public Color[] getFavColor3Value() {
		
		color3List = new Color[3];
		color3List[0] = new Color("Music, videos, games, podcasts", "Reponse1");
		color3List[1] = new Color("Repetition, memorization, imitation, drills", "Reponse2");
		color3List[2] = new Color("Printables, worksheets, word puzzles", "Reponse3");
		
		return color3List;
	}
	
	public String[] color3;
	 String[] questions() {
		    String[] color3 = new String[3];
			color3[0]= new String(favColor1);
			color3[1]= new String(favColor2);
			color3[2]= new String(favColor3);
			
			return color3;
	}
			
		



public static int takeTest() {
	result = 0;
	 String[] questions = new String[3];
		questions[0]= new String(favColor1);
		questions[1]= new String(favColor2);
		questions[2]= new String(favColor3);
	System.out.println("-----------------------------------------------");
	for ( int i=0 ; i < questions.length ; i++) {
		

		if(questions[i].equals("Reponse1")){result++;}
		}
	return result ;
	}



	

	
}
	
	
	
