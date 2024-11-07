import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConnexionBanque {
    public static void main(String[] args) throws ParseException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        Banque b1 = new Banque("CA");
        Banque b2 = new Banque("CL");
        em.persist(b1);
        em.persist(b2);
        //List<Client> clients = List.of(new Client("Dupont", "Marie", new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01")));

        Client c1 =    new Client("Bernard", "Luc", new SimpleDateFormat("yyyy-MM-dd").parse("1985-02-15"));
        c1.setBanque(b1);
        c1.setAdresse(new Adresse(2,"Jules Auffret", 93000,"Bobigny" ));
        Client c2 =    new Client("Petit", "Aline", new SimpleDateFormat("yyyy-MM-dd").parse("1993-04-30"));
        c2.setBanque(b2);
        c2.setAdresse(new Adresse(12,"Roger Salandro", 75000,"Paris" ));
        Client c3 =    new Client("Dupont", "Marie", new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"));
        c3.setBanque(b1);
        c3.setAdresse(new Adresse(15,"Avenue Jaures", 95000,"Tremblay-en-France" ));

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);

        LivretA liv1 = new LivretA("FR000055", 1000.88, 0.25);
        em.persist(liv1);
        c1.getComptes().add(liv1);

        LivretA liv2 = new LivretA("FR000069", 5600.88, 0.75);
        em.persist(liv2);
        c2.getComptes().add(liv2);


        Virement v1 = new Virement(new Date(),2300,"vacances", "Dupont");
        v1.setCompte(liv1);
        em.persist(v1);


        et.commit();
        em.close();
   }
}
