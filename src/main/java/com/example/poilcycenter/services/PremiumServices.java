package com.example.poilcycenter.services;

import com.example.poilcycenter.entity.CoveragePremiumMapping;

import java.sql.SQLException;
import java.util.List;

public interface PremiumServices {
    List<CoveragePremiumMapping> getAllPremiumMapping();
    int excuteQuery(Long stateId,List<Long>coverageID) throws SQLException;
}
