package repository;

import entity.Gender;
import entity.Users;
import utils.JDBCUtils;

import java.sql.*;

public class UserRepository implements IUserRepository {

    @Override
    public Users login(String email, String password) {
        String sql = "SELECT * FROM `user` WHERE email = ? AND `password` = ?";

        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String fullName = resultSet.getString(2);
                String genderStr = resultSet.getString(3);
                Gender gender = Gender.valueOf(genderStr.toUpperCase());
                int age = resultSet.getInt(4);
                String Email = resultSet.getString(5);
                return new Users(fullName, gender, age, Email);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users check(String email, String password) {
        return null;
    }

}
