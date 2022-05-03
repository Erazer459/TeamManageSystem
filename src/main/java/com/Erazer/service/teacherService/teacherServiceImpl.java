package com.Erazer.service.teacherService;

import com.Erazer.mapper.memberMapper.memberMapper;
import com.Erazer.mapper.teacherMapper.teacherMapper;
import com.Erazer.pojo.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class teacherServiceImpl implements teacherService {
    @Resource
    teacherMapper teacherMapper;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAllTeacher();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherMapper.addTeacher(teacher);
    }

    @Override
    public int deleteTeacher(String id) {
        return teacherMapper.deleteTeacher(id);
    }

    @Override
    public int updateTeacher(String id, Teacher teacher) {
        return teacherMapper.updateTeacher(id, teacher);
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
        return teacherMapper.getTeacherByName(name);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherMapper.getTeacherById(id);
    }
}
