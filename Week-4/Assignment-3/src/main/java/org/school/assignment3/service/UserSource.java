package org.school.assignment3.service;

import java.util.ArrayList;

public interface UserSource {
    ArrayList<String> getAll();

    void createUser(String email, String password);
}
