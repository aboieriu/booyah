package com.Service;

import facade.IGroupFacade;
import model.Group;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Andrei on 9/17/2015.
 */
@Controller

public class GroupService {

  @Autowired
    private IGroupFacade groupFacade;

    public IGroupFacade getGroupFacade() {
        return groupFacade;
    }
    public void setGroupFacade(IGroupFacade groupFacade) {

        this.groupFacade = groupFacade;
    }


    @RequestMapping(value = "/api/group", method = RequestMethod.GET)
    @ResponseBody
    public List<Group> getAllGroups(){
        return this.groupFacade.getAllGroups();

    }

    @RequestMapping(value = "/api/group/{groupId}", method = RequestMethod.GET)
    @ResponseBody
    public Group getGroup(@PathVariable("groupId") Long groupId){

        return this.groupFacade.getGroup(groupId);

    }


    @RequestMapping(value = "/api/group", method = RequestMethod.POST)
    @ResponseBody
    public void addGroup(@RequestBody Group group) {

        this.groupFacade.addGroup(group);
    }

    @RequestMapping(value = "/api/group//{groupId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updateGroup(@PathVariable("groupId") Long groupId, @RequestBody Group groupUpdates){
        groupUpdates.setId(groupId);
        this.groupFacade.updateGroup(groupUpdates);
    }


    @RequestMapping(value = "/api/group/{groupId}", method = RequestMethod.DELETE)
    @ResponseBody
    public void  deleteGroup(@PathVariable("groupId") Long groupId) {
        this.groupFacade.deleteGroup(groupId);
    }


}
