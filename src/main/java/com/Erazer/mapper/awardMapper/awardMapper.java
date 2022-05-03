package com.Erazer.mapper.awardMapper;

import com.Erazer.pojo.Award;
import com.Erazer.pojo.Award_Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface awardMapper {
    List<Award> getAllAward();

    int addAward(Award award);

    int deleteAward(int id);

    int updateAward(@Param("id") int id, @Param("Award") Award award);

    List<Award_Photo> getAwardPhoto(int id);
}
