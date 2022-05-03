package com.Erazer.service.leadInspectionService;

import com.Erazer.mapper.leadInspectionMapper.leadInspectionMapper;
import com.Erazer.pojo.Lead_Inspection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class leadInspectionServiceImpl implements leadInspectionService {
    @Resource
    leadInspectionMapper mapper;

    @Override
    public List<Lead_Inspection> getAllLeadInsp() {
        return mapper.getAllLeadInsp();
    }

    @Override
    public Lead_Inspection getLeadInspById(int id) {
        return mapper.getLeadInspById(id);
    }

    @Override
    public int addLeadInsp(Lead_Inspection lead_inspection) {
        return mapper.addLeadInsp(lead_inspection);
    }

    @Override
    public int deleteLeadInsp(int id) {
        return mapper.deleteLeadInsp(id);
    }

    @Override
    public int updateLeadInsp(int inspId, Lead_Inspection lead_inspection) {
        return mapper.updateLeadInsp(inspId, lead_inspection);
    }
}
