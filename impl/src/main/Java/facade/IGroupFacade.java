package facade;

import model.Group;

import java.util.List;

/**
 * Created by Adi on 9/17/2015.
 */
public interface IGroupFacade {

    public List<Group> getAllGroups();


    public Group getGroup(Long id);


    public void deleteGroup(Long id);


    public void addGroup(Group group);


    public void updateGroup(Group group);

}
