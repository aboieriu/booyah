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

    public List<Presence> getAll(Long groupId, Long userId) {
        Query query = this.entityManager.createQuery("from Presence WHERE groupId =:targetGroupId AND userId =:targetUserId");
        query.setParameter("targetGroupId", groupId);
        query.setParameter("targetUserId", userId);
        return query.getResultList();

    }

    @Transactional
    public Presence getPresence(Long groupId, Long userId) {
        if (userId != null && groupId != null) {
            Query query = this.entityManager.createQuery("from Presence WHERE groupId =:targetGroupId AND userId =:targetUserId");
            query.setParameter("targetGroupId", groupId);
            query.setParameter("targetUserId", userId);
            List<Presence> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
        }

        return null;
    }


    @Transactional
    public void deletePresence(Long groupId, Long userId) {

        Presence itemFromDbs = this.getPresence(groupId, userId);
        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }

    @Transactional
    public void addPresence(Presence myPresence) {
        entityManager.persist(myPresence);
    }
}
