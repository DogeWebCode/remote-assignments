package org.school.assignment3.service;

import org.school.assignment3.dao.DBConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserSerivce implements UserSource {
    // 這裡要丟入的是透過repository寫出的資料查詢，這邊用方法來調用
    // 簡單來說就是user需要甚麼商業邏輯，由這邊來實現

    @Autowired
    private DBConnect dbConnect;

    @Override
    public ArrayList<String> getAll() {
       return dbConnect.findAll();
    }

    @Override
    public void createUser(String email, String password) {
        dbConnect.createUser(email, password);
    }
}
