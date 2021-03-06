package flightbooking;
// Generated 13-Nov-2013 10:44:05 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Airline generated by hbm2java
 */
public class Airline  implements java.io.Serializable {


     private int id;
     private String name;
     private String country;
     private Set<Route> routes = new HashSet<Route>(0);

    public Airline() {
    }

	
    public Airline(int id) {
        this.id = id;
    }
    public Airline(int id, String name, String country, Set<Route> routes) {
       this.id = id;
       this.name = name;
       this.country = country;
       this.routes = routes;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    public Set<Route> getRoutes() {
        return this.routes;
    }
    
    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

     @Override
    public String toString(){
        
        return this.name;
    }


}


