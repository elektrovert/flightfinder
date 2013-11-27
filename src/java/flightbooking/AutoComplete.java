/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightbooking;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Paul Mallon
 */
@ManagedBean
@SessionScoped
public class AutoComplete {

    Airport fromAirport;
    Airport toAirport;
    BookingHelper helper;
    List<Airport> airports;

    public List<Airport> completeAirport(String query){
        List<Airport> suggestions = new ArrayList();
        for(Airport a : airports){
            if(a.getCity().startsWith(query)){
                suggestions.add(a);
            }
        }
        
        return suggestions;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }
    /**
     * Creates a new instance of AirportController
     */
    public AutoComplete() {
        helper = new BookingHelper();
        airports = helper.getAirports();
    }
    
    
    
}
