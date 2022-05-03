package com.Erazer.service.projectsService.projectService;

import com.Erazer.pojo.Project;

import java.util.List;

public interface projectService {
    List<Project> getAllProject();

    int addProject(Project project);

    int deleteProject(int id);

    int updateProject(int id, Project project);

    Project getProjectById(int id);
}
