package facade;

import dao.IPresenceDao;
import model.Presence;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


/**
 * Created by DELIA on 17.09.2015.
 */
public class PresenceFacade implements IPresenceFacade{

    @Autowired
    private IPresenceDao presenceDao;

    public IPresenceDao getPresenceDao() {
        return presenceDao;
    }

    public void setPresenceDao(IPresenceDao presenceDao) {
        this.presenceDao = presenceDao;
    }

    public List<Presence> getAllPresence(Long groupId) {

        return this.presenceDao.getAll(groupId);
    }

    public Presence getPresence(Long groupId, Long userId){
        return this.presenceDao.getPresence(groupId, userId);

    }

    public void addPresence(Presence myPresence){
        this.presenceDao.addPresence(myPresence);
    }

    public void deletePresence(Long groupId, Long userId){
        this.presenceDao.deletePresence(groupId, userId);
    }
















}
