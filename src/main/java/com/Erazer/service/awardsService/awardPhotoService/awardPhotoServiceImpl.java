package com.Erazer.service.awardsService.awardPhotoService;

import com.Erazer.mapper.awardPhotoMapper.awardPhotoMapper;
import com.Erazer.pojo.Award_Photo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class awardPhotoServiceImpl implements awardPhotoService {
    @Resource
    awardPhotoMapper awardPhotoMapper;

    @Override
    public List<Award_Photo> getAllAwardPhotos() {
        return awardPhotoMapper.getAllAwardPhotos();
    }

    @Override
    public int addAwardPhoto(Award_Photo award_photo) {
        return awardPhotoMapper.addAwardPhoto(award_photo);
    }

    @Override
    public int deleteAwardPhoto(int id) {
        return awardPhotoMapper.deleteAwardPhoto(id);
    }

    @Override
    public int updateAwardPhoto(int id, Award_Photo award_photo) {
        return awardPhotoMapper.updateAwardPhoto(id, award_photo);
    }

    @Override
    public Award_Photo getAwardPhotoById(int id) {
        return awardPhotoMapper.getAwardPhotoById(id);
    }
}
