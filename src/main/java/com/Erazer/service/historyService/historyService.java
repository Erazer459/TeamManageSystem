package com.Erazer.service.historyService;

import com.Erazer.pojo.History;

import java.util.List;

public interface historyService {
    List<History> getAllHistory();

    int addHistory(History history);

    int deleteHistory(int id);

    int updateHistory(int id, History history);

    History getHistoryById(int id);
}
