package com.loooody.miaosha.service;

import com.loooody.miaosha.dao.UserDao;
import com.loooody.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired(required = false)
    UserDao userDao;

    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    public void tx() {
        User u1 = new User();
        u1.setId(2);
        u1.setName("222");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(1);
        u2.setName("2223");
        userDao.insert(u2);
    }
}
