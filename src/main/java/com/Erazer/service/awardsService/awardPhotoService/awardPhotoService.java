package com.Erazer.service.awardsService.awardPhotoService;

import com.Erazer.pojo.Award_Photo;

import java.util.List;

public interface awardPhotoService {
    List<Award_Photo> getAllAwardPhotos();

    int addAwardPhoto(Award_Photo award_photo);

    int deleteAwardPhoto(int id);

    int updateAwardPhoto(int id, Award_Photo award_photo);

    Award_Photo getAwardPhotoById(int id);
}
