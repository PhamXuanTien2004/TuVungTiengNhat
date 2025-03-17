package service;


import entity.Teachers;
import entity.Vocabulary;
import repository.ITeacherRepository;
import repository.TeacherRepository;

import java.util.List;

public class TeacherService implements ITeacherService{
    private ITeacherRepository teacherRepository = new TeacherRepository();
    @Override
    public Teachers checkTeacher(String email, String password) {
        return teacherRepository.checkTeacher(email, password);
    }
}
