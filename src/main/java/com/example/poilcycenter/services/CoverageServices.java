package com.example.poilcycenter.services;

import com.example.poilcycenter.entity.Coverage;

import java.util.List;

public interface CoverageServices {
    List<Coverage> getAllCoverages();
    Coverage getById(Long id);
}
