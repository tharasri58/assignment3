package com.example.poilcycenter.dao;

import com.example.poilcycenter.PoilcycenterApplication;
import com.example.poilcycenter.entity.Policy;

import java.util.List;

public interface PolicyDOA {
    List<Policy> getAllpolicy();
    Policy savePoilcy(Policy policy);
    Policy getById(Long id);
}
