package com.Erazer.controller.teacherController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Teacher;
import com.Erazer.service.teacherService.teacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "指导教师信息")
@RestController
@RequestMapping("else/teacher")
public class teacherController {
    @Autowired
    teacherService teacherService;

    @GetMapping("/getAllTeacher")
    @ApiOperation(value = "获取所有指导教师信息", notes = "获取所有教师信息", httpMethod = "GET")
    private R getAllTeacher() throws MyException {
        List<Teacher> teacherList = teacherService.getAllTeacher();
        if (teacherList.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        } else
            return R.ok().data("items", teacherList);
    }

    @PostMapping(value = "/addTeacher",produces = "application/json")
    @ApiOperation(value = "添加指导教师信息", notes = "添加指导教师信息", httpMethod = "POST")
    @ApiImplicitParam(name = "teacher_id", value = "教师ID(无需手动添加)")
    private R addTeacher(@RequestBody Teacher teacher) throws MyException {
        int flag = 0;
        teacherService.addTeacher(teacher);
        flag = teacher.getTeacher_id();
        if (flag == 0) {
            throw new MyException(ResultCode.POST_ERROR);
        } else
            return R.ok().data("key", teacher.getTeacher_id());
    }

    @DeleteMapping("/deleteTeacher")
    @ApiOperation(value = "删除教师", notes = "根据教师ID删除教师信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "教师ID", required = true)
    private R deleteTeacher(String id) throws MyException {
        int flag = 0;
        flag = teacherService.deleteTeacher(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除教师成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping(value = "/updateTeacher",produces = "application/json")
    @ApiOperation(value = "更新教师信息", notes = "根据教师ID更新教师信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "要更新的教师的ID", required = true),
    })
    private R updateTeacher(String id, @RequestBody Teacher teacher) throws MyException {
        int flag = 0;
        flag = teacherService.updateTeacher(id, teacher);
        if (flag != 0) {
            return R.ok().data("OK", "更新教师信息成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getTeacherByName")
    @ApiOperation(value = "根据姓名获取教师信息", notes = "获取指定教师信息", httpMethod = "GET")
    @ApiImplicitParam(name = "name", value = "教师姓名", required = true)
    private R getTeacherByName(String name) throws MyException {
        List<Teacher> teacherList = teacherService.getTeacherByName(name);
        if (teacherList.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        } else
            return R.ok().data("items", teacherList);
    }

    @GetMapping("/getTeacherById")
    @ApiOperation(value = "根据教师ID获取教师信息", notes = "获取教师信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "教师ID", required = true)
    private R getTeacherById(int id) throws MyException {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            return R.ok().data("items", teacher);
        } else
            throw new MyException(ResultCode.GET_ERROR);
    }
}
