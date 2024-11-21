import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


public class ConnexionBanque {
    public static void main(String[] args) throws ParseException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        //Création des instances de banque
        Banque b1 = new Banque("CA");
        Banque b2 = new Banque("CL");
        em.persist(b1);
        em.persist(b2);

        //List<Client> clients = List.of(new Client("Dupont", "Marie", new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01")));

        //Création des clients
        Client c1 =    new Client("Bernard", "Luc", new SimpleDateFormat("yyyy-MM-dd").parse("1985-02-15"),new Adresse(2,"Jules Auffret", 93000,"Bobigny" ));
        c1.setBanque(b1);
        Client c2 =    new Client("Petit", "Aline", new SimpleDateFormat("yyyy-MM-dd").parse("1993-04-30"), new Adresse(12,"Roger Salandro", 75000,"Paris" ));
        c2.setBanque(b2);
        Client c3 =    new Client("Dupont", "Marie", new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01"), new Adresse(15,"Avenue Jaures", 95000,"Tremblay-en-France" ));
        c3.setBanque(b1);

        //Insertion des clients dans la bdd
        em.persist(c1);
        em.persist(c2);
        em.persist(c3);

        //Création du  LivreatA et insertion dans la bdd
        LivretA liv1 = new LivretA("FR000055", 1000.88, 0.25);
        em.persist(liv1);
        //Ajout du LivretA dans le compte c1
        c1.getComptes().add(liv1);

        LivretA liv2 = new LivretA("FR000069", 5600.88, 0.75);
        em.persist(liv2);
        c2.getComptes().add(liv2);

        //Création d'un virement
        Virement v1 = new Virement(new Date(),2300,"vacances", "Dupont");
        //Insertion du virement dans la bdd
        em.persist(v1);

        Virement v2 = new Virement(new Date(), 1666, "retraite", "Bernard");
        em.persist(v2);

        //Création d'une assurance vie et sa persistance dans la bdd
        AssuranceVie a1 = new AssuranceVie("FR000055", 3455, new Date(), 2.6);
        em.persist(a1);
        et.commit();
        em.close();
   }
}
