import jakarta.persistence.*;

/**
 * Représente un livretA, un type de compte d'épargne contenant un taux de livret A
 * Hérite de la classe Compte
 */
@Entity
@Table(name="livret_a")
@DiscriminatorValue("L")
public class LivretA extends Compte{

    @Column(name="taux_livretA", nullable = false)
    private double taux;

    public LivretA(){}

    public LivretA(double taux) {
        this.taux = taux;
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "taux=" + taux +
                '}';
    }
}
