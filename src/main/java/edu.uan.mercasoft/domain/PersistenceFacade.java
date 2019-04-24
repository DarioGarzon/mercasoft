package edu.uan.mercasoft.domain;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.repository.IUserRepository;
import edu.uan.mercasoft.repository.JPAUserRepositoryImpl;

import java.util.List;

public class PersistenceFacade {
    IUserRepository usersRepo;

    public PersistenceFacade() {
        usersRepo=new JPAUserRepositoryImpl();
    }

    public User findUserByUserNameAndPassword(@NotNull String userName, @NotNull String password) throws NotFoundUser, NotMatchingPassword {
        List<User>usersByUserName= usersRepo.getUsersByUserName(userName);
        if(usersByUserName.size()>1){
            throw  new NotFoundUser();
        }
        else{
            for (User foundUser:usersByUserName) {
                return foundUser;
            }
            throw new NotMatchingPassword();
        }
    }
}
