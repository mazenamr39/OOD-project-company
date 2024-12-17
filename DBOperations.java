package package2;

import javax.persistence.*;
import java.util.List;

public class DBOperations {

    // Create
    public static void addEmployee(Employee e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void addCompany(Company c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void addRecruitment(Recruitment r) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    // Retrieve
    public static Employee getEmployeeById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Employee e = em.find(Employee.class, id);
        em.close();
        emf.close();
        return e;
    }

    public static Company getCompanyById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Company c = em.find(Company.class, id);
        em.close();
        emf.close();
        return c;
    }

    public static Recruitment getRecruitmentById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Recruitment r = em.find(Recruitment.class, id);
        em.close();
        emf.close();
        return r;
    }

    // Update
    public static void updateEmployee(int id, String newName, String newEmail) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Employee e = em.find(Employee.class, id);
        if (e != null) {
            em.getTransaction().begin();
            e.setName(newName);
            e.setEmail(newEmail);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }

    public static void updateCompany(int id, String newName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Company c = em.find(Company.class, id);
        if (c != null) {
            em.getTransaction().begin();
            c.setName(newName);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }

    // Delete
    public static void deleteEmployee(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Employee e = em.find(Employee.class, id);
        if (e != null) {
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }

    public static void deleteCompany(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Company c = em.find(Company.class, id);
        if (c != null) {
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }

    public static void deleteRecruitment(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb/db/odbtest.odb");
        EntityManager em = emf.createEntityManager();
        Recruitment r = em.find(Recruitment.class, id);
        if (r != null) {
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
}