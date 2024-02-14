package com.example.poilcycenter.dao.daoImpl;

import com.example.poilcycenter.dao.PolicyDOA;
import com.example.poilcycenter.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyDoaImpl implements PolicyDOA {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Policy> getAllpolicy() {
        TypedQuery query = entityManager.createQuery("from Policy",Policy.class);
        return query.getResultList();
    }
@Transactional
    @Override
    public Policy savePoilcy(Policy policy) {
        return entityManager.merge(policy);
    }

    @Override
    public Policy getById(Long id) {
        return entityManager.find(Policy.class,id);
    }
}
