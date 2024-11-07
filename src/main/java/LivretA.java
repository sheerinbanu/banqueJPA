import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="livret_a")
public class LivretA extends Compte{

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
