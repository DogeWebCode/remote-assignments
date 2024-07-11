package org.school.assignment3.service;

import org.mindrot.jbcrypt.BCrypt;
import org.school.assignment3.dao.UserDao;
import org.school.assignment3.model.User;
import org.school.assignment3.utils.BCyptUtil;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void register(String email, String password) {
        if (!userDao.isEmailExists(email)) {
            String encodePassword = BCyptUtil.encodePassword(password);
            userDao.insertUser(email, encodePassword);
        } else {
            throw new InvalidPropertyException(User.class, "email", "Email already exists");
        }
    }

    @Override
    public User login(String email, String password) {
        User user = userDao.findUserByEmailAndPassword(email, password);
        if (user == null) {
            throw new InvalidPropertyException(User.class, "email", "Invalid email");
        }
        return user;
    }
}
