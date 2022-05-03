package com.Erazer.mapper.leadInspectionMapper;

import com.Erazer.pojo.Lead_Inspection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface leadInspectionMapper {
    List<Lead_Inspection> getAllLeadInsp();

    Lead_Inspection getLeadInspById(int id);

    int addLeadInsp(Lead_Inspection lead_inspection);

    int deleteLeadInsp(int id);

    int updateLeadInsp(@Param("inspId") int inspId, @Param("Lead_Inspection") Lead_Inspection lead_inspection);
}
