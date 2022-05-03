package com.Erazer.service.projectsService.projectPhotoService;

import com.Erazer.pojo.Project_Photo;

import java.util.List;

public interface projectPhotoService {
    List<Project_Photo> getAllProjectPhoto();

    List<Project_Photo> getProjectPhotoByProjectId(int id);

    int addProjectPhoto(Project_Photo photo);

    int deleteProjectPhoto(int id);

    int updateProjectPhoto(int id, Project_Photo photo);
}
