package controller;

import entity.Users;
import service.IUserService;
import service.UserService;

public class UserController {
    private IUserService userService = new UserService();

    public Users login(String email, String password){
        return userService.login(email,password);
    }
}
