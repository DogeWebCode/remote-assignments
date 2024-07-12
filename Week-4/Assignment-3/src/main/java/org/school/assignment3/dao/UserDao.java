package org.school.assignment3.dao;

import org.school.assignment3.model.User;

public interface UserDao {
    boolean isEmailExists(String email);
    User findUserByEmailAndPassword(String email, String password);
    void insertUser(String email, String password);
}
