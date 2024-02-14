package com.example.poilcycenter.services.serviceImpl;

import com.example.poilcycenter.dao.daoImpl.StateDAOImpl;
import com.example.poilcycenter.entity.State;
import com.example.poilcycenter.services.StateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServicesImpl implements StateServices {
    @Autowired
    StateDAOImpl stateDAO;

    @Override
    public List<State> getAllStates() {
        return stateDAO.getAllStates();
    }

    @Override
    public State getById(Long id) {
        return stateDAO.getById(id);
    }
}
