import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="banque")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Client> clients = new ArrayList<>();

    public Banque(){}

    public Banque(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", clients=" + clients +
                '}';
    }
}
