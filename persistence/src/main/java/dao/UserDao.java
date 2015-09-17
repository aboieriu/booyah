package dao;

import model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public class UserDao implements IUserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager (EntityManager entityManager){
         this.entityManager = entityManager;
    }

    @Transactional
    public void addUser(User user)
    {
        entityManager.persist(user);

    }

    @Transactional
    public void updateUser(User user)
    {

        User userFromDbs = this.getUserById(user.getId());
        if (userFromDbs != null)
        {
            userFromDbs.setName(user.getName());
            userFromDbs.setSurname(user.getSurname());
            userFromDbs.setUsername(user.getUsername());
            userFromDbs.setPassword(user.getPassword());
            userFromDbs.setEmail(user.getEmail());
            userFromDbs.setPhone(user.getPhone());
            userFromDbs.setRepositoryUrl(user.getRepositoryUrl());

            entityManager.persist(userFromDbs);

        }
    }

    public User getUserById(Long userId)
    {
        return this.entityManager.find(User.class,userId);
    }

    @Transactional
    public void deleteUser(Long groupId, Long userId)
    {
        User userFromDbs = this.getUser(groupId,userId);
        if (userFromDbs != null) {
            entityManager.remove(userFromDbs);
        }

    }

    public User getUser(Long groupId, Long userId)
    {
        Query query = this.entityManager.createQuery("from User WHERE groupId = :targetGroupId AND id =:targetUserId");
        query.setParameter("targetGroupId", groupId);
        query.setParameter("targetUserId", userId);
        List<User> result = query.getResultList();
        if(!result.isEmpty()){
            return result.get(0);
        }

    }

    public List<User> getAllUsers(Long groupId){

        Query query = this.entityManager.createQuery("from User WHERE groupId = :targetUserId");
        query.setParameter("targetUserId", groupId);

        return query.getResultList();
    }






}
