package com.Erazer.service.membersService.memberAwardService;

import com.Erazer.mapper.memberAwardMapper.memberAwardMapper;
import com.Erazer.pojo.Award;
import com.Erazer.pojo.MemberAward;
import com.Erazer.pojo.Member_Award;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class memberAwardServiceImpl implements memberAwardService {
    @Resource
    memberAwardMapper mapper;

    @Override
    public List<MemberAward> getAllMemberAwardMsg() {
        return mapper.getAllMemberAwardMsg();
    }

    @Override
    public int deleteMemberAwardMsg(int aId, int mId) {
        return mapper.deleteMemberAwardMsg(aId, mId);
    }

    @Override
    public int updateMemberAwardMsg(int mId, int aId, int award_id, int member_id) {
        return mapper.updateMemberAwardMsg(mId, aId, award_id, member_id);
    }

    @Override
    public List<Award> getMemberAwardByMemberId(int id) {
        return mapper.getMemberAwardByMemberId(id);
    }

    @Override
    public Member_Award MemberAwardExist(Member_Award member_award) {
        return mapper.MemberAwardExist(member_award);
    }

    @Override
    public int addMemberAwardMsg(Member_Award ma) {
        return mapper.addMemberAwardMsg(ma);
    }
}
