package yuown.dabba.data.model;

import java.util.Date;

/**
 * Created by kiran.nk on 9/8/2016.
 */
public class ItemDM {

    private Integer id;

    private String name;

    private String weight;

    private String price;

    private Integer purity;

    private Date date;

    private String cost;

    public ItemDM() {
        date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getPurity() {
        return purity;
    }

    public void setPurity(Integer purity) {
        this.purity = purity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
