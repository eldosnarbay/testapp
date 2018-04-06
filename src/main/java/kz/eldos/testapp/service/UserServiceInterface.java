package kz.eldos.testapp.service;

import kz.eldos.testapp.model.User;

public interface UserServiceInterface {
    User getById(Long id);
    void addUser(User user);
    void updateUser(User user);
    void delete(User user);
}
