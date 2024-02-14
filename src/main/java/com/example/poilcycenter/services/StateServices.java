package com.example.poilcycenter.services;

import com.example.poilcycenter.entity.State;

import java.util.List;

public interface StateServices {
    List<State> getAllStates();
    State getById(Long id);
}
