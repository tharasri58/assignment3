package com.example.poilcycenter.services.serviceImpl;

import com.example.poilcycenter.dao.daoImpl.CoveragesDAOImpl;
import com.example.poilcycenter.entity.Coverage;
import com.example.poilcycenter.services.CoverageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoverageServiceImpl implements CoverageServices {
    @Autowired
    CoveragesDAOImpl coveragesDAO;
    @Override
    public List<Coverage> getAllCoverages() {
        return coveragesDAO.getAllCoverages();
    }

    @Override
    public Coverage getById(Long id) {
        return coveragesDAO.getById(id);
    }
}
