package yuown.dabba.data.realm;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

/**
 * Created by kiran.nk on 9/8/2016.
 */
@RealmClass
public class ItemRM extends RealmObject {

    @PrimaryKey
    @Index
    private Integer id;

    @Required
    private String name;

    private String weight;

    private String price;

    private Integer purity;

    private Date date;

    private String cost;

    public ItemRM() {
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
