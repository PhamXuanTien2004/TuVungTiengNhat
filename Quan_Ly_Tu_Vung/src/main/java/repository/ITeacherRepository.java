package repository;

import entity.Teachers;
import entity.Vocabulary;

import java.util.List;

public interface ITeacherRepository {
    Teachers checkTeacher(String email, String password);
}
