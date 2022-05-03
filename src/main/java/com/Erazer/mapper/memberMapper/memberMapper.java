package com.Erazer.mapper.memberMapper;

import com.Erazer.pojo.Member;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface memberMapper {

    List<Member> getAllMember();

    Member getMemberByStuId(String id);

    int addMember(Member member);

    int deleteMemberById(String id);

    int updateMemberById(@Param("id") String id, @Param("Member") Member member);

    List<Member> findMemberByCondition(@Param("Member") Member member, @Param("birthday") String birthday);
}
