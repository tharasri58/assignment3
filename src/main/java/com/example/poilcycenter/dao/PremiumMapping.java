package com.example.poilcycenter.dao;

import com.example.poilcycenter.entity.CoveragePremiumMapping;

import java.sql.SQLException;
import java.util.List;

public interface PremiumMapping {
    List<CoveragePremiumMapping> getAllPremiumMapping();
    int excuteQuery(Long stateId,List<Long>coverageID) throws SQLException;

}
