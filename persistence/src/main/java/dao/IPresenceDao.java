package dao;

import model.Presence;

import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public interface IPresenceDao {

    public List<Presence> getAll(Long groupId);
    public Presence getPresence(Long userId, Long groupId);
    public void deletePresence(Long userId, Long groupId);
    public void addPresence(Presence myPresence);

}
