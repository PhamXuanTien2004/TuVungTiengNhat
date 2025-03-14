package repository;

import entity.Users;

public interface IUserRepository {
    Users login (String email, String password);
}
