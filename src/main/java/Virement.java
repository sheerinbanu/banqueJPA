
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.Date;

/**
 * Représente un virement bancaire avec un nom de bénéficiaire
 * Hérite de la classe Opération
 *
 */
@Entity
public class Virement extends Operation{

    @Column(name="beneficiaire", nullable = false)
    private String beneficiaire;

    public Virement(){}

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Virement(Date date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }


}
