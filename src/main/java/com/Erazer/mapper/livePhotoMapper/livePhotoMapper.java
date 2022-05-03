package com.Erazer.mapper.livePhotoMapper;

import com.Erazer.pojo.Live_Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface livePhotoMapper {
    List<Live_Photo> getAllLivePhoto();

    Live_Photo getLivePhotoById(int id);

    int addLivePhoto(Live_Photo live_photo);

    int deleteLivePhoto(int id);

    int updateLivePhoto(@Param("id") int id, @Param("Live_Photo") Live_Photo live_photo);
}
