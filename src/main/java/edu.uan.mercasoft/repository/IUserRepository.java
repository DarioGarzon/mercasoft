package edu.uan.mercasoft.repository;

import edu.uan.mercasoft.domain.User;

import java.util.List;

public interface IUserRepository {

    List<User> getUsersByUserName(String UserName);
}
