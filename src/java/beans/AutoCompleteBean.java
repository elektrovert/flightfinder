/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import flightbooking.Airport;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;  
import java.util.List;  
  
import javax.faces.application.FacesMessage;  
import javax.faces.context.FacesContext;    
import javax.faces.model.DataModel;
import org.primefaces.event.SelectEvent;  


/**
 *
 * @author Paul Mallon
 */
@ManagedBean
@SessionScoped
public class AutoCompleteBean {  
  
    String selectedAirport = "";
    DataModel airports;
    public AutoCompleteBean() {  
 
    }  
  
    public String getSelectedAirport() {  
        return selectedAirport;  
    }  
  
    public void setSelectedAirport(String selectedPlayer1) {  
        this.selectedAirport = selectedAirport;  
    } 
  
    public List<Airport> completeAirport(String query) {  
        List<Airport> suggestions = new ArrayList();  
          
        for(Object a : airports) {  
            Airport airport = (Airport) a;
            if(airport.getCity().startsWith(query))  
                suggestions.add(airport);  
        }  
          
        return suggestions;  
    }  
}  
