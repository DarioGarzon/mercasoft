package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.Permission;
import edu.uan.mercasoft.domain.PersistenceFacade;
import edu.uan.mercasoft.domain.Role;
import edu.uan.mercasoft.domain.User;

public class UserManagementInteractorImpl implements IUserManagementInteractor {
    private PersistenceFacade persistenceFacade;
    public UserManagementInteractorImpl() {
        persistenceFacade= new PersistenceFacade();

    }

    @Override
    public void savePermission(Permission permissionToAdd) {
        persistenceFacade.savePermission(permissionToAdd);
    }

    @Override
    public void saveRole(Role roleToAdd) {
        persistenceFacade.saveRole(roleToAdd);
    }

    @Override
    public void saveUser(User userToAdd) {
        persistenceFacade.saveUser(userToAdd);
    }
}
