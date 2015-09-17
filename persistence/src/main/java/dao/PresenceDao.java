package dao;

import model.Presence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public class PresenceDao implements IPresenceDao{

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Presence> getAll(Long groupId) {

        Query query = this.entityManager.createQuery("from Presence WHERE groupId =:targetGroupId");
        query.setParameter("targetGroupId", groupId);
        return query.getResultList();

    }

    @Transactional
    public Presence getPresence(Long userId, Long groupId) {
        if (userId != null && groupId != null) {
            Query query = this.entityManager.createQuery("from Presence WHERE userId =:targetUserId AND groupId =:targetUserId");
            query.setParameter("targetUserId", userId);
            query.setParameter("targetUserId", groupId);
            List<Presence> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
        }

        return null;
    }


    @Transactional
    public void deletePresence(Long userId, Long groupId) {

        Presence itemFromDbs = this.getPresence(userId, groupId);
        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }

    @Transactional
    public void addPresence(Presence myPresence) {

        myPresence.setDate(new Date());
        entityManager.persist(myPresence);
    }
}
