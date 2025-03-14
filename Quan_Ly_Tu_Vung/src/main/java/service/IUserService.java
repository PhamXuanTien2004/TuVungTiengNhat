package service;

import entity.Users;

public interface IUserService {
    Users login (String email, String password);
}
