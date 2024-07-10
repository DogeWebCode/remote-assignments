package org.school.assignment3.service;


import org.school.assignment3.model.User;

public interface UserService {
    void register(String email, String password);
    User login(String email, String password);
}
