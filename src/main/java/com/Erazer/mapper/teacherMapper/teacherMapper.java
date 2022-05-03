package com.Erazer.mapper.teacherMapper;

import com.Erazer.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teacherMapper {
    List<Teacher> getAllTeacher();

    void addTeacher(Teacher teacher);

    int deleteTeacher(String id);

    int updateTeacher(@Param("id") String id, @Param("Teacher") Teacher teacher);

    List<Teacher> getTeacherByName(String name);

    Teacher getTeacherById(int id);
}
