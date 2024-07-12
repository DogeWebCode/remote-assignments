package org.school.assignment3.dao;

import org.school.assignment3.model.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    Connection openConnection() throws SQLException;
    boolean isEmailExists(String email);
    User findUserByEmailAndPassword(String email, String password);
    void insertUser(String email, String password);
}
