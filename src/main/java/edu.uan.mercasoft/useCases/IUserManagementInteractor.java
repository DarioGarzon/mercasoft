package edu.uan.mercasoft.useCases;

import edu.uan.mercasoft.domain.Permission;
import edu.uan.mercasoft.domain.Role;
import edu.uan.mercasoft.domain.User;

public interface IUserManagementInteractor {
    void savePermission(Permission addProduct);
    void saveRole(Role roleToAdd);
    void saveUser(User userToAdd);
}
