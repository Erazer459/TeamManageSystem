package com.Erazer.mapper.projectMemberMapper;

import com.Erazer.pojo.Project;
import com.Erazer.pojo.ProjectMember;
import com.Erazer.pojo.Project_Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface projectMemberMapper {
    List<ProjectMember> getAllProjectMemberMsg();

    Project_Member getProjectMemberById(Project_Member pm);

    int addProjectMemberMsg(Project_Member pm);

    List<Project> getProjectByMemberId(int id);

    int deleteProjectMemberMsg(Project_Member pm);

    int updateProjectMemberMsg(@Param("pId") int pId, @Param("mId") int mId, @Param("Project_Member") Project_Member pm);
}
