import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Représente un compte bancaire avec un numéro, solde, une liste de clients et une liste d'opérations
 * et est la classe mère de la classe Assurance Vie et de la classe LivretA
 */
@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero", nullable = false, unique = true, length = 20)
    private String numero;

    @Column(name="solde", nullable = false)
    private double solde;

    @ManyToMany
    @JoinTable(name="compte_client",
            joinColumns= @JoinColumn(name="compte_id", referencedColumnName= "id"),
            inverseJoinColumns= @JoinColumn(name="client_id", referencedColumnName="id")
    )
    private List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "compte")
    private List<Operation> operations = new ArrayList<>();

    public Compte(){

    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }


    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", clients=" + clients +
                ", operation=" + operations +
                '}';
    }
}
