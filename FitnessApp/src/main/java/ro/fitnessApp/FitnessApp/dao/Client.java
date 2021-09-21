package ro.fitnessApp.FitnessApp.dao;


import javax.persistence.*;

@Entity
@Table(name = "clienti")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String parola;
    private String nume;
    private int id_tipabonament;

    public int getId_tipabonament() {
        return id_tipabonament;
    }

    public void setId_tipabonament(int id_tipabonament) {
        this.id_tipabonament = id_tipabonament;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
