package com.example.poilcycenter.services;

import com.example.poilcycenter.entity.Policy;

import java.util.List;

public interface PolicyServices {
    List<Policy> getAllpolicy();
    Policy savePolicy(Policy policy);
    Policy getPolicyById(Long id);
}
