package com.Erazer.service.resumeService;

import com.Erazer.pojo.Resume;

import java.util.List;

public interface resumeService {
    List<Resume> getAllResume();

    Resume getResumeById(int id);

    int addResume(Resume resume);

    int updateResume(int id, Resume resume);

    int deleteResume(int id);
}
