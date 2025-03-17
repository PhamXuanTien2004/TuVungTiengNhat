package repository;

import entity.Gender;
import entity.Teachers;
import entity.Vocabulary;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements ITeacherRepository {

    @Override
    public Teachers checkTeacher(String email, String password) {
        String sql = "SELECT * FROM `user` LEFT JOIN teacher USING(id) WHERE email = ? AND `password` = ?";

        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next() ){
//                    fullName, gender, age, email, `password`
                    String fullName = resultSet.getString("fullName");
                    String genderStr = resultSet.getString("gender");
                    Gender gender = Gender.valueOf(genderStr.toUpperCase());
                    int age = resultSet.getInt("age");
                    String Email = resultSet.getString("email");
                    int levelNow = resultSet.getInt("levelNow");
                    int expInYear = resultSet.getInt("ExpInYear");
                    String country = resultSet.getString("country");
                    return new Teachers(fullName,  gender, age, Email, levelNow, expInYear, country);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
