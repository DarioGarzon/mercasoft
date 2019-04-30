package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.RegularCustomer;
import edu.uan.mercasoft.exceptions.NotFoundCustomer;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.repository.ICustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPACustomerRepositoryImpl implements ICustomerRepository {
    @Override
    public RegularCustomer getCustomerByDocument(String documentNumber) throws NotFoundCustomer {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<RegularCustomerDTO> customQuery = em.createNamedQuery("RegularCustomerDTO.findBydocumentNumber", RegularCustomerDTO.class);
        customQuery.setParameter("documentNumber", documentNumber);
        List<RegularCustomerDTO> foundCustomer= customQuery.setMaxResults(1).getResultList();
        if (foundCustomer == null) {
            throw new NotFoundCustomer();
        }
        return foundCustomer.get(0).convertToCustomer();
    }

    @Override
    public void saveCustomer(RegularCustomer customerToSave) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        RegularCustomerDTO customerDTOToSave = new RegularCustomerDTO(customerToSave);
        em.persist(customerDTOToSave);
        em.getTransaction().commit();
        em.close();
    }
}
