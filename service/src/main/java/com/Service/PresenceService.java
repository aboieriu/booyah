package com.Service;

import facade.IPresenceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import model.Presence;
/**
 * Created by cristina on 2015/09/17.
 */

@Controller
public class PresenceService {

    @Autowired
    private IPresenceFacade presenceFacade;

    @RequestMapping(value = "/api/group/{groupId}/user/{userId}/presence", method = RequestMethod.GET)
    @ResponseBody
    public List<Presence> getAllPresence(@PathVariable("groupId") Long groupId, @PathVariable("userId") Long userId ) {

        return this.presenceFacade.getAllPresence(groupId,userId);
    }


    @RequestMapping(value = "/api/group/{groupId}/user/{userId}/presence", method = RequestMethod.POST)
    @ResponseBody
    public void addPresence(@PathVariable("groupId") Long groupId, @PathVariable("userId") Long userId, @RequestBody Presence newPresence) {

        newPresence.setGroupId(groupId);
        newPresence.setUserId(userId);
        this.presenceFacade.addPresence(newPresence);
    }

    @RequestMapping(value = "/api/group/{groupId}/user/{userId}/presence/{presenceId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePresence(@PathVariable("groupId") Long groupId, @PathVariable("userId") Long userId, @PathVariable("presenceId") Long presenceId) {
        this.presenceFacade.deletePresence(groupId,presenceId);
    }
}






















