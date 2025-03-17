package repository;

import entity.Users;

public interface IUserRepository {
    Users login (String email, String password);

    // Kiểm tra xem đây là teacher hay student
    Users check (String email, String password);
}
