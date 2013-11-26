/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

/**
 *
 * @author Paul Mallon
 */
@ManagedBean
@SessionScoped
public class BookingController implements Serializable{

    /**
     * Creates a new instance of BookingController
     */

    int startId;
    int endId;
    String from;
    String to;
    private int selectedItemIndex;
    private Route currentRoute;
    private Airport currentAirport;
    private String selectedFrom;
    private String selectedTo;
    private String selectedRoute;
    private DataModel searchResults;
    BookingHelper helper;
    List<Route> routes;
    public List<Airport> toAirports;
    public String fromCity; // = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("fromId"); 
    public String toCity; // = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("toId"); 
    public List<Airport> fromAirports;

    public String getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(String selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getSelectedFrom() {
        return selectedFrom;
    }

    public void setSelectedFrom(String selectedFrom) {
        this.selectedFrom = selectedFrom;
    }

    public String getSelectedTo() {
        return selectedTo;
    }

    public void setSelectedTo(String selectedTo) {
        this.selectedTo = selectedTo;
    }

    public List<Airport> getFromAirports() {
        return fromAirports;
    }

    public void setFromAirports(List<Airport> fromAirports) {
        this.fromAirports = fromAirports;
    }

    public List<Airport> getToAirports() {
        return toAirports;
    }

    public void setToAirports(List<Airport> toAirports) {
        this.toAirports = toAirports;
    }

    public List getAirports() {
        return fromAirports;
    }

    public void setAirports(List airports) {
        this.fromAirports = airports;
    }


    public BookingController() {
        helper = new BookingHelper();  
    }
    
    public Airport getSelected() {
        if (currentAirport == null) {
            currentAirport = new Airport();
            selectedItemIndex = -1;
        }
        return currentAirport;
    }

    public List<Route> getRoutes(String from, String to) {
        int fromId = 0, toId = 0;
        getFromAirports(from);
        for(Airport a : fromAirports){
            if(a.getName().equals(from)){
                fromId = a.getId();
                break;
            }
        }
        getToAirports(to);
        for(Airport a : toAirports){
            if(a.getName().equals(to)){
                toId = a.getId();
                break;
            }
        }
      
        if (routes == null) {
            routes = helper.getRoutes(fromId, toId);
        }
        return routes;

    }
    public List<Airport> getFromAirports(String city) {
       
        if (fromAirports == null) {
            fromAirports = helper.getAirports(city);
        }
       
        return fromAirports;

    }
    
        public List<Airport> getToAirports(String city) {
       
        if (toAirports == null) {
            toAirports = helper.getAirports(city);
        }

        return toAirports;

    }

    void recreateModel() {
        routes = null;
        fromAirports = null;
        toAirports = null;
    }

    public String prepareView() {
        getFromAirports(fromCity);
        getToAirports(toCity);
        
        return "airportresults";
    }
    
        public String prepareRoutesView() {
            getRoutes(selectedFrom, selectedTo);
        
        return "routesresults";
    }

    public String prepareList() {
        recreateModel();
        return "index";
    }

    public String getRouteAirline() {

        return null;
    }
    
    public void setFromCity(String city){
        fromCity = city;
    }
    public String getFromCity(){
        return fromCity;
    }
    
    public void setToCity(String city){
        toCity = city;
    }
    public String getToCity(){
        return toCity;
    }
    
    public String prepareIndex(){
    
        return "index";
    }

}
