package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.Permission;
import edu.uan.mercasoft.domain.Role;
import edu.uan.mercasoft.domain.User;
import edu.uan.mercasoft.exceptions.NotFoundUser;


public interface IUserRepository {

    User getUserByUserName(String UserName) throws NotFoundUser;
    void savePermission(Permission permissionToSave);
    void saveRole(Role roleToSave);
    void saveUser(User userToSave);
}
