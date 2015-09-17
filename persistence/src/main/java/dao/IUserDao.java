package dao;

import model.User;

import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public interface IUserDao {

    public List<User> getAllUsers(Long groupId);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long groupId, Long userId);
    public User getUser(Long groupId, Long userId);
    public User getUserById(Long userId);
}
