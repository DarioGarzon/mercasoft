package edu.uan.mercasoft.domain;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.exceptions.NotFoundProduct;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.repository.IProductRepository;
import edu.uan.mercasoft.repository.IUserRepository;
import edu.uan.mercasoft.repository.JPAImpl.JPAProductRepositoryImpl;
import edu.uan.mercasoft.repository.JPAImpl.JPAUserRepositoryImpl;

public class PersistenceFacade {
    private IUserRepository usersRepo;
    private IProductRepository productRepo;

    public PersistenceFacade() {

        usersRepo=new JPAUserRepositoryImpl();
        productRepo= new JPAProductRepositoryImpl();
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

}
