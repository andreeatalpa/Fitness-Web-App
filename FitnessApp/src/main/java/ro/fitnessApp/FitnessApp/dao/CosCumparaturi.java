package ro.fitnessApp.FitnessApp.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CosCumparaturi")
public class CosCumparaturi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer clientiId;
    private int quantity;
    private double valoareCos;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "comanda_id")
    private List<Comenzi> comenzis;

    public double getValoareCos() {
        return valoareCos;
    }

    public void setValoareCos(double valoareCos) {
        this.valoareCos = valoareCos;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientiId() {
        return clientiId;
    }

    public void setClientiId(Integer clientiId) {
        this.clientiId = clientiId;
    }

    public List<Comenzi> getComenzis() {
        return comenzis;
    }

    public void setComenzis(List<Comenzi> comenzis) {
        this.comenzis = comenzis;
    }
}
