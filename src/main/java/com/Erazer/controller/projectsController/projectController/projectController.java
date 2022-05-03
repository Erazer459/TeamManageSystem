package com.Erazer.controller.projectsController.projectController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Project;
import com.Erazer.service.projectsService.projectService.projectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "团队项目信息")
@RestController
@RequestMapping("projects/project")
public class projectController {
    @Autowired
    projectService service;

    @GetMapping("/getAllProject")
    @ApiOperation(value = "获取所有项目信息", notes = "获取所有", httpMethod = "GET")
    private R getAllProject() throws MyException {
        List<Project> list = service.getAllProject();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @PostMapping("/addProject")
    @ApiOperation(value = "添加项目信息", notes = "添加信息", httpMethod = "POST")
    @ApiImplicitParam(value = "项目ID(无需手动添加)", name = "project_id")
    private R addProject(Project project) throws MyException {
        int flag = service.addProject(project);
        if (flag != 0) {
            return R.ok().data("key", project.getProject_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteProject")
    @ApiOperation(value = "删除项目信息", notes = "删除项目信息", httpMethod = "DELETE")
    @ApiImplicitParam(value = "要删除的项目ID", name = "id", required = true)
    private R deleteProject(int id) throws MyException {
        int flag = service.deleteProject(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateProject")
    @ApiOperation(value = "更新项目信息", notes = "更新项目信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "项目ID(无法修改)", name = "project_id"),
            @ApiImplicitParam(value = "要进行修改的项目ID", name = "id", required = true)
    })
    private R updateProject(int id, Project project) throws MyException {
        int flag = service.updateProject(id, project);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getProjectById")
    @ApiOperation(value = "通过ID查询项目信息", notes = "通过ID查询信息", httpMethod = "GET")
    @ApiImplicitParam(value = "项目ID", name = "id", required = true)
    private R getProjectById(int id) throws MyException {
        Project project = service.getProjectById(id);
        if (project != null) {
            return R.ok().data("item", project);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }
}
