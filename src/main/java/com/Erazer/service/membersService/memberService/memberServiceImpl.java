package com.Erazer.service.membersService.memberService;

import com.Erazer.mapper.memberMapper.memberMapper;

import com.Erazer.pojo.Member;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class memberServiceImpl implements memberService {
    @Resource
    memberMapper memberMapper;

    @Override
    public Map getAllMember(int id) {
        if (id == 0) {
            id = 1;
        }
        PageHelper.startPage(id, 5, true);
        List<Member> list = memberMapper.getAllMember();
        PageInfo<Member> pageInfo = new PageInfo<>(list);
        int i = pageInfo.getPages();
        Map<String, Object> Info = new HashMap();
        Info.put("items", list);
        Info.put("totalPage", i);
        return Info;
    }

    @Override
    public Member getMemberByStuId(String id) {
        return memberMapper.getMemberByStuId(id);
    }

    @Override
    public int addMember(Member member) {
        int flag = 0;
        flag = memberMapper.addMember(member);
        return flag;
    }

    @Override
    public int deleteMemberById(String id) {
        int flag = 0;
        flag = memberMapper.deleteMemberById(id);
        return flag;
    }

    @Override
    public int updateMemberById(String id, @Param("Member") Member member) {
        int flag = 0;
        flag = memberMapper.updateMemberById(id, member);
        return flag;
    }

    @Override
    public List<Member> findMemberByCondition(Member member, String birthday) {
        return memberMapper.findMemberByCondition(member, birthday);
    }
}
