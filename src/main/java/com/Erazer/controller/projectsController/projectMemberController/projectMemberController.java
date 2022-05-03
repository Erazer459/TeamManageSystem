package com.Erazer.controller.projectsController.projectMemberController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Project;
import com.Erazer.pojo.ProjectMember;
import com.Erazer.pojo.Project_Member;
import com.Erazer.service.projectsService.projectMemberService.projectMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "成员项目信息")
@RestController
@RequestMapping("projects/projectMember")
public class projectMemberController {
    @Autowired
    projectMemberService service;

    @GetMapping("/getAllProjectMemberMsg")
    @ApiOperation(value = "获得所有项目与成员联系信息", notes = "获取所有信息", httpMethod = "GET")
    private R getAllProjectMemberMsg() throws MyException {
        List<ProjectMember> list = service.getAllProjectMemberMsg();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @PostMapping("/addProjectMemberMsg")
    @ApiOperation(value = "添加项目与成员联系信息", notes = "添加信息", httpMethod = "POST")
    private R addProjectMemberMsg(Project_Member pm) throws MyException {
        if (service.getProjectMemberById(pm) != null) {
            throw new MyException(ResultCode.EXIST_ERROR);
        }
        int flag = service.addProjectMemberMsg(pm);
        if (flag != 0) {
            return R.ok().data("OK", "添加信息成功");
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @GetMapping("/getProjectByMemberId")
    @ApiOperation(value = "查找成员的项目信息", notes = "查找成员的项目信息", httpMethod = "GET")
    @ApiImplicitParam(value = "成员ID", name = "id")
    private R getProjectByMemberId(int id) throws MyException {
        List<Project> list = service.getProjectByMemberId(id);
        if (list != null) {
            return R.ok().data("items", list);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }

    @DeleteMapping("/deleteProjectMemberMsg")
    @ApiOperation(value = "删除成员与项目联系信息", notes = "删除信息", httpMethod = "DELETE")
    private R deleteProjectMemberMsg(Project_Member pm) throws MyException {
        int flag = service.deleteProjectMemberMsg(pm);
        if (flag != 0) {
            return R.ok().data("OK", "删除信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateProjectMemberMsg")
    @ApiOperation(value = "更新成员与项目联系信息", notes = "更新信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "要进行修改的记录的项目ID", name = "pId"),
            @ApiImplicitParam(value = "要进行修改的记录的成员ID", name = "mId")
    })
    private R updateProjectMemberMsg(int pId, int mId, Project_Member pm) throws MyException {
        if (service.getProjectMemberById(pm) != null) {
            throw new MyException(ResultCode.EXIST_ERROR);
        }
        int flag = service.updateProjectMemberMsg(pId, mId, pm);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }
}
