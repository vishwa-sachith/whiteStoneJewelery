package Pojos;
// Generated Jun 16, 2018 10:23:44 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Material generated by hbm2java
 */
public class Material  implements java.io.Serializable {


     private Integer id;
     private String material;
     private Set<Product> products = new HashSet<Product>(0);

    public Material() {
    }

    public Material(String material, Set<Product> products) {
       this.material = material;
       this.products = products;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMaterial() {
        return this.material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    public Set<Product> getProducts() {
        return this.products;
    }
    
    public void setProducts(Set<Product> products) {
        this.products = products;
    }




}


