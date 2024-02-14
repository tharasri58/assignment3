package com.example.poilcycenter.dao;

import com.example.poilcycenter.entity.Coverage;
import com.example.poilcycenter.entity.State;

import java.util.List;

public interface StateDAO {
    List<State> getAllStates();
    State getById(Long id);
}
