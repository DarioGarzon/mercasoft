package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.repository.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class JPAProductRepositoryImpl implements IProductRepository {
    @Override
    public Product getActualProduct(String productCode) throws NotFoundProduct {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<ProductDTO> customQuery = em.createNamedQuery("ProductDTO.findByCode", ProductDTO.class);
        customQuery.setParameter("productCode", productCode);
        List<ProductDTO> foundProduct = customQuery.setMaxResults(1).getResultList();
        if (foundProduct == null) {
            throw new NotFoundProduct();
        }
        return foundProduct.get(0).convertToProduct();
    }

    @Override
    public void saveProduct(Product product) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductDTO productToSave = new ProductDTO(product);
        em.persist(productToSave);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateProduct(Product productToUpdate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(productToUpdate);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Product> getProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<ProductDTO> customQuery = em.createNamedQuery("ProductDTO.findByCode", ProductDTO.class);
        List<ProductDTO> foundProducts = customQuery.getResultList();
        List<Product> products=new ArrayList<>();
        foundProducts.forEach(it->products.add(it.convertToProduct()));
        return products;
    }


}
