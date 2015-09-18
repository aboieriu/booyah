package com.Service;

import facade.IUserFacade;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by root on 9/10/15.
 */
@Controller
public class UserService {

    @Autowired
    private IUserFacade userFacade;


    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @RequestMapping(value="/api/group/{groupId}/user", method= RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(@PathVariable("groupId") Long groupId) {
        return this.userFacade.getAllUsers(groupId);
    }

    @RequestMapping(value="/api/group/{groupId}/user/{userId}", method= RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("groupId")Long groupId, @PathVariable("userId") Long userId) {
        return this.userFacade.getUser(groupId, userId);
    }

    @RequestMapping(value="/api/group/{groupId}/user/{userId}}", method= RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable("userId")Long userId,@PathVariable("groupId")Long groupId, @RequestBody User userUpdates) {
        userUpdates.setId(userId);
        userUpdates.setGroupId(groupId);
        this.userFacade.updateUser(userUpdates);
    }

    @RequestMapping(value="/api/group/{groupId}/user", method= RequestMethod.POST)
    @ResponseBody
    public void addUser(@PathVariable("groupId")Long groupId, @RequestBody User user){
        user.setGroupId(groupId);
        this.userFacade.addUser(user);
    }

    @RequestMapping(value="/api/group/{groupId}/user/{userId}", method= RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("groupId")Long groupId, @PathVariable("userId")Long userId){
        this.userFacade.deleteUser(groupId,userId);
    }

}
