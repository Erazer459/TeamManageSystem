package com.Erazer.service.informService;

import com.Erazer.mapper.informMapper.informMapper;
import com.Erazer.pojo.Inform;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class informServiceImpl implements informService {
    @Resource
    informMapper informMapper;

    @Override
    public List<Inform> getAllInform() {
        return informMapper.getAllInform();
    }

    @Override
    public Inform getInformById(int id) {
        return informMapper.getInformById(id);
    }

    @Override
    public int addInform(Inform inform) {
        return informMapper.addInform(inform);
    }

    @Override
    public int deleteInform(int id) {
        return informMapper.deleteInform(id);
    }

    @Override
    public int updateInform(int id, Inform inform) {
        return informMapper.updateInform(id, inform);
    }
}
