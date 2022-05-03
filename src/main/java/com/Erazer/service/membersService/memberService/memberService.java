package com.Erazer.service.membersService.memberService;

import com.Erazer.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface memberService {
    Map getAllMember(int id);

    Member getMemberByStuId(String id);

    int addMember(Member member);

    int deleteMemberById(String id);

    int updateMemberById(String id, @Param("Member") Member member);

    List<Member> findMemberByCondition(Member membe, String birthday);
}
