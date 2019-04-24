package edu.uan.mercasoft.domain;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.repository.IUserRepository;
import edu.uan.mercasoft.repository.JPAUserRepositoryImpl;

import java.util.List;

public class PersistenceFacade {
    private IUserRepository usersRepo;

    public PersistenceFacade() {
        usersRepo=new JPAUserRepositoryImpl();
    }

    public User findUserByUserNameAndPassword(@NotNull String userName, @NotNull String password) throws NotFoundUser, NotMatchingPassword {
        User foundUser= usersRepo.getUserByUserName(userName);
        if(!foundUser.getPassword().equals(password)){
                throw new NotMatchingPassword();
        }
        return foundUser;
    }

}
