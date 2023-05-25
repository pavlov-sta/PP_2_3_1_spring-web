package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoIml implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    @Transactional
    public void updateUser(User user) {
      entityManager.merge(user);
    }

}
