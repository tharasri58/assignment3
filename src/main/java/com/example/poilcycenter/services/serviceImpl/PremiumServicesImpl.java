package com.example.poilcycenter.services.serviceImpl;

import com.example.poilcycenter.dao.PremiumMapping;
import com.example.poilcycenter.entity.CoveragePremiumMapping;
import com.example.poilcycenter.services.PremiumServices;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class PremiumServicesImpl implements PremiumServices {
    @Autowired
    PremiumMapping premiumMapping;
    @Override
    public List<CoveragePremiumMapping> getAllPremiumMapping() {
        return premiumMapping.getAllPremiumMapping();
    }

  @Override
    public int excuteQuery(Long stateId, List<Long> coverageID) throws SQLException {
        return premiumMapping.excuteQuery(stateId,coverageID);
    }
}
