package com.Erazer.service.projectsService.projectPhotoService;

import com.Erazer.mapper.projectPhotoMapper.projectPhotoMapper;
import com.Erazer.pojo.Project_Photo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class projectPhotoServiceImpl implements projectPhotoService {
    @Resource
    projectPhotoMapper mapper;

    @Override
    public List<Project_Photo> getAllProjectPhoto() {
        return mapper.getAllProjectPhoto();
    }

    @Override
    public List<Project_Photo> getProjectPhotoByProjectId(int id) {
        return mapper.getProjectPhotoByProjectId(id);
    }

    @Override
    public int addProjectPhoto(Project_Photo photo) {
        return mapper.addProjectPhoto(photo);
    }

    @Override
    public int deleteProjectPhoto(int id) {
        return mapper.deleteProjectPhoto(id);
    }

    @Override
    public int updateProjectPhoto(int id, Project_Photo photo) {
        return mapper.updateProjectPhoto(id, photo);
    }
}
