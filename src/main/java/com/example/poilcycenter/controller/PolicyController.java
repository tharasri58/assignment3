package com.example.poilcycenter.controller;

import com.example.poilcycenter.entity.Coverage;
import com.example.poilcycenter.entity.Policy;
import com.example.poilcycenter.entity.State;
import com.example.poilcycenter.services.PolicyServices;
import com.example.poilcycenter.services.PremiumServices;
import com.example.poilcycenter.services.serviceImpl.CoverageServiceImpl;
import com.example.poilcycenter.services.serviceImpl.PolicyServiceImpl;
import com.example.poilcycenter.services.serviceImpl.StateServicesImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")

public class PolicyController {
    @Autowired
    PolicyServiceImpl policyService;
    @Autowired
    CoverageServiceImpl coverageService;
    @Autowired
    StateServicesImpl stateServices;
    @Autowired
    PremiumServices premiumServices;
    @GetMapping("getAllPolicy")
    public String getAllPolicy(Model model){
        model.addAttribute("policy",policyService.getAllpolicy());
        return "viewPolicy";
    }
        @GetMapping("/addPolicy")
        public String addPolicy(Model model) {
            Policy policy = new Policy("Draft");
            model.addAttribute("policy", policy);
            model.addAttribute("defstate",stateServices.getAllStates());
            //model.addAttribute("coveragesList", coverageService.getAllCoverages());
            return "policy-form";
        }

        @PostMapping("/savePolicy")
        public String savePolicy(@ModelAttribute Policy policy, @RequestParam("state") String stateId) {
           State states = stateServices.getById(Long.parseLong(stateId));
           policy.getAddress().setState(states);
            policyService.savePolicy(policy);
            return "redirect:/addCoverage/"+policy.getId();
        }
    @GetMapping("/addCoverage/{id}")
    public String addCoverage(Model model,@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        model.addAttribute("policy", policy);
        model.addAttribute("coveragesList", coverageService.getAllCoverages());
        return "coverage-form";
    }
    @PostMapping("/saveCoverages/{id}")
    public String saveCoverage(@RequestParam("coverages[]") String coverages[],@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        for(String cId: coverages){
            Coverage tempCoverage = coverageService.getById(Long.parseLong(cId));
            policy.getCoverages().add(tempCoverage);
        }
        policyService.savePolicy(policy);
        return "redirect:/premium/"+policy.getId();
    }
    @GetMapping("/premium/{id}")
    public String addPremium(Model model,@PathVariable Long id) throws SQLException {
        Policy policy = policyService.getPolicyById(id);
        model.addAttribute("policy", policy);
        List<Long> coverageId = new ArrayList<>();
        for(Coverage cId : policy.getCoverages()) {
            coverageId.add(cId.getId());
        }
        Long stateID = policy.getAddress().getState().getId();
        int rate= premiumServices.excuteQuery(stateID,coverageId);
        model.addAttribute("rate",rate);
        policy.setPremium(rate);
        policy.setStatus("Bound");
        policyService.savePolicy(policy);
        return "premium-form";
    }
    @PostMapping("/savePremium/{id}")
    public String savePremium(@PathVariable("id") Long id){
        Policy policy = policyService.getPolicyById(id);
        return "redirect:/getAllPolicy";
    }
    }

