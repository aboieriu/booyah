package dao;

import model.Presence;

import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public interface IPresenceDao {

    public List<Presence> getAll();
    public Presence getPresence(Long userId);
    public void deletePresence(Long id);
    public void savePresence(Presence myPresence);

}
