package com.Erazer.service.membersService.memberAwardService;

import com.Erazer.pojo.Award;
import com.Erazer.pojo.MemberAward;
import com.Erazer.pojo.Member_Award;

import java.util.List;

public interface memberAwardService {
    List<MemberAward> getAllMemberAwardMsg();

    int deleteMemberAwardMsg(int aId, int mId);

    int updateMemberAwardMsg(int mId, int aId, int award_id, int member_id);

    List<Award> getMemberAwardByMemberId(int id);

    Member_Award MemberAwardExist(Member_Award member_award);

    int addMemberAwardMsg(Member_Award ma);
}
