package tn.esprit.formation.managedbeans;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import tn.esprit.formation.entity.Formateur;

@FacesConverter(value = "genericConverter")

public class GenericConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	FormateurBean service = (FormateurBean) fc.getExternalContext().getApplicationMap().get("formateurBean");
            	System.out.println("hello"+value);
                return service.getFormateur(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid formateur."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return  object.toString();
        }
        else {
            return null;
        }
    }   

}
