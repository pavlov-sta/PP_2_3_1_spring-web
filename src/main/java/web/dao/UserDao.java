package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);
    List<User> getAllUsers();

   User getUser(int id);

   void removeUser(int id);
   void updateUser(User user);
}
