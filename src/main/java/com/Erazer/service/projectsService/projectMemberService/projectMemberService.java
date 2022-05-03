package com.Erazer.service.projectsService.projectMemberService;

import com.Erazer.pojo.Project;
import com.Erazer.pojo.ProjectMember;
import com.Erazer.pojo.Project_Member;

import java.util.List;

public interface projectMemberService {
    List<ProjectMember> getAllProjectMemberMsg();

    Project_Member getProjectMemberById(Project_Member pm);

    int addProjectMemberMsg(Project_Member pm);

    List<Project> getProjectByMemberId(int id);

    int deleteProjectMemberMsg(Project_Member pm);

    int updateProjectMemberMsg(int pId, int mId, Project_Member pm);
}
