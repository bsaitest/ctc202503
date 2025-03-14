package com.ctc.lmsscs0100.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctc.lmsscs0100.model.LoginInfo;
import com.ctc.lmsscs0100.model.LoginRequest;
import com.ctc.lmsscs0100.service.Lmsscs0100Service;

import jakarta.servlet.http.HttpSession;

// import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/lmsscs0100")
public class Lmsscs0100Controller {

    @Autowired
    private Lmsscs0100Service lmsscs0100Service;

    @PostMapping("/init")
    public LoginInfo init(HttpSession session) {
        return lmsscs0100Service.initialize(session);
    }

    @PostMapping("/navigateToSearch")
    public void navigateToSearch(@RequestBody LoginRequest loginRequest, HttpSession session) {
        lmsscs0100Service.updateSessionForSearch(loginRequest.getEmployeeId(), session);
    }

    @PostMapping("/navigateToReviewList")
    public void navigateToReviewList(@RequestBody LoginRequest loginRequest, HttpSession session) {
        lmsscs0100Service.updateSessionForReviewList(loginRequest.getEmployeeId(), session);
    }

    @PostMapping("/logout")
    public LoginInfo logout(HttpSession session) {
        return lmsscs0100Service.logout(session);
    }
}