package org.school.assignment3.dao;


import org.school.assignment3.utils.BCryptUtil;
import org.school.assignment3.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private final String url;
    private final String username;
    private final String password;

    public UserDaoImpl() throws IOException {
        this("src/main/resources/properties/jdbc.properties");
    }

    public UserDaoImpl(String configFile) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(configFile));

        url = props.getProperty("Assignment-3.jdbc.url");
        username = props.getProperty("Assignment-3.jdbc.username");
        password = props.getProperty("Assignment-3.jdbc.password");
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


    @Override
    public void insertUser(String email, String password) {
        String sql = "insert into user(email,password) values (?,?)";
        // java try with resource will automatically close the resource.
        try (Connection connection = openConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, email);
            prepareStatement.setString(2, password);

            prepareStatement.executeUpdate();
            logger.info("User created with email: " + email);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to create user with email: " + email, e);
        }
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ?";
        try (Connection connection = openConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, email);
            ResultSet result = prepareStatement.executeQuery();

            if (result.next()) {
                String storedHash = result.getString("password");
                if (BCryptUtil.verifyPassword(password, storedHash)) {
                    return createUserFromResult(result);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find user with email: " + email, e);
        }
        return null;
    }

    @Override
    public boolean isEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM user WHERE email = ?";
        try (Connection connection = openConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            prepareStatement.setString(1, email);
            ResultSet result = prepareStatement.executeQuery();
            if (result.next()) {
                int count = result.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return false;
    }

    private User createUserFromResult(ResultSet result) throws SQLException {
        User user = new User();
        user.setId(result.getInt("id"));
        user.setEmail(result.getString("email"));
        user.setPassword(result.getString("password"));
        return user;
    }
}
