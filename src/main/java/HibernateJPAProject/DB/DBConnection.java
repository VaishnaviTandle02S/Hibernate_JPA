package HibernateJPAProject.DB;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConnection {
    public static EntityManagerFactory getEntryManagerFactory(){

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction t = em.getTransaction();

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("myPersistenceUnit");
        return emf;
    }
}
