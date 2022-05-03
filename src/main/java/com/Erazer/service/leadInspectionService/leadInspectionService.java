package com.Erazer.service.leadInspectionService;

import com.Erazer.pojo.Lead_Inspection;

import java.util.List;

public interface leadInspectionService {
    List<Lead_Inspection> getAllLeadInsp();

    Lead_Inspection getLeadInspById(int id);

    int addLeadInsp(Lead_Inspection lead_inspection);

    int deleteLeadInsp(int id);

    int updateLeadInsp(int inspId, Lead_Inspection lead_inspection);
}
