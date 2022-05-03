package com.Erazer.service.liveService;

import com.Erazer.mapper.liveMapper.liveMapper;
import com.Erazer.pojo.Live;
import com.Erazer.pojo.Live_Photo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class liveServiceImpl implements liveService {
    @Resource
    liveMapper liveMapper;

    @Override
    public List<Live> getAllLive() {
        return liveMapper.getAllLive();
    }

    @Override
    public Live getLiveById(int id) {
        return liveMapper.getLiveById(id);
    }

    @Override
    public int addLive(Live live) {
        return liveMapper.addLive(live);
    }

    @Override
    public int deleteLive(int id) {
        return liveMapper.deleteLive(id);
    }

    @Override
    public int updateLive(int id, Live live) {
        return liveMapper.updateLive(id, live);
    }

    @Override
    public List<Live_Photo> getLivePhotos(int id) {
        return liveMapper.getLivePhotos(id);
    }
}
