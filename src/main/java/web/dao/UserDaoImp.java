package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> listUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findUser(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        manager.persist(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        User user1 = manager.find(User.class, id);
        user1.setName(updatedUser.getName());
        user1.setEmail(updatedUser.getEmail());
        user1.setAge(updatedUser.getAge());
        manager.merge(user1);
    }

    @Override
    public void deleteUser(int id) {
        manager.remove(findUser(id));
    }


}
