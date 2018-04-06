package kz.eldos.testapp.service;

import kz.eldos.testapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getById (Long id) {
        return userDao.getById(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser (User user) {
        userDao.updateUser(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
