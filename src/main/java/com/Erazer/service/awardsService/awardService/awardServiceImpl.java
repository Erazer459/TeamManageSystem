package com.Erazer.service.awardsService.awardService;

import com.Erazer.mapper.awardMapper.awardMapper;
import com.Erazer.pojo.Award;
import com.Erazer.pojo.Award_Photo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class awardServiceImpl implements awardService {
    @Resource
    awardMapper awardMapper;

    @Override
    public List<Award> getAllAward() {
        return awardMapper.getAllAward();
    }

    @Override
    public int addAward(Award award) {
        return awardMapper.addAward(award);
    }

    @Override
    public int deleteAward(int id) {
        return awardMapper.deleteAward(id);
    }

    @Override
    public int updateAward(int id, Award award) {
        return awardMapper.updateAward(id, award);
    }

    @Override
    public List<Award_Photo> getAwardPhoto(int id) {
        return awardMapper.getAwardPhoto(id);
    }
}
