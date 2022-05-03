package com.Erazer.mapper.informMapper;

import com.Erazer.pojo.Inform;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface informMapper {
    List<Inform> getAllInform();

    Inform getInformById(int id);

    int addInform(Inform inform);

    int deleteInform(int id);

    int updateInform(@Param("id") int id, @Param("Inform") Inform inform);
}
