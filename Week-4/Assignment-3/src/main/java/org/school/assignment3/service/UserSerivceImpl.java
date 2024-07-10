package org.school.assignment3.service;

import org.school.assignment3.dao.UserDao;
import org.school.assignment3.model.User;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void register(String email, String password) {
        if(!userDao.isEmailExists(email)) {
            userDao.insertUser(email, password);
        }else {
            throw new InvalidPropertyException(User.class, "email", "Email already exists");
        }
    }

    @Override
    public User login(String email, String password) {
        User user = userDao.findUserByEmailAndPassword(email, password);
        if(user == null) {
            throw new InvalidPropertyException(User.class, "email", "Invalid email or password");
        }
        return user;
    }
}
