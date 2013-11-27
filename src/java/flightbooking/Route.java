package flightbooking;
// Generated 13-Nov-2013 10:44:05 by Hibernate Tools 3.6.0



/**
 * Route generated by hbm2java
 */
public class Route  implements java.io.Serializable {


     private int id;
     private Airline airline;
     private String code;
     private String airlineId;
     private String fromIata;
     private String fromId;
     private String toIata;
     private String toId;
     private String planeTypes;
     private int price;

    public Route() {
    }

	
    public Route(int id, String fromIata, String toIata, int price) {
        this.id = id;
        this.fromIata = fromIata;
        this.toIata = toIata;
        this.price = price;
    }
    public Route(int id, Airline airline, String code, String airlineId, String fromIata, String fromId, String toIata, String toId, String planeTypes, int price) {
       this.id = id;
       this.airline = airline;
       this.code = code;
       this.airlineId = airlineId;
       this.fromIata = fromIata;
       this.fromId = fromId;
       this.toIata = toIata;
       this.toId = toId;
       this.planeTypes = planeTypes;
       this.price = price;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Airline getAirline() {
        return this.airline;
    }
    
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getAirlineId() {
        return this.airlineId;
    }
    
    public void setAirlineId(String airlineId) {
        this.airlineId = airlineId;
    }
    public String getFromIata() {
        return this.fromIata;
    }
    
    public void setFromIata(String fromIata) {
        this.fromIata = fromIata;
    }
    public String getFromId() {
        return this.fromId;
    }
    
    public void setFromId(String fromId) {
        this.fromId = fromId;
    }
    public String getToIata() {
        return this.toIata;
    }
    
    public void setToIata(String toIata) {
        this.toIata = toIata;
    }
    public String getToId() {
        return this.toId;
    }
    
    public void setToId(String toId) {
        this.toId = toId;
    }
    public String getPlaneTypes() {
        return this.planeTypes;
    }
    
    public void setPlaneTypes(String planeTypes) {
        this.planeTypes = planeTypes;
    }
    public int getPrice() {
        return this.price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getDetails(){
        String details = airline.getName() + ": €" + price;
        return details;
        
    }

    @Override
    public String toString(){
        System.out.println("The ROUTE toString method was called!");
        return airline.getName() + " : From: " + fromIata + "; To: " + toIata + "; Price: €" + price;
    }

}


