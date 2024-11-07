import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="assurance_vie")
public class AssuranceVie extends Compte{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_fin")
    private Date dateFin;
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
}
