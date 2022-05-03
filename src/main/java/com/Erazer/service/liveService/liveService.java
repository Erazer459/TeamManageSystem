package com.Erazer.service.liveService;

import com.Erazer.pojo.Live;
import com.Erazer.pojo.Live_Photo;

import java.util.List;

public interface liveService {
    List<Live> getAllLive();

    Live getLiveById(int id);

    int addLive(Live live);

    int deleteLive(int id);

    int updateLive(int id, Live live);

    List<Live_Photo> getLivePhotos(int id);
}
