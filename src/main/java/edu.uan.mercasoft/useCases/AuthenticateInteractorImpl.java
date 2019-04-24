package edu.uan.mercasoft.useCases;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.controllers.LoginController;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.User;
import edu.uan.mercasoft.Session;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthenticateInteractorImpl implements  IAuthenticateInteractor{
    LoginController controller;
    PersistenceFacade facade;

    public AuthenticateInteractorImpl(LoginController loginController) {
        controller=loginController;
        facade= new PersistenceFacade();
    }

    public boolean Authenticate(@NotNull String userName,@NotNull String password) throws NotMatchingPassword, NotFoundUser {
        User authenticatedUser= null;
        try {
            authenticatedUser = facade.findUserByUserNameAndPassword(userName,hashPasswordSaltPepper(password,"Merca","Soft"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Session.getInstance().setActualUser(authenticatedUser);
        controller.GoToApp();
        return true;
    }

    private String hashPassword(@NotNull String passwordToHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(passwordToHash.getBytes("UTF-8"));
        byte[] hash = digest.digest();
        String result = DatatypeConverter.printHexBinary(hash);
        return result;
    }

    private String hashPasswordSaltPepper(@NotNull String passwordToHash,@NotNull String salt,@NotNull String pepper) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String constructedPassword=salt+passwordToHash+pepper;
        return hashPassword(constructedPassword);
    }


}
