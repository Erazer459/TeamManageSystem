package com.Erazer.controller.livesController.liveController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Live;
import com.Erazer.pojo.Live_Photo;
import com.Erazer.service.liveService.liveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "团队日常信息")
@RestController
@RequestMapping("lives/live")
public class liveController {
    @Autowired
    liveService liveService;

    @GetMapping("/getAllLive")
    @ApiOperation(value = "获取所有日常", notes = "获取所有(请忽略live_photos字段)", httpMethod = "GET")
    private R getAllLive() throws MyException {
        List<Live> list = liveService.getAllLive();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @GetMapping("/getLiveById")
    @ApiOperation(value = "通过ID获取日常信息", notes = "通过ID获取日常", httpMethod = "GET")
    @ApiImplicitParam(value = "日常事件ID", name = "id", required = true)
    private R getLiveById(int id) throws MyException {
        Live live = liveService.getLiveById(id);
        if (live != null) {
            return R.ok().data("item", live);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }

    @PostMapping("/addLive")
    @ApiOperation(value = "添加日常信息", notes = "添加日常信息", httpMethod = "POST")
    @ApiImplicitParam(name = "live_id", value = "日常事件ID(无需手动添加)")
    private R addLive(Live live) throws MyException {
        int flag = liveService.addLive(live);
        if (flag != 0) {
            return R.ok().data("key", live.getLive_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteLive")
    @ApiOperation(value = "删除日常信息", notes = "删除日常信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "要删除的ID")
    private R deleteLive(int id) throws MyException {
        int flag = liveService.deleteLive(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateLive")
    @ApiOperation(value = "更新日常信息", notes = "更新信息", httpMethod = "UPDATE")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "要进行更新的日常信息的ID", name = "id", required = true),
            @ApiImplicitParam(value = "日常信息ID(无法修改)", name = "live_id")
    })
    private R updateLive(int id, Live live) throws MyException {
        int flag = liveService.updateLive(id, live);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getLivePhotos")
    @ApiOperation(value = "获取日常的照片", notes = "获取照片", httpMethod = "GET")
    @ApiImplicitParam(value = "事件ID", name = "id", dataType = "int")
    private R getLivePhotos(int id) throws MyException {
        List<Live_Photo> list = liveService.getLivePhotos(id);
        if (list != null) {
            return R.ok().data("item", list);
        } else
            throw new MyException(ResultCode.GET_ERROR);
    }
}
