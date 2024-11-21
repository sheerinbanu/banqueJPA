import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une banque avec un nom et une liste de clients
 * Elle est relié a la classe Client par une relation OneToMany( une banque contient 1 à plusieurs clients)
 */
@Entity
@Table(name="banque")
public class Banque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nom", length = 30, nullable = false,unique = true)
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
