package com.Erazer.controller.membersController.resumeController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Resume;
import com.Erazer.service.resumeService.resumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "成员简历信息")
public class resumeController {
    @Autowired
    resumeService service;

    @GetMapping("/getAllResume")
    @ApiOperation(value = "获取所有成员简历信息", notes = "获取所有成员简历信息", httpMethod = "GET")
    private R getAllResume() throws MyException {
        List<Resume> list = service.getAllResume();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        } else
            return R.ok().data("items", list);
    }

    @GetMapping("/getResumeById")
    @ApiOperation(value = "通过ID获取简历信息", notes = "获取简历信息", httpMethod = "GET")
    @ApiImplicitParam(value = "简历ID", name = "id")
    private R getResumeById(int id) throws MyException {
        Resume resume = service.getResumeById(id);
        if (resume != null) {
            return R.ok().data("item", resume);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }

    @PostMapping(value = "/addResume",produces = "application/json")
    @ApiOperation(value = "添加简历信息", notes = "添加简历信息", httpMethod = "POST")
    @ApiImplicitParam(value = "简历ID(无需手动添加)", name = "resume_id")
    private R addResume(@RequestBody Resume resume) throws MyException {
        int flag = service.addResume(resume);
        if (flag != 0) {
            return R.ok().data("key", resume.getResume_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @PutMapping(value = "/updateResume",produces = "application/json")
    @ApiOperation(value = "更新简历信息", notes = "更新简历信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "简历ID(无法修改)", name = "resume_id"),
            @ApiImplicitParam(value = "要进行更新的简历的ID", name = "id")
    })
    private R updateResume(int id, @RequestBody Resume resume) throws MyException {
        int flag = service.updateResume(id, resume);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @DeleteMapping("/deleteResume")
    @ApiOperation(value = "删除简历信息", notes = "删除简历信息", httpMethod = "DELETE")
    @ApiImplicitParam(value = "简历ID", name = "id")
    private R deleteResume(int id) throws MyException {
        int flag = service.deleteResume(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }
}
