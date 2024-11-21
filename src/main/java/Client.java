import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Représente un client avec un nom, un prénom, une date de naissance et une adresse.
 */
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nom", length = 30, nullable = false,unique = true)
    private String nom;

    @Column(name="prenom", length = 30, nullable = false)
    private String prenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Embedded
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="banque_id")
    private Banque banque;

    @ManyToMany
    @JoinTable(name="Compte_client",
            joinColumns= @JoinColumn(name="client_id", referencedColumnName= "id"),
            inverseJoinColumns= @JoinColumn(name="compte_id", referencedColumnName="id")
    )
    private List<Compte> comptes = new ArrayList<>();

    public List<Compte> getComptes() {
        return comptes;
    }

    public Client(){}

    public Client(String nom, String prenom, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Client(String nom, String prenom, Date dateNaissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }


    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", adresse=" + adresse +
                ", banque=" + banque +
                ", comptes=" + comptes +
                '}';
    }
}
