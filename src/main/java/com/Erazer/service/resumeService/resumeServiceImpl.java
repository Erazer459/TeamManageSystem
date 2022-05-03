package com.Erazer.service.resumeService;

import com.Erazer.mapper.resumeMapper.resumeMapper;
import com.Erazer.pojo.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class resumeServiceImpl implements resumeService {
    @Resource
    resumeMapper mapper;

    @Override
    public List<Resume> getAllResume() {
        return mapper.getAllResume();
    }

    @Override
    public Resume getResumeById(int id) {
        return mapper.getResumeById(id);
    }

    @Override
    public int addResume(Resume resume) {
        return mapper.addResume(resume);
    }

    @Override
    public int updateResume(int id, Resume resume) {
        return mapper.updateResume(id, resume);
    }

    @Override
    public int deleteResume(int id) {
        return mapper.deleteResume(id);
    }
}
