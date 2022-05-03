package com.Erazer.controller.membersController.memberController;

import com.Erazer.ApiResult.R;
import com.Erazer.ApiResult.ResultCode;
import com.Erazer.GlobalExceptionResolver.MyException;
import com.Erazer.pojo.Member;
import com.Erazer.service.membersService.memberService.memberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "团队成员信息")
@RestController
@RequestMapping("members/member")
public class memberController {
    @Autowired
    memberService memberService;

    @GetMapping("/getAllMember")
    @ApiImplicitParam(name = "id", value = "当前页码", required = true, defaultValue = "1")
    @ApiOperation(value = "获取所有团队成员信息", notes = "获取所有团队成员", httpMethod = "GET")
    private R getAllMember(int id) throws MyException {
        Map map = memberService.getAllMember(id);
        if (map.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("Info", map);
    }

    @GetMapping("/getMemberByStuId")
    @ApiOperation(value = "通过学号获取成员信息", notes = "通过学号获取信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "学号", required = true)
    private R getMemberByStuId(String id) throws MyException {
        Member member = memberService.getMemberByStuId(id);
        if (member == null) {
            throw new MyException(ResultCode.GET_ERROR);
        }
        return R.ok().data("items", member);
    }

    @PostMapping(value = "/addMember",produces ="application/json")
    @ApiOperation(value = "添加团队成员信息", notes = "添加信息", httpMethod = "POST")
    private R addMember(@RequestBody Member member) throws MyException {
        int flag = 0;
        memberService.addMember(member);
        flag = member.getMember_id();
        if (flag != 0) {
            return R.ok().data("key", flag);
        }
        throw new MyException(ResultCode.POST_ERROR);
    }

    @DeleteMapping("/deleteMemberById")
    @ApiOperation(value = "通过ID删除成员", notes = "删除成员", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "成员ID", required = true)
    private R deleteMemberById(String id) throws MyException {
        int flag = 0;
        flag = memberService.deleteMemberById(id);
        if (flag != 0) {
            return R.ok();
        }
        throw new MyException(ResultCode.DELETE_ERROR);
    }

    @PutMapping(value = "/updateMemberById",produces = "application/json")
    @ApiOperation(value = "通过ID更新成员数据", notes = "通过ID更新数据", httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "要进行更新的成员的ID", required = true),
    })
    private R updateMemberById(String id, @RequestBody Member member) throws MyException {
        int flag = 0;
        flag = memberService.updateMemberById(id, member);
        if (flag != 0) {
            return R.ok();
        }
        throw new MyException(ResultCode.UPDATE_ERROR);
    }

    @GetMapping("/findMemberByCondition")
    @ApiImplicitParam(name = "birthday", value = "对成员生日的模糊查询")
    @ApiOperation(value = "模糊查询成员信息", notes = "通过条件查询信息", httpMethod = "GET")
    private R findMemberByCondition(Member member, String birthday) throws MyException {
        List<Member> memberList = null;
        memberList = memberService.findMemberByCondition(member, birthday);
        if (memberList.isEmpty()) {
            throw new MyException(ResultCode.GET_ERROR);
        } else
            return R.ok().data("items", memberList);
    }
}
