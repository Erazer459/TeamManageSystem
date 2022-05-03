package com.Erazer.mapper.memberAwardMapper;

import com.Erazer.pojo.Award;
import com.Erazer.pojo.MemberAward;
import com.Erazer.pojo.Member_Award;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface memberAwardMapper {
    List<MemberAward> getAllMemberAwardMsg();

    int deleteMemberAwardMsg(@Param("aId") int aId, @Param("mId") int mId);

    int updateMemberAwardMsg(@Param("mId") int mId, @Param("aId") int aId, @Param("award_id") int award_id, @Param("member_id") int member_id);

    List<Award> getMemberAwardByMemberId(int id);

    Member_Award MemberAwardExist(Member_Award member_award);

    int addMemberAwardMsg(Member_Award ma);
}
