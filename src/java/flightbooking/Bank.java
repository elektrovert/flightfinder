package flightbooking;
// Generated 13-Nov-2013 10:44:05 by Hibernate Tools 3.6.0



/**
 * Bank generated by hbm2java
 */
public class Bank  implements java.io.Serializable {


     private int idno;
     private String customername;
     private Integer balance;

    public Bank() {
    }

	
    public Bank(int idno) {
        this.idno = idno;
    }
    public Bank(int idno, String customername, Integer balance) {
       this.idno = idno;
       this.customername = customername;
       this.balance = balance;
    }
   
    public int getIdno() {
        return this.idno;
    }
    
    public void setIdno(int idno) {
        this.idno = idno;
    }
    public String getCustomername() {
        return this.customername;
    }
    
    public void setCustomername(String customername) {
        this.customername = customername;
    }
    public Integer getBalance() {
        return this.balance;
    }
    
    public void setBalance(Integer balance) {
        this.balance = balance;
    }




}

