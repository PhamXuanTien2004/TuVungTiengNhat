package service;

import entity.Teachers;
import entity.Vocabulary;

import java.util.List;

public interface ITeacherService {
    Teachers checkTeacher(String email, String password);
}
