package Pojos;
// Generated Jun 16, 2018 10:23:44 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Watchlist generated by hbm2java
 */
public class Watchlist  implements java.io.Serializable {


     private Integer idWatchlist;
     private Product product;
     private User user;
     private Date dateadded;

    public Watchlist() {
    }

	
    public Watchlist(Product product, User user) {
        this.product = product;
        this.user = user;
    }
    public Watchlist(Product product, User user, Date dateadded) {
       this.product = product;
       this.user = user;
       this.dateadded = dateadded;
    }
   
    public Integer getIdWatchlist() {
        return this.idWatchlist;
    }
    
    public void setIdWatchlist(Integer idWatchlist) {
        this.idWatchlist = idWatchlist;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Date getDateadded() {
        return this.dateadded;
    }
    
    public void setDateadded(Date dateadded) {
        this.dateadded = dateadded;
    }




}


