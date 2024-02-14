package com.example.poilcycenter.dao.daoImpl;

import com.example.poilcycenter.dao.PremiumMapping;
import com.example.poilcycenter.entity.CoveragePremiumMapping;
import com.example.poilcycenter.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.query.ResultListTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Service
public class PremiumMappingImpl implements PremiumMapping {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<CoveragePremiumMapping> getAllPremiumMapping() {
        TypedQuery query = entityManager.createQuery("from CoveragePremiumMapping ", CoveragePremiumMapping.class);
        return query.getResultList();
    }

    @Override
    public int excuteQuery(Long stateId, List<Long> coverageID) throws SQLException {
        int premium=0;
        for(Long cID:coverageID) {
            TypedQuery query = entityManager.createQuery("from CoveragePremiumMapping where CoverageID = " +cID+" and stateId ="+stateId,CoveragePremiumMapping.class);
            List<CoveragePremiumMapping> rate = query.getResultList();
            for(CoveragePremiumMapping coveragePremiumMapping : rate){
                premium+=coveragePremiumMapping.getRate();
            }
        }
        return premium;
    }
}
