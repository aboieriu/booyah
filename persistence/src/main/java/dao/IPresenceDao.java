package dao;

import model.Presence;

import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public interface IPresenceDao {

    public List<Presence> getAll(Long groupId,Long userId);
    public Presence getPresence(Long userId, Long groupId);
    public void deletePresence(Long groupId, Long userId);
    public void addPresence(Presence myPresence);

}
