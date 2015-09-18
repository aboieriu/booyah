package dao;

import model.Group;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public class GroupDao implements IGroupDao {


    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Group> getAllGroups(){

        return this.entityManager.createQuery("from Group").getResultList();
    }

    public Group getGroup(Long id)
    {
        if(id == null){
            return null;
        }
        else
        {
            return entityManager.find(Group.class, id);
        }
    }

    private Group getGroupByStarDateAndEndDate(Date startDate, Date endDate)
    {
        Query query = this.entityManager.createQuery("from Group WHERE startDate =:targetStartDate AND endDate =:targetEndDate");
        query.setParameter("targetStartDate", startDate);
        query.setParameter("targetEndDate", endDate);
        return (Group)query.getSingleResult();
    }

    @Transactional
    public void addGroup(Group group)
    {

        Group groupFromDbs = this.getGroupByStarDateAndEndDate(group.getStartDate(), group.getEndDate());
        if(groupFromDbs != null)
        {
            entityManager.persist(group);
        }
    }

    @Transactional
    public void updateGroup(Group group)
    {

        Group groupFromDbs = this.getGroup(group.getId());
        if (groupFromDbs != null)
        {
            groupFromDbs.setName(group.getName());
            groupFromDbs.setStartDate(group.getStartDate());
            groupFromDbs.setEndDate(group.getEndDate());
            entityManager.persist(groupFromDbs);

        }
    }

    @Transactional
    public void deleteGroup(Long id)
    {
        Group groupFromDbs = this.getGroup(id);
        if (groupFromDbs != null) {
            entityManager.remove(groupFromDbs);
        }
        //entityManager.remove(id);
    }

















}
