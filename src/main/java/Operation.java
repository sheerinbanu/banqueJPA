import jakarta.persistence.*;

import java.util.Date;

/**
 * Représente une opération bancaire avec une date d'opération, un montant et un motif
 * Elle est lié à la classe Compte par une relation ManyToOne (un compte peut contenir zéro à plusieurs opérations)
 */
@Entity
@Table(name="operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name="date")
    private Date date;

    @Column(name="montant", nullable = false)
    private double montant;

    @Column(name="motif", nullable = false, length = 255)
    private String motif;

    @ManyToOne
    @JoinColumn(name="compte_id")
    private Compte compte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Operation(){}

    public Operation(Date date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", compte=" + compte +
                '}';
    }
}
