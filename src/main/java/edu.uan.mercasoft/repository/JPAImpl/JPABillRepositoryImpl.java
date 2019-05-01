package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Bill;
import edu.uan.mercasoft.domain.BillDetail;
import edu.uan.mercasoft.repository.IBillRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JPABillRepositoryImpl implements IBillRepository {
    @Override
    public void saveTransaction(Bill billToSave) {
        for (BillDetail detail:billToSave.getDetailList()) {
            saveDetail(detail);
        }
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(new BillDTO(billToSave));
        em.getTransaction().commit();
        em.close();
    }


    public void saveDetail(BillDetail billToSave) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(new BillDetailDTO((billToSave)));
        em.getTransaction().commit();
        em.close();
    }



    @Override
    public List<Bill> getBills() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<BillDTO> customQuery = em.createNamedQuery("BillDTO.findAll", BillDTO.class);
        List<BillDTO> foundBills = customQuery.getResultList();
        List<Bill> bills=new ArrayList<>();
        foundBills.forEach(it->bills.add(it.convertToBill()));
        return bills;
    }
}
