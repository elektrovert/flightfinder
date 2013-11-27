/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.jboss.weld.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Paul Mallon
 */
@ManagedBean
@RequestScoped
public class RoutesController {

    String fromAirport;
    String toAirport;
    String fromIata;
    String toIata;
    String selectedRoute;
    BookingHelper helper;
    List<Route> routes;
    List<Airport> airports;

    public String getSelectedRoute() {
        return selectedRoute;
    }

    public void setSelectedRoute(String selectedRoute) {
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

    public String prepareRoutesView() {
        getRoutes();
        return "index";
    }

    public void onRouteChosen(SelectEvent event){
    
        Route route = (Route) event.getObject();
        
    }
    
    public void chooseRoute(){
     //   RequestContext.getCurrentInstance().openDialog("selectRoute");
       
        
    }
    public List<Route> getRoutes() {
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

        return routes;

    }
    
        public String prepareResultConfirmation(){
        System.out.println("Selected ROUTE: " + selectedRoute);
        return "confirmselection";
    }

    /**
     * Creates a new instance of RoutesController
     */
    public RoutesController() {
        helper = new BookingHelper();
        airports = helper.getAirports();

    }

}
