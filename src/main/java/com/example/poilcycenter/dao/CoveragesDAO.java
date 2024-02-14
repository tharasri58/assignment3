package com.example.poilcycenter.dao;

import com.example.poilcycenter.entity.Coverage;
import com.example.poilcycenter.entity.Policy;

import java.util.List;

public interface CoveragesDAO {
    List<Coverage> getAllCoverages();
    Coverage getById(Long id);
}
