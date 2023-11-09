package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    User findUser(int id);
    void addUser(User user);
    void updateUser(int id, User updatedUser);
    void deleteUser(int id);

}
