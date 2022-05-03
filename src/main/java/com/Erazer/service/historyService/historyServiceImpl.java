package com.Erazer.service.historyService;

import com.Erazer.mapper.historyMapper.historyMapper;
import com.Erazer.pojo.History;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class historyServiceImpl implements historyService {
    @Resource
    historyMapper historyMapper;

    @Override
    public List<History> getAllHistory() {
        return historyMapper.getAllHistory();
    }

    @Override
    public int addHistory(History history) {
        return historyMapper.addHistory(history);
    }

    @Override
    public int deleteHistory(int id) {
        return historyMapper.deleteHistory(id);
    }

    @Override
    public int updateHistory(int id, History history) {
        return historyMapper.updateHistory(id, history);
    }

    @Override
    public History getHistoryById(int id) {
        return historyMapper.getHistoryById(id);
    }
}
