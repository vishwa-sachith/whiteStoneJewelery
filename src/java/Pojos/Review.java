package Pojos;
// Generated Jun 16, 2018 10:23:44 PM by Hibernate Tools 4.3.1



/**
 * Review generated by hbm2java
 */
public class Review  implements java.io.Serializable {


     private Integer id;
     private User user;
     private String review;

    public Review() {
    }

	
    public Review(User user) {
        this.user = user;
    }
    public Review(User user, String review) {
       this.user = user;
       this.review = review;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getReview() {
        return this.review;
    }
    
    public void setReview(String review) {
        this.review = review;
    }




}


