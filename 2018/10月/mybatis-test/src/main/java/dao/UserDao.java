package dao;

import entity.User;

import java.util.List;

public interface UserDao {

    public void insert(User user);

    public User findUserById(int id);

    public List<User> findAllUser();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

}
