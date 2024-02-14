package com.example.poilcycenter.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CoveragePremiumMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rate")
    private int rate;
    @Column(name = "stateId")
    Long stateId;
    @Column(name="coverageID")
    Long CoverageID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getCoverageID() {
        return CoverageID;
    }

    public void setCoverageID(Long coverageID) {
        CoverageID = coverageID;
    }
}
