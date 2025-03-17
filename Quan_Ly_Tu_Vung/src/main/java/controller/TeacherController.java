package controller;

import entity.Teachers;
import entity.Vocabulary;
import service.ITeacherService;
import service.TeacherService;

import java.util.List;

public class TeacherController {
    private ITeacherService teacherService = new TeacherService();

    public Teachers checkTeacher(String email, String password){
        return teacherService.checkTeacher(email, password);
    }
}
