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

    public List<Presence> getAll() {
        return this.entityManager.createQuery("from Presence").getResultList();
    }

    @Transactional
    public Presence getPresence(Long userId) {
        if (userId != null) {
            Query query = this.entityManager.createQuery("from User WHERE id =:targetUserId");
            query.setParameter("targetUserId", userId);
            List<Presence> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
        }

        return null;
    }


    @Transactional
    public void deletePresence(Long id) {

        Presence itemFromDbs = this.getPresence(id);
        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }

    @Transactional
    public void savePresence(Presence myPresence) {

        myPresence.setDate(new Date());
        entityManager.persist(myPresence);
    }











}
