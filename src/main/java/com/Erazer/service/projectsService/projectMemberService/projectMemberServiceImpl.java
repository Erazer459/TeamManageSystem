package com.Erazer.service.projectsService.projectMemberService;

import com.Erazer.mapper.projectMemberMapper.projectMemberMapper;
import com.Erazer.pojo.Project;
import com.Erazer.pojo.ProjectMember;
import com.Erazer.pojo.Project_Member;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class projectMemberServiceImpl implements projectMemberService {
    @Resource
    projectMemberMapper mapper;

    @Override
    public List<ProjectMember> getAllProjectMemberMsg() {
        return mapper.getAllProjectMemberMsg();
    }

    @Override
    public Project_Member getProjectMemberById(Project_Member pm) {
        return mapper.getProjectMemberById(pm);
    }

    @Override
    public int addProjectMemberMsg(Project_Member pm) {
        return mapper.addProjectMemberMsg(pm);
    }

    @Override
    public List<Project> getProjectByMemberId(int id) {
        return mapper.getProjectByMemberId(id);
    }

    @Override
    public int deleteProjectMemberMsg(Project_Member pm) {
        return mapper.deleteProjectMemberMsg(pm);
    }

    @Override
    public int updateProjectMemberMsg(int pId, int mId, Project_Member pm) {
        return mapper.updateProjectMemberMsg(pId, mId, pm);
    }
}
