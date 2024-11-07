import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numero;

    private double solde;


    @ManyToMany
    @JoinTable(name="COMPO",
            joinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName= "ID"),
            inverseJoinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="ID")
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
