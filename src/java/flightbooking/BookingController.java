/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

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
    int fromId;
    int toId;
    int startId;
    int endId;
    String from;
    String to;
    
    private int recordCount = 1000;
    private int pageSize = 10;
    private int selectedItemIndex;
    private Route currentRoute;
    private Airport currentAirport;
    private String selectedFrom;
    private String selectedTo;
    private String selectedRoute;
    private DataModel searchResults;
    BookingHelper helper;
    List<Route> routes;

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
    public List<Airport> fromAirports;

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
    public List<Airport> toAirports;
    public String fromCity; // = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("fromId"); 
    public String toCity; // = ((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("toId"); 

    public List getAirports() {
        return fromAirports;
    }

    public void setAirports(List airports) {
        this.fromAirports = airports;
    }


    public BookingController() {
        helper = new BookingHelper();
        this.startId = startId;
        this.endId = endId;
        
    }
//    public BookingController(String from, String to) {
//        fromId = 599;
//        toId = 1382;
//        helper = new BookingHelper();
//        this.startId = startId;
//        this.endId = endId;
//        this.from = "Dublin"; //from;
//        this.to = "Dubai"; //to;
//    
//    }

//    public Route getSelected() {
//        if (currentRoute == null) {
//            currentRoute = new Route();
//            selectedItemIndex = -1;
//        }
//        return currentRoute;
//    }
    
    public Airport getSelected() {
        if (currentAirport == null) {
            currentAirport = new Airport();
            selectedItemIndex = -1;
        }
        return currentAirport;
    }

    public List<Route> getRoutes(String from, String to) {
        int fromId = 0, toId = 0;
        
        for(Airport a : fromAirports){
            if(a.getName().equals(from)){
                fromId = a.getId();
                break;
            }
        }
        for(Airport a : toAirports){
            if(a.getName().equals(to)){
                toId = a.getId();
                break;
            }
        }
        System.out.println("From ID: " + fromId + ", To ID: " + toId);
        if (routes == null) {
            routes = helper.getRoutes(fromId, toId);
        }
        System.out.println("Routes received!");
         //   System.out.println("Route: " + routes.get(0).getAirlineId() + ", " + routes.get(0).getCode());
   
        return routes;

    }
    public List<Airport> getFromAirports(String city) {
        System.out.println("Searching the database!");
       
        if (fromAirports == null) {
            fromAirports = helper.getAirports(city);
        }

        return fromAirports;

    }
    
        public List<Airport> getToAirports(String city) {
        System.out.println("Searching the database!");
       
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

    public boolean isHasNextPage() {
        if (endId + pageSize <= recordCount) {
            return true;
        }
        return false;
    }

    public boolean isHasPreviousPage() {
        if (startId - pageSize > 0) {
            return true;
        }
        return false;
    }

    public String next() {
        startId = endId + 1;
        endId = endId + pageSize;
        recreateModel();
        return "index";
    }

    public String previous() {
        startId = startId - pageSize;
        endId = endId - pageSize;
        recreateModel();
        return "index";
    }

    public int getPageSize() {
        return pageSize;
    }

    public String prepareView() {
        System.out.println("From: " + fromCity + " To: " + toCity);
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
        return "Test fromCity";
    }
    
    public void setToCity(String city){
        toCity = city;
    }
    public String getToCity(){
        return "Test toCity";
    }

    public String prepareResultConfirmation(){
        
        return "confirmationresults";
    }

}
