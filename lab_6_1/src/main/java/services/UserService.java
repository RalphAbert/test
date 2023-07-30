package services;


import entities.User;
import reponsitories.UserReponsitory;

import java.util.ArrayList;

public class UserService {

    private UserReponsitory userReponsitory;

    public UserService(){
        this.userReponsitory = new UserReponsitory();
    }

    public ArrayList<User> findAll(){
        return this.userReponsitory.findAll();
    }

    public User findOne(String ma){
        return this.userReponsitory.findOne(ma);
    }
}
