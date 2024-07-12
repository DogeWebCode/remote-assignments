package org.school.assignment3.service;


import org.school.assignment3.dao.UserDaoImpl;
import org.school.assignment3.model.User;
import org.school.assignment3.utils.BCryptUtil;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public void register(String email, String password) {
        if (!userDaoImpl.isEmailExists(email)) {
            String encodePassword = BCryptUtil.encodePassword(password);
            userDaoImpl.insertUser(email, encodePassword);
        } else {
            throw new InvalidPropertyException(User.class, "email", "Email already exists");
        }
    }

    @Override
    public User login(String email, String password) {
        User user = userDaoImpl.findUserByEmailAndPassword(email, password);
        if (user == null) {
            throw new InvalidPropertyException(User.class, "email", "Invalid email");
        }
        return user;
    }
}
