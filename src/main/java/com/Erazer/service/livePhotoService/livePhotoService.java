package com.Erazer.service.livePhotoService;

import com.Erazer.pojo.Live_Photo;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface livePhotoService {
    List<Live_Photo> getAllLivePhoto();

    Live_Photo getLivePhotoById(int id);

    int addLivePhoto(Live_Photo live_photo);

    int deleteLivePhoto(int id);

    int updateLivePhoto(int id, Live_Photo live_photo);
}
