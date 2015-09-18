package facade;

import model.User;

import java.util.List;

/**
 * Created by root on 9/18/15.
 */
public interface IUserFacade {
    public List<User> getAllUsers(Long groupId);


    public User getUser(Long groupId, Long userId);


    public void deleteUser(Long groupId, Long userId);


    public void addUser(User group);


    public void updateUser(User group);
}
