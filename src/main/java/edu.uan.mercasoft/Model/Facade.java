package edu.uan.mercasoft.Model;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.Repository.IUserRepository;
import edu.uan.mercasoft.Repository.SQLUserRepositoryImpl;

import java.util.List;

public class Facade {
    IUserRepository usersRepo;

    public Facade() {
        usersRepo=new SQLUserRepositoryImpl();
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
