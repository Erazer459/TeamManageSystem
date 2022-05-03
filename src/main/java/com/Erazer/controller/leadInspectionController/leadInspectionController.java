package com.Erazer.controller.leadInspectionController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Lead_Inspection;
import com.Erazer.service.leadInspectionService.leadInspectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "领导视察事件信息")
@RestController
@RequestMapping("else/leadInspection")
public class leadInspectionController {
    @Autowired
    leadInspectionService leadInspectionService;

    @GetMapping("/getAllLeadInsp")
    @ApiOperation(value = "获取所有事件", notes = "获取所有事件", httpMethod = "GET")
    private R getAllLeadInsp() throws MyException {
        List<Lead_Inspection> list = leadInspectionService.getAllLeadInsp();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @GetMapping("/getLeadInspById")
    @ApiOperation(value = "根据ID获取事件信息", notes = "获取事件信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "事件ID", required = true)
    private R getLeadInspById(int id) throws MyException {
        Lead_Inspection lead_inspection = leadInspectionService.getLeadInspById(id);
        if (lead_inspection != null) {
            return R.ok().data("items", lead_inspection);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }

    @PostMapping("/addLeadInsp")
    @ApiOperation(value = "添加事件", notes = "添加事件信息", httpMethod = "POST")
    @ApiImplicitParam(name = "id", value = "事件ID(无需手动添加)")
    private R addLeadInsp(Lead_Inspection lead_inspection) throws MyException {
        int flag = leadInspectionService.addLeadInsp(lead_inspection);
        if (flag != 0) {
            return R.ok().data("key", lead_inspection.getId());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteLeadInsp")
    @ApiOperation(value = "删除事件", notes = "删除事件信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "事件ID", required = true)
    private R deleteLeadInsp(int id) throws MyException {
        int flag = leadInspectionService.deleteLeadInsp(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除事件信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateLeadInsp")
    @ApiOperation(value = "更新事件", notes = "更新事件", httpMethod = "UPDATE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "inspId", value = "要进行更新的事件的ID", required = true),
            @ApiImplicitParam(name = "id", value = "事件ID(无法修改)")
    })
    private R updateLeadInsp(int inspId, Lead_Inspection lead_inspection) throws MyException {
        int flag = leadInspectionService.updateLeadInsp(inspId, lead_inspection);
        if (flag != 0) {
            return R.ok().data("OK", "更新事件信息成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

}
