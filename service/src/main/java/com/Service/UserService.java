package com.service;

import facade.IUserFacade;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 9/10/15.
 */
@Controller
@RequestMapping("/booyah/api/user")
public class UserService {

    @Autowired
    private IUserFacade userFacade;

    @RequestMapping(value="", method= RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
        return this.userFacade.bringUsers();
    }

    @RequestMapping(value="/{userId}", method= RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("userId") Long userId) {
        return this.userFacade.geUser(userId);
    }

    @RequestMapping(value="/{userId}", method= RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@PathVariable("userId")Long userId, @RequestBody User userUpdates) {
        userUpdates.setId(userId);
        this.userFacade.updateUser(userUpdates);
    }

    @RequestMapping(value="", method= RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody User newUser){
        this.userFacade.saveUser(newUser);
    }

    @RequestMapping(value="/{userId}", method= RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@PathVariable("userId")Long userId){
        this.userFacade.deleteUser(userId);
    }

    public IUserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(IUserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
