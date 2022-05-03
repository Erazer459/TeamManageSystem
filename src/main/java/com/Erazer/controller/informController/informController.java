package com.Erazer.controller.informController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Inform;
import com.Erazer.service.informService.informService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "团队公告信息")
@RestController
@RequestMapping("else/inform")
public class informController {
    @Autowired
    informService informService;

    @GetMapping("/getAllInform")
    @ApiOperation(value = "获取所有公告信息", notes = "获取所有信息", httpMethod = "GET")
    private R getAllInform() throws MyException {
        List<Inform> informList = informService.getAllInform();
        if (informList.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", informList);
    }

    @GetMapping("/getInformById")
    @ApiOperation(value = "通过ID获取公告信息", notes = "通过ID获取公告信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "公告ID", required = true)
    private R getInformById(int id) throws MyException {
        Inform inform = informService.getInformById(id);
        if (inform != null) {
            return R.ok().data("items", inform);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }

    @PostMapping("/addInform")
    @ApiOperation(value = "添加公告信息", notes = "添加公告信息", httpMethod = "POST")
    @ApiImplicitParam(name = "inform_id", value = "公告ID(无需手动添加)", required = false)
    private R addInform(Inform inform) throws MyException {
        int flag = informService.addInform(inform);
        if (flag != 0) {
            return R.ok().data("key", inform.getInform_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteInform")
    @ApiOperation(value = "删除公告信息", notes = "删除公告信息通过ID", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "公告ID", required = true)
    private R deleteInform(int id) throws MyException {
        int flag = informService.deleteInform(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除公告信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateInform")
    @ApiOperation(value = "更新公告信息", notes = "通过ID更新公告信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公告ID", required = true),
            @ApiImplicitParam(name = "inform_id", value = "公告ID(无法修改)")
    })
    private R updateInform(int id, Inform inform) throws MyException {
        int flag = informService.updateInform(id, inform);
        if (flag != 0) {
            return R.ok().data("OK", "更新公告信息成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }
}
