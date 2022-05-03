package com.Erazer.service.awardsService.awardService;

import com.Erazer.pojo.Award;
import com.Erazer.pojo.Award_Photo;

import java.util.List;

public interface awardService {
    List<Award> getAllAward();

    int addAward(Award award);

    int deleteAward(int id);

    int updateAward(int id, Award award);

    List<Award_Photo> getAwardPhoto(int id);
}
