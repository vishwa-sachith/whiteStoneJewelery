package Pojos;
// Generated Jun 16, 2018 10:23:44 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product  implements java.io.Serializable {


     private Integer id;
     private Material material;
     private Purity purity;
     private Type type;
     private Weight weight;
     private String name;
     private Integer cost;
     private Integer price;
     private Integer discount;
     private Date astimatedDate;
     private Date dateCreated;
     private Integer count;
     private String description;
     private String status;
     private Set<Img> imgs = new HashSet<Img>(0);
     private Set<ProductHasStone> productHasStones = new HashSet<ProductHasStone>(0);
     private Set<CartHasProduct> cartHasProducts = new HashSet<CartHasProduct>(0);
     private Set<InvoiceHasProduct> invoiceHasProducts = new HashSet<InvoiceHasProduct>(0);
     private Set<Watchlist> watchlists = new HashSet<Watchlist>(0);

    public Product() {
    }

	
    public Product(Material material, Purity purity, Type type, Weight weight) {
        this.material = material;
        this.purity = purity;
        this.type = type;
        this.weight = weight;
    }
    public Product(Material material, Purity purity, Type type, Weight weight, String name, Integer cost, Integer price, Integer discount, Date astimatedDate, Date dateCreated, Integer count, String description, String status, Set<Img> imgs, Set<ProductHasStone> productHasStones, Set<CartHasProduct> cartHasProducts, Set<InvoiceHasProduct> invoiceHasProducts, Set<Watchlist> watchlists) {
       this.material = material;
       this.purity = purity;
       this.type = type;
       this.weight = weight;
       this.name = name;
       this.cost = cost;
       this.price = price;
       this.discount = discount;
       this.astimatedDate = astimatedDate;
       this.dateCreated = dateCreated;
       this.count = count;
       this.description = description;
       this.status = status;
       this.imgs = imgs;
       this.productHasStones = productHasStones;
       this.cartHasProducts = cartHasProducts;
       this.invoiceHasProducts = invoiceHasProducts;
       this.watchlists = watchlists;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Material getMaterial() {
        return this.material;
    }
    
    public void setMaterial(Material material) {
        this.material = material;
    }
    public Purity getPurity() {
        return this.purity;
    }
    
    public void setPurity(Purity purity) {
        this.purity = purity;
    }
    public Type getType() {
        return this.type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    public Weight getWeight() {
        return this.weight;
    }
    
    public void setWeight(Weight weight) {
        this.weight = weight;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Integer getCost() {
        return this.cost;
    }
    
    public void setCost(Integer cost) {
        this.cost = cost;
    }
    public Integer getPrice() {
        return this.price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
    public Date getAstimatedDate() {
        return this.astimatedDate;
    }
    
    public void setAstimatedDate(Date astimatedDate) {
        this.astimatedDate = astimatedDate;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer count) {
        this.count = count;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public Set<Img> getImgs() {
        return this.imgs;
    }
    
    public void setImgs(Set<Img> imgs) {
        this.imgs = imgs;
    }
    public Set<ProductHasStone> getProductHasStones() {
        return this.productHasStones;
    }
    
    public void setProductHasStones(Set<ProductHasStone> productHasStones) {
        this.productHasStones = productHasStones;
    }
    public Set<CartHasProduct> getCartHasProducts() {
        return this.cartHasProducts;
    }
    
    public void setCartHasProducts(Set<CartHasProduct> cartHasProducts) {
        this.cartHasProducts = cartHasProducts;
    }
    public Set<InvoiceHasProduct> getInvoiceHasProducts() {
        return this.invoiceHasProducts;
    }
    
    public void setInvoiceHasProducts(Set<InvoiceHasProduct> invoiceHasProducts) {
        this.invoiceHasProducts = invoiceHasProducts;
    }
    public Set<Watchlist> getWatchlists() {
        return this.watchlists;
    }
    
    public void setWatchlists(Set<Watchlist> watchlists) {
        this.watchlists = watchlists;
    }




}

