package edu.uan.mercasoft.Repository;

import edu.uan.mercasoft.Model.User;

import java.util.List;

public interface IUserRepository {

    List<User> getUsersByUserName(String UserName);
}
