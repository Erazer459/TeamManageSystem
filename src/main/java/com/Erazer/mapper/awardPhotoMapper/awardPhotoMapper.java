package com.Erazer.mapper.awardPhotoMapper;

import com.Erazer.pojo.Award_Photo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface awardPhotoMapper {
    List<Award_Photo> getAllAwardPhotos();

    int addAwardPhoto(Award_Photo award_photo);

    int deleteAwardPhoto(int id);

    int updateAwardPhoto(@Param("id") int id, @Param("award_photo") Award_Photo award_photo);

    Award_Photo getAwardPhotoById(int id);
}
