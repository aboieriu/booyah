package facade;

import model.Group;
import model.User;

import java.util.List;

/**
 * Created by Adi on 9/17/2015.
 */
public interface IUserFacade {

    public List<User> getAllUsers(Long groupId);


    public User getUser(Long groupId, Long userId);


    public void deleteUser(Long groupId, Long userId);


    public void addUser(User group);


    public void updateUser(User group);
}