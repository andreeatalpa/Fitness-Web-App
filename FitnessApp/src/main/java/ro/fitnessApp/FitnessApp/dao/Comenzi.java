package ro.fitnessApp.FitnessApp.dao;
import javax.persistence.*;

@Entity
@Table
public class Comenzi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "comanda_id")
    private CosCumparaturi cosCumparaturi;
    private int prductId;
    private int quantity;
    private int price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CosCumparaturi getCosCumparaturi() {
        return cosCumparaturi;
    }

    public void setCosCumparaturi(CosCumparaturi cosCumparaturi) {
        this.cosCumparaturi = cosCumparaturi;
    }

    public int getPrductId() {
        return prductId;
    }

    public void setPrductId(int prductId) {
        this.prductId = prductId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
