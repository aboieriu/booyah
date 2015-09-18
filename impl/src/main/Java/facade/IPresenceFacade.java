package facade;

import model.Presence;

import java.util.List;

/**
 * Created by DELIA on 17.09.2015.
 */
public interface IPresenceFacade {

    public List<Presence> getAllPresence(Long groupId,Long userId);
    public Presence getPresence(Long groupId, Long userId);
    public void addPresence(Presence myPresence);
    public void deletePresence(Long groupId, Long userId);

}
