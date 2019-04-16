package edu.uan.mercasoft.useCases;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.controllers.LoginController;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.Model.Facade;
import edu.uan.mercasoft.Model.User;
import edu.uan.mercasoft.Session;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AuthenticateInteractorImpl implements  IAuthenticateInteractor{
    LoginController controller;
    Facade facade;

    public AuthenticateInteractorImpl(LoginController loginController) {
        controller=loginController;
        facade= new Facade();
    }

    public boolean Authenticate(@NotNull String userName,@NotNull String password) throws NotMatchingPassword, NotFoundUser {
        User authenticatedUser=facade.findUserByUserNameAndPassword(userName,hashPasswordSaltPepper(password,"Merca","Soft"));
        Session.getInstance().setActualUser(authenticatedUser);
        controller.GoToApp();
        return true;
    }

    private String hashPassword(@NotNull String passwordToHash){
        throw  new NotImplementedException();
    }

    private String hashPasswordSaltPepper(@NotNull String passwordToHash,@NotNull String salt,@NotNull String pepper){
        String constructedPassword=salt+passwordToHash+pepper;
        return hashPassword(constructedPassword);
    }


}
