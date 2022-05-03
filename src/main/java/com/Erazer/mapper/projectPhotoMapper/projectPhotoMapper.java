package com.Erazer.mapper.projectPhotoMapper;

import com.Erazer.pojo.Project_Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface projectPhotoMapper {
    List<Project_Photo> getAllProjectPhoto();

    List<Project_Photo> getProjectPhotoByProjectId(int id);

    int addProjectPhoto(Project_Photo photo);

    int deleteProjectPhoto(int id);

    int updateProjectPhoto(@Param("id") int id, @Param("Project_Photo") Project_Photo photo);
}
