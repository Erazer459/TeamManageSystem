package com.Erazer.mapper.resumeMapper;

import com.Erazer.pojo.Resume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface resumeMapper {
    List<Resume> getAllResume();

    Resume getResumeById(int id);

    int addResume(Resume resume);

    int updateResume(@Param("id") int id, @Param("Resume") Resume resume);

    int deleteResume(int id);
}
