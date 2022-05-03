package com.Erazer.controller.membersController.memberAwardController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Award;
import com.Erazer.pojo.MemberAward;
import com.Erazer.pojo.Member_Award;
import com.Erazer.service.membersService.memberAwardService.memberAwardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "成员获奖信息")
@RestController
@RequestMapping("members/memberAward")
public class memberAwardController {
    @Autowired
    memberAwardService memberAwardService;

    @GetMapping("/getAllMemberAwardMsg")
    @ApiOperation(value = "获取所有成员与奖项联系信息", notes = "获取所有信息", httpMethod = "GET")
    private R getAllMemberAwardMsg() throws MyException {
        List<MemberAward> list = memberAwardService.getAllMemberAwardMsg();
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", list);
    }

    @DeleteMapping("/deleteMemberAwardMsg")
    @ApiOperation(value = "删除成员与奖项联系信息", notes = "删除信息", httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "成员ID", name = "mId", required = true, dataType = "int"),
            @ApiImplicitParam(value = "奖项ID", name = "aId", required = true, dataType = "int")
    })
    private R deleteMemberAwardMsg(int aId, int mId) throws MyException {
        int flag = memberAwardService.deleteMemberAwardMsg(aId, mId);
        if (flag != 0) {
            return R.ok().data("OK", "删除信息成功");
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping("/updateMemberAwardMsg")
    @ApiOperation(value = "更新成员与奖项联系信息", notes = "更新信息", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "要进行修改的成员ID", name = "mId", required = true, dataType = "int"),
            @ApiImplicitParam(value = "要进行修改的奖项ID", name = "aId", required = true, dataType = "int"),
            @ApiImplicitParam(value = "奖项ID(修改后)", name = "award_id", dataType = "int"),
            @ApiImplicitParam(value = "成员ID(修改后)", name = "member_id", dataType = "int")
    })
    private R addMemberAwardMsg(int mId, int aId, int award_id, int member_id) throws MyException {
        int flag = memberAwardService.updateMemberAwardMsg(mId, aId, award_id, member_id);
        if (flag != 0) {
            return R.ok().data("OK", "更新成功");
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/getMemberAwardByMemberId")
    @ApiOperation(value = "获取某成员的获奖信息", notes = "通过ID获取成员获奖信息", httpMethod = "GET")
    @ApiImplicitParam(value = "成员ID", name = "id", required = true)
    private R getMemberAwardByMemberId(int id) throws MyException {
        List<Award> list = memberAwardService.getMemberAwardByMemberId(id);
        if (list.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        } else
            return R.ok().data("items", list);
    }

    @PostMapping("/addMemberAwardMsg")
    @ApiOperation(value = "添加成员获奖信息", notes = "添加成员获奖信息", httpMethod = "POST")
    private R addMemberAwardMsg(Member_Award ma) throws MyException {
        if (memberAwardService.MemberAwardExist(ma) != null) {
            throw new MyException(ResultCode.EXIST_ERROR);
        }
        int flag = memberAwardService.addMemberAwardMsg(ma);
        if (flag != 0) {
            return R.ok().data("OK", "添加成功");
        }
        throw new MyException(ResultCode.POST_ERROR);
    }
}
