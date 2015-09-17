package dao;

import model.Group;

import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public interface IGroupDao {


    public List<Group> getAll();
    public void saveGroup(Group group);
    public void updateGroup(Group group);
    public void deleteGroup(Long id);
    public Group getGroup(Long id);



}
