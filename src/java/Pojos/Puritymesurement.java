package Pojos;
// Generated Jun 16, 2018 10:23:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Puritymesurement generated by hbm2java
 */
public class Puritymesurement  implements java.io.Serializable {


     private Integer id;
     private String purityMesurement;
     private Set<Purity> purities = new HashSet<Purity>(0);

    public Puritymesurement() {
    }

    public Puritymesurement(String purityMesurement, Set<Purity> purities) {
       this.purityMesurement = purityMesurement;
       this.purities = purities;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPurityMesurement() {
        return this.purityMesurement;
    }
    
    public void setPurityMesurement(String purityMesurement) {
        this.purityMesurement = purityMesurement;
    }
    public Set<Purity> getPurities() {
        return this.purities;
    }
    
    public void setPurities(Set<Purity> purities) {
        this.purities = purities;
    }




}

