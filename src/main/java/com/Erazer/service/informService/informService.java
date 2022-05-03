package com.Erazer.service.informService;

import com.Erazer.pojo.Inform;

import java.util.List;

public interface informService {
    List<Inform> getAllInform();

    Inform getInformById(int id);

    int addInform(Inform inform);

    int deleteInform(int id);

    int updateInform(int id, Inform inform);
}
