package com.Erazer.service.teacherService;

import com.Erazer.pojo.Teacher;

import java.util.List;

public interface teacherService {
    List<Teacher> getAllTeacher();

    void addTeacher(Teacher teacher);

    int deleteTeacher(String id);

    int updateTeacher(String id, Teacher teacher);

    List<Teacher> getTeacherByName(String name);

    Teacher getTeacherById(int id);
}
