package repository;

import entity.Vocabulary;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VocabularyRepository implements IVocabularyRepository{
    @Override
    public List<Vocabulary> getAllVocabulary() {
        List<Vocabulary> vocabularies = new ArrayList<>();
        String sql = "SELECT * FROM vocabulary";
        try (Connection connection = JDBCUtils.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String word = resultSet.getString("word");
                String speak = resultSet.getString("speak");
                int level = resultSet.getInt("level");
                vocabularies.add(new Vocabulary(id,word, speak, level));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return vocabularies;
    }

    @Override
    public boolean createVocabulary(Vocabulary vocabulary) {
        String sql = "INSERT INTO vocabulary (word, speak, `level`) VALUES  (?, ?, ?)";
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, vocabulary.getWord());
            preparedStatement.setString(2, vocabulary.getSpeak());
            preparedStatement.setInt   (3, vocabulary.getLevel());
            int row = preparedStatement.executeUpdate();
            return row > 0;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }


}
