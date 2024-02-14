package com.example.poilcycenter.services.serviceImpl;

import com.example.poilcycenter.dao.daoImpl.PolicyDoaImpl;
import com.example.poilcycenter.entity.Policy;
import com.example.poilcycenter.services.PolicyServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyServices {
    @Autowired
    PolicyDoaImpl policyService;
    @Override
    public List<Policy> getAllpolicy() {
        return policyService.getAllpolicy();
    }
    @Transactional
    @Override
    public Policy savePolicy(Policy policy) {
        return policyService.savePoilcy(policy);
    }

    @Override
    public Policy getPolicyById(Long id) {
        return policyService.getById(id);
    }

}
