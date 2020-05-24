/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ASUS
 */
public class AddToTableObject implements java.io.Serializable {

    private String stoneid;
    private String details;
    private String weight;
    private String weightmesuid;
    private String weightmesu;
    private String purityid;
    private String puritydeta;
    private String count;

    public AddToTableObject() {
    }

    public String getStoneid() {
        return stoneid;
    }

    public void setStoneid(String stoneid) {
        this.stoneid = stoneid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightmesuid() {
        return weightmesuid;
    }

    public void setWeightmesuid(String weightmesuid) {
        this.weightmesuid = weightmesuid;
    }

    public String getWeightmesu() {
        return weightmesu;
    }

    public void setWeightmesu(String weightmesu) {
        this.weightmesu = weightmesu;
    }

    public String getPurityid() {
        return purityid;
    }

    public void setPurityid(String purityid) {
        this.purityid = purityid;
    }

    public String getPuritydeta() {
        return puritydeta;
    }

    public void setPuritydeta(String puritydeta) {
        this.puritydeta = puritydeta;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

}
