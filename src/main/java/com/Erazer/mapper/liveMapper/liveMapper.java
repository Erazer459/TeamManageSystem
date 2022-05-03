package com.Erazer.mapper.liveMapper;

import com.Erazer.pojo.Live;
import com.Erazer.pojo.Live_Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface liveMapper {
    List<Live> getAllLive();

    Live getLiveById(int id);

    int addLive(Live live);

    int deleteLive(int id);

    int updateLive(@Param("id") int id, @Param("Live") Live live);

    List<Live_Photo> getLivePhotos(int id);
}
