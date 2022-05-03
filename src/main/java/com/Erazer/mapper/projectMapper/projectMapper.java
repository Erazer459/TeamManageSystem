package com.Erazer.mapper.projectMapper;

import com.Erazer.pojo.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface projectMapper {

    List<Project> getAllProject();

    int addProject(Project project);

    int deleteProject(int id);

    int updateProject(@Param("id") int id, @Param("Project") Project project);

    Project getProjectById(int id);
}
