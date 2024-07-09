package org.school.assignment3.dao;

import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Repository
public class DBConnect implements DBSource {
    //這邊要寫的是對資料庫的邏輯，比如說連線、關閉連線、增刪改查等等
    private final String url;
    private final String username;
    private final String password;

    public DBConnect() throws IOException, ClassNotFoundException {
        this("src/main/resources/properties/jdbc.properties");
    }

    public DBConnect(String configFile) throws IOException, ClassNotFoundException {
        Properties props = new Properties();
        props.load(new FileInputStream(configFile));

        url = props.getProperty("Assignment-3.jdbc.url");
        username = props.getProperty("Assignment-3.jdbc.username");
        password = props.getProperty("Assignment-3.jdbc.password");
        Class.forName(props.getProperty("Assignment-3.jdbc.driver"));
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    public ArrayList<String> findAll() {
        try {
            ArrayList<String> queryResult = new ArrayList<>();
            Connection connection = openConnection();
            Statement stat = connection.createStatement();
            ResultSet result = stat.executeQuery("select * from user");
            while (result.next()) {
                queryResult.add(
                        result.getInt(1) +
                                result.getString(2) +
                                result.getString(3));
            }
            closeConnection(connection);
            result.close();
            return queryResult;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(String email, String password) {
        String user = "insert into user(email,password) values (?,?)";
        try {
            Connection connection = openConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(user);

            prepareStatement.setString(1,email);
            prepareStatement.setString(2,password);

            int count = prepareStatement.executeUpdate();
            System.out.println("成功插入" + count + "筆資料!");
            closeConnection(connection);
            prepareStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
