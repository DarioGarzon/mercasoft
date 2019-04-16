package edu.uan.mercasoft.useCases;

import com.sun.istack.internal.NotNull;
import edu.uan.mercasoft.exceptions.NotFoundUser;
import edu.uan.mercasoft.exceptions.NotMatchingPassword;

public interface IAuthenticateInteractor {

    public boolean Authenticate(@NotNull String userName, @NotNull String password) throws NotMatchingPassword, NotFoundUser;
}
