package org.school.assignment3.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DBSource {
    Connection openConnection() throws SQLException;
    void closeConnection(Connection con) throws SQLException;
//    String findByEmail(String email);
//    String findByPassword(String password);
    ArrayList<String> findAll();
    void createUser(String email, String password);
}
