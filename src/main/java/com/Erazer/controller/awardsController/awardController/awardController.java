package com.Erazer.controller.awardsController.awardController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Award;
import com.Erazer.pojo.Award_Photo;
import com.Erazer.service.awardsService.awardService.awardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "团队奖项信息")
@RestController
@RequestMapping("awards/award")
public class awardController {
    @Autowired
    awardService awardService;

    @GetMapping("/getAllAward")
    @ApiOperation(value = "获取所有奖项信息", notes = "奖项信息", httpMethod = "GET")

    private R getAllAward() throws MyException {
        List<Award> awardList = awardService.getAllAward();
        if (awardList.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", awardList);
    }

    @PostMapping("/addAward")
    @ApiOperation(value = "添加奖项信息", notes = "添加奖项(无需添加奖项ID)", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "award_name", value = "奖项名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "award_time", value = "获奖时间", required = true, dataType = "Date", paramType = "query")
    })
    private R addAward(@ApiIgnore Award award) throws MyException {
        int flag = awardService.addAward(award);
        ;
        if (flag != 0) {
            return R.ok().data("key", award.getAward_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteAward")
    @ApiOperation(value = "根据ID删除奖项信息", notes = "删除奖项信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "奖项ID", required = true)
    private R deleteAward(int id) throws MyException {
        int flag;
        flag = awardService.deleteAward(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateAward")
    @ApiOperation(value = "更新奖项信息", notes = "更新奖项", httpMethod = "PUT")
    @ApiImplicitParam(name = "id", value = "要进行更新的奖项ID", required = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "award_name", value = "奖项名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "award_time", value = "获奖时间", required = true, dataType = "Date", paramType = "query")
    })
    private R updateAward(int id, @ApiIgnore @Param("Award") Award award) throws MyException {
        int flag;
        flag = awardService.updateAward(id, award);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getAwardPhoto")
    @ApiOperation(value = "获取奖项的图片", notes = "获取奖项图片信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "奖项ID", required = true)
    private R getAwardAndPic(int id) throws MyException {
        List<Award_Photo> list = awardService.getAwardPhoto(id);
        if (list != null) {
            return R.ok().data("items", list);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }
}
