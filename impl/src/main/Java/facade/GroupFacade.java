package facade;

import dao.IGroupDao;
import model.Group;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Andrei on 9/17/2015.
 */
public class GroupFacade implements IGroupFacade{

    @Autowired
    private IGroupDao groupDao;

    public IGroupDao getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(IGroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public List<Group> getAllGroups()
    {
        return this.groupDao.getAllGroups();
    }

    public Group getGroup(Long id)
    {
        return this.groupDao.getGroup(id);
    }

    public void deleteGroup(Long id)
    {
        this.groupDao.deleteGroup(id);
    }

    public void addGroup(Group group)
    {
        this.groupDao.addGroup(group);
    }

    public void updateGroup(Group group)
    {
        this.groupDao.updateGroup(group);
    }



}
