package service;

import entity.Users;
import repository.IUserRepository;
import repository.UserRepository;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public Users login(String email, String password) {
        return userRepository.login(email, password);
    }
}
