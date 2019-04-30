package edu.uan.mercasoft.domain;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.exceptions.NotFoundCustomer;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.repository.*;
import edu.uan.mercasoft.repository.JPAImpl.JPABillRepositoryImpl;
import edu.uan.mercasoft.repository.JPAImpl.JPACustomerRepositoryImpl;
import edu.uan.mercasoft.repository.JPAImpl.JPAProductRepositoryImpl;
import edu.uan.mercasoft.repository.JPAImpl.JPAUserRepositoryImpl;

import java.util.List;

public class PersistenceFacade {
    private IUserRepository usersRepo;
    private IProductRepository productRepo;
    private ICustomerRepository customerRepo;
    private IBillRepository billRepo;


    public PersistenceFacade() {
        usersRepo=new JPAUserRepositoryImpl();
        productRepo= new JPAProductRepositoryImpl();
        customerRepo= new JPACustomerRepositoryImpl();
        billRepo= new JPABillRepositoryImpl();
    }

    public User findUserByUserNameAndPassword(@NotNull String userName, @NotNull String password) throws NotFoundUser, NotMatchingPassword {
        User foundUser= usersRepo.getUserByUserName(userName);
        if(!foundUser.getPassword().equals(password)){
                throw new NotMatchingPassword();
        }
        return foundUser;
    }

    public Product getActualProduct(String productCode) throws NotFoundProduct {
        return productRepo.getActualProduct(productCode);
    }


    public RegularCustomer findCustomerByDocument(String documentNumber) throws NotFoundCustomer {
        return  customerRepo.getCustomerByDocument(documentNumber);
    }


    public void updateStock(Product productToUpdate) {
        productRepo.updateProduct(productToUpdate);
    }


    public void saveTransaction(Bill actualTransaction) {
        billRepo.saveTransaction(actualTransaction);
    }

    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    public void savePermission(Permission permissionToAdd) {
        usersRepo.savePermission(permissionToAdd);
    }

    public void saveRole(Role roleToAdd) {
        usersRepo.saveRole(roleToAdd);
    }

    public void saveUser(User userToAdd) {
        usersRepo.saveUser(userToAdd);
    }

    public void saveSupplier(Supplier supplierToAdd){
        productRepo.saveSupplier(supplierToAdd);
    }

    public void saveProductType(ProductType productType) {
        productRepo.saveProductType(productType);
    }

    public void saveProduct(Product productToLoad) {
        productRepo.saveProduct(productToLoad);
    }

    public void saveRegularCustomer(RegularCustomer customerToAdd) {
        customerRepo.saveCustomer(customerToAdd);
    }
}
