package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userDao;

    public UserServiceImpl(UserRepository userDao) {
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public void addUser(User user) {
         userDao.save(user);
    }
    @Transactional
    @Override
    public void removeUser(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public User getUser(Long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return userDao.getUserByFirstNam(name);
    }
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return userDao.getUserByFirstNam(s);
    }}

