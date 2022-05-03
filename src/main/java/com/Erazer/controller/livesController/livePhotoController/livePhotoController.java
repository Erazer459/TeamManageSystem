package com.Erazer.controller.livesController.livePhotoController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Live_Photo;
import com.Erazer.service.livePhotoService.livePhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "团队日常照片信息")
@RestController
@RequestMapping("lives/livePhoto")
public class livePhotoController {
    @Autowired
    livePhotoService livePhotoService;

    @GetMapping("getAllLivePhoto")
    @ApiOperation(value = "获取所有日常照片", notes = "获取所有", httpMethod = "GET")
    private R getAllLivePhoto() throws MyException {
        List<Live_Photo> list = livePhotoService.getAllLivePhoto();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @GetMapping("getLivePhotoById")
    @ApiOperation(value = "通过ID获取图片", notes = "通过ID获取图片", httpMethod = "GET")
    @ApiImplicitParam(value = "图片ID", name = "id", required = true)
    private R getLivePhotoById(int id) throws MyException {
        Live_Photo live_photo = livePhotoService.getLivePhotoById(id);
        if (live_photo != null) {
            return R.ok().data("item", live_photo);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }

    @PostMapping("/addLivePhoto")
    @ApiOperation(value = "添加日常照片信息", notes = "添加照片信息", httpMethod = "POST")
    @ApiImplicitParam(value = "图片ID(无需手动添加)", name = "live_photo_id", dataType = "int")
    private R addLivePhoto(Live_Photo live_photo) throws MyException {
        int flag = livePhotoService.addLivePhoto(live_photo);
        if (flag != 0) {
            return R.ok().data("key", live_photo.getLive_photo_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteLivePhoto")
    @ApiOperation(value = "删除日常照片信息", notes = "删除照片信息", httpMethod = "DELETE")
    @ApiImplicitParam(value = "照片ID", name = "id", dataType = "int", required = true)
    private R deleteLivePhoto(int id) throws MyException {
        int flag = livePhotoService.deleteLivePhoto(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateLivePhoto")
    @ApiOperation(value = "更新日常照片信息", notes = "更新照片信息", httpMethod = "UPDATE")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "要进行更新的照片的ID", name = "id", required = true),
            @ApiImplicitParam(value = "照片ID(无法修改)", name = "live_photo_id")
    })
    private R updateLivePhoto(int id, Live_Photo live_photo) throws MyException {
        int flag = livePhotoService.updateLivePhoto(id, live_photo);
        if (flag != 0) {
            return R.ok().data("OK", "更新照片信息成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }
}
