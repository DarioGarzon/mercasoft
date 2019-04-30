package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Bill;
import edu.uan.mercasoft.repository.IBillRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPABillRepositoryImpl implements IBillRepository {
    @Override
    public void saveTransaction(Bill billToSave) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new BillDTO(billToSave));
        em.getTransaction().commit();
        em.close();
    }
}
