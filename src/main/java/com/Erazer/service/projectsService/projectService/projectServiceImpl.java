package com.Erazer.service.projectsService.projectService;

import com.Erazer.mapper.projectMapper.projectMapper;
import com.Erazer.pojo.Project;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class projectServiceImpl implements projectService {
    @Resource
    projectMapper mapper;

    @Override
    public List<Project> getAllProject() {
        return mapper.getAllProject();
    }

    @Override
    public int addProject(Project project) {
        return mapper.addProject(project);
    }

    @Override
    public int deleteProject(int id) {
        return mapper.deleteProject(id);
    }

    @Override
    public int updateProject(int id, Project project) {
        return mapper.updateProject(id, project);
    }

    @Override
    public Project getProjectById(int id) {
        return mapper.getProjectById(id);
    }
}
