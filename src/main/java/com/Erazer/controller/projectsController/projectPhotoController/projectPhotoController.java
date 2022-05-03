package com.Erazer.controller.projectsController.projectPhotoController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Project_Photo;
import com.Erazer.service.projectsService.projectPhotoService.projectPhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "项目图片信息")
@RestController
@RequestMapping("projects/projectPhoto")
public class projectPhotoController {
    @Autowired
    projectPhotoService service;

    @GetMapping("/getAllProjectPhoto")
    @ApiOperation(value = "获取所有项目图片", notes = "获取所有", httpMethod = "GET")
    private R getAllProjectPhoto() throws MyException {
        List<Project_Photo> list = service.getAllProjectPhoto();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @GetMapping("/getProjectPhotoByProjectId")
    @ApiOperation(value = "通过项目ID获取项目的图片", notes = "获取项目图片", httpMethod = "GET")
    @ApiImplicitParam(value = "项目ID", name = "id")
    private R getProjectPhotoByProjectId(int id) throws MyException {
        List<Project_Photo> list = service.getProjectPhotoByProjectId(id);
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @PostMapping("/addProjectPhoto")
    @ApiOperation(value = "添加项目图片信息", notes = "添加项目图片信息", httpMethod = "POST")
    @ApiImplicitParam(value = "图片ID(无需手动添加)", name = "project_photo_id")
    private R addProjectPhoto(Project_Photo photo) throws MyException {
        int flag = service.addProjectPhoto(photo);
        if (flag != 0) {
            return R.ok().data("key", photo.getProject_photo_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteProjectPhoto")
    @ApiOperation(value = "删除项目图片信息", notes = "删除项目图片信息", httpMethod = "DELETE")
    @ApiImplicitParam(value = " 图片ID", name = "id")
    private R deleteProjectPhoto(int id) throws MyException {
        int flag = service.deleteProjectPhoto(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除图片信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateProjectPhoto")
    @ApiOperation(value = "更新项目图片信息", notes = "更新项目图片信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = " 要进行修改的图片的ID", name = "id"),
            @ApiImplicitParam(value = "图片ID(无法修改)", name = "project_photo_id")
    })
    private R deleteProjectPhoto(int id, Project_Photo photo) throws MyException {
        int flag = service.updateProjectPhoto(id, photo);
        if (flag != 0) {
            return R.ok().data("OK", "更新图片信息成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }
}
