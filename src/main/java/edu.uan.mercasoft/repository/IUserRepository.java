package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.User;
import edu.uan.mercasoft.exceptions.NotFoundUser;


public interface IUserRepository {

    User getUserByUserName(String UserName) throws NotFoundUser;


}
