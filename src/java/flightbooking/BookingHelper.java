/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightbooking;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Paul Mallon
 */
public class BookingHelper {
    
    Session session = null;
    
    public BookingHelper(){
        
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List getAirportCities() {
    List<Airport> cityList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("Select distinct A.city from Airport A Order By A.city ASC");
        cityList = (List<Airport>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return cityList;
}
    public List getAirportCountries() {
    List<Airport> countryList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("Select distinct A.country from Airport A Order By A.country ASC");
        countryList = (List<Airport>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return countryList;
}
    
    public List getRoutes(int fromId, int toId) {
//    String queryString = "SELECT R.airline FROM  Route R WHERE R.fromId = \"" + fromId + "\" AND R.toId = \""+ toId +"\"  ORDER BY R.airlineId ASC";
    String queryString = "FROM  Route R WHERE R.fromId =\"" + fromId + "\" AND R.toId = \""+ toId +"\" ORDER BY R.price ASC";
//    String queryString = "SELECT R.airline,  R.price  FROM  Route R WHERE R.fromId =\"" + fromId + "\" AND R.toId = \""+ toId +"\" ORDER BY R.price ASC";
    List<Route> routeList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery (queryString);
        routeList = (List<Route>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
//    for(Route r : routeList){
//    System.out.println(r.getAirline().getName() + ", " + r.getPrice());
//    }
    return routeList;
}
    public List<Airport> getAirports(String city) {
    String queryString = "FROM  Airport A WHERE A.city = \"" + city + "\" ORDER BY A.name ASC";
    List<Airport> airportList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery (queryString);
        airportList = (List<Airport>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return airportList;
}
    public List<Airport> getAirports() {
    String queryString = "FROM  Airport A";
    List<Airport> airportList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery (queryString);
        airportList = (List<Airport>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return airportList;
}
}
