package com.Erazer.controller.awardsController.awardPhotoController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Award_Photo;
import com.Erazer.service.awardsService.awardPhotoService.awardPhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags = "奖项图片信息")
@RestController
@RequestMapping("awards/awardPhoto")
public class awardPhotoController {
    @Autowired
    awardPhotoService awardPhotoService;

    @GetMapping("/getAllAwardPhotos")
    @ApiOperation(value = "获取所有奖项照片", notes = "获取所有奖项的照片", httpMethod = "GET")
    private R getAllAwardPhotos() throws MyException {
        List<Award_Photo> awardPhotoList = awardPhotoService.getAllAwardPhotos();
        if (awardPhotoList.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", awardPhotoList);
    }

    @PostMapping("/addAwardPhoto")
    @ApiOperation(value = "添加奖项图片信息", notes = "添加图片信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "award_id", value = "奖项ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "award_photo_loc", value = "图片路径", required = true, dataType = "String", paramType = "query")
    })
    private R addAwardPhoto(@ApiIgnore Award_Photo award_photo) throws MyException {
        int flag = 0;
        flag = awardPhotoService.addAwardPhoto(award_photo);
        if (flag != 0) {
            return R.ok().data("key", award_photo.getAward_id());
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteAwardPhoto")
    @ApiImplicitParam(name = "id", value = "图片ID", required = true)
    @ApiOperation(value = "删除奖项图片", notes = "删除图片信息", httpMethod = "DELETE")
    private R deleteAwardPhoto(int id) throws MyException {
        int flag = 0;
        flag = awardPhotoService.deleteAwardPhoto(id);
        if (flag != 0) {
            return R.ok().data("OK", "删除图片信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateAwardPhoto")
    @ApiImplicitParam(name = "id", value = "图片ID", required = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "award_photo_loc", value = "图片路径", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "award_id", value = "奖项ID", required = true, dataType = "int", paramType = "query")
    })
    @ApiOperation(value = "更新奖项图片信息", notes = "更新图片信息", httpMethod = "PUT")
    private R updateAwardPhoto(int id, @ApiIgnore @Param("Award_Photo") Award_Photo award_photo) throws MyException {
        int flag = 0;
        flag = awardPhotoService.updateAwardPhoto(id, award_photo);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getAwardPhotoById")
    @ApiOperation(value = "根据ID查找图片信息", notes = "查找图片", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "图片ID", required = true)
    private R getAwardPhotoById(int id) throws MyException {
        Award_Photo award_photo = awardPhotoService.getAwardPhotoById(id);
        if (award_photo != null) {
            return R.ok().data("items", award_photo);
        }
        throw new MyException(ResultCode.GET_ERROR);
    }
}
