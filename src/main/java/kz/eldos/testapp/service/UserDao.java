package kz.eldos.testapp.service;

import kz.eldos.testapp.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Repository
public class UserDao implements UserServiceInterface{
    /*
     * Injected
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * find user by id
     * @param id user id
     * @return user object
     */
    @Override
    public User getById (Long id) {
        return em.find(User.class, id);
    }

    /**
     * create user
     * @param user object
     */
    @Override
    public void addUser (User user) {
        user.setDate(new Date());
        em.persist(user);
    }

    /**
     * edit user
     * @param user object
     */
    @Override
    public void updateUser (User user) {
        User oldUser = getById(user.getId());
        oldUser.setName(user.getName());
        oldUser.setPassword(user.getPassword());
        em.merge(oldUser);
    }

    /**
     * deletes users from db
     * @param user user object
     */
    @Override
    public void delete(User user) {
        em.remove(em.contains(user)?user:em.merge(user));
    }
}
