/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Paul Mallon
 */
@ManagedBean
@RequestScoped
public class SearchController {

    String fromAirport;
    String toAirport;
    Route selectedRoute;
    String routeId;
    BookingHelper helper;
    List<Route> routes;
    List<Airport> airports;

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
        System.out.println("RouteId = " + routeId);
    }

    public void calculateSelectedRoute() {
        int routeIdInt = Integer.getInteger(routeId);
        selectedRoute = helper.getRoute(routeIdInt);      
    }

    public void setSelectedRoute(Route selectedRoute) {
        this.selectedRoute = selectedRoute;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        System.out.println("From Airport = " + fromAirport);
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        System.out.println("To Airport = " + toAirport);
        this.toAirport = toAirport;
    }
    
    public List<Route> getRoutes() {
   
        return routes;

    }
    

    public void calculateRoutes() {
        int fromId = 0, toId = 0;
        System.out.println("From Airport: " + fromAirport);
        System.out.println("To Airport: " + toAirport);
        for (Airport a : airports) {

            if (a.getName().equals(fromAirport)) {
                fromId = a.getId();
            }
            if (a.getName().equals(toAirport)) {
                toId = a.getId();
            }

            if (fromId != 0 && toId != 0) {
                break;
            }
        }
        System.out.println("From ID: " + fromId + ", To ID: " + toId);
        if (routes == null) {
            routes = helper.getRoutes(fromId, toId);
        }
        System.out.println("Routes received! size = " + routes.size());
    }

    public String prepareRoutesView() {
        calculateRoutes();
        return "routesresults";
    }
    
    public String prepareIndexView(){
        System.out.println("The selectedRoute was " + selectedRoute);
        System.out.println("The fromAirport was " + fromAirport);
        System.out.println("The toAirport was " + toAirport);
        return "index";
    }

    public String prepareConfirmView() {
      //  calculateSelectedRoute();
        return "confirmflight";
    }

    /**
     * Creates a new instance of RoutesController
     */
    public SearchController() {
        helper = new BookingHelper();
        airports = helper.getAirports();

    }

}
