package edu.uan.mercasoft.repository.JPAImpl;

import edu.uan.mercasoft.domain.Product;
import edu.uan.mercasoft.domain.ProductType;
import edu.uan.mercasoft.domain.Supplier;
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
        if (foundProduct.size()<1) {
            throw new NotFoundProduct();
        }
        return foundProduct.get(0).convertToProduct();
    }

    @Override
    public void saveProduct(Product product) {
        //saveProductType(product.getProductType());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductTypeDTO productTypeToSave = new ProductTypeDTO(product.getProductType());
        SupplierDTO supToSave = new SupplierDTO(product.getSupplier());
        ProductDTO productToSave = new ProductDTO(product);
        productToSave.setProductType(productTypeToSave);
        productToSave.setSupplier(supToSave);
        em.merge(productTypeToSave);
        em.merge(supToSave);
        em.merge(productToSave);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateProduct(Product productToUpdate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ProductTypeDTO productTypeToSave = new ProductTypeDTO(productToUpdate.getProductType());
        SupplierDTO supToSave = new SupplierDTO(productToUpdate.getSupplier());
        ProductDTO productToSave = new ProductDTO(productToUpdate);
        productToSave.setProductType(productTypeToSave);
        productToSave.setSupplier(supToSave);
        em.merge(productTypeToSave);
        em.merge(supToSave);
        em.merge(productToSave);
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

    @Override
    public void saveSupplier(Supplier supplierToSave) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        SupplierDTO supToSave = new SupplierDTO(supplierToSave);
        em. persist(supToSave);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void saveProductType(ProductType productType) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
    }


}
