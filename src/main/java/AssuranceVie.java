import jakarta.persistence.*;

import java.util.Date;

/**
 * Représente un compte d'assurance vie contenant une date de fin d'assurance et un taux
 * Hérite de la classe Compte
 */
@Entity
public class AssuranceVie extends Compte{

    @Temporal(TemporalType.DATE)
    @Column(name="date_fin")
    private Date dateFin;

    @Column(name="taux_assurance", nullable = false)
    private double taux;

    public AssuranceVie(){}

    public AssuranceVie(Date dateFin, double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie(String numero, double solde, Date dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                "dateFin=" + dateFin +
                ", taux=" + taux +
                '}';
    }
}
