package com.Erazer.mapper.historyMapper;

import com.Erazer.pojo.History;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface historyMapper {
    List<History> getAllHistory();

    int addHistory(History history);

    int deleteHistory(int id);

    int updateHistory(@Param("id") int id, @Param("History") History history);

    History getHistoryById(int id);
}
