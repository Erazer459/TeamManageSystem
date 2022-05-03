package com.Erazer.service.livePhotoService;

import com.Erazer.mapper.livePhotoMapper.livePhotoMapper;
import com.Erazer.pojo.Live_Photo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class livePhotoServiceImpl implements livePhotoService {
    @Resource
    livePhotoMapper livePhotoMapper;

    @Override
    public List<Live_Photo> getAllLivePhoto() {
        return livePhotoMapper.getAllLivePhoto();
    }

    @Override
    public Live_Photo getLivePhotoById(int id) {
        return livePhotoMapper.getLivePhotoById(id);
    }

    @Override
    public int addLivePhoto(Live_Photo live_photo) {
        return livePhotoMapper.addLivePhoto(live_photo);
    }

    @Override
    public int deleteLivePhoto(int id) {
        return livePhotoMapper.deleteLivePhoto(id);
    }

    @Override
    public int updateLivePhoto(int id, Live_Photo live_photo) {
        return livePhotoMapper.updateLivePhoto(id, live_photo);
    }
}
