package com.ctc.lmsscs0100.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.ctc.lmsscs0100.model.LoginInfo;
import com.ctc.lmsscs0100.model.LoginRequest;
import com.ctc.lmsscs0100.service.Lmsscs0100Service;

import jakarta.servlet.http.HttpSession;

class Lmsscs0100ControllerTest {

    @Mock
    private Lmsscs0100Service lmsscs0100Service;

    @Mock
    private HttpSession session;

    @InjectMocks
    private Lmsscs0100Controller lmsscs0100Controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInitialize() {
        LoginInfo loginInfo = new LoginInfo();
        when(lmsscs0100Service.initialize(session)).thenReturn(loginInfo);

        LoginInfo result = lmsscs0100Controller.init(session);

        assertNotNull(result);
        verify(lmsscs0100Service, times(1)).initialize(session);
    }

    @Test
    void testNavigateToSearch() {
        LoginRequest loginRequest = new LoginRequest();
        String employeeId = "e01";
        loginRequest.setEmployeeId("e01");

        
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setEmployeeId(employeeId);
        when(lmsscs0100Service.updateSessionForSearch(employeeId, session)).thenReturn(loginInfo);
        // doNothing().when(lmsscs0100Service).updateSessionForSearch(anyString(), any(HttpSession.class));

        lmsscs0100Controller.navigateToSearch(loginRequest, session);

        verify(lmsscs0100Service, times(1)).updateSessionForSearch(eq(employeeId), eq(session));
    }

    @Test
    void testNavigateToReviewList() {
        LoginRequest loginRequest = new LoginRequest();
        String employeeId = "e01";
        loginRequest.setEmployeeId("e01");

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setEmployeeId(employeeId);
        when(lmsscs0100Service.updateSessionForReviewList(employeeId, session)).thenReturn(loginInfo);
        // doNothing().when(lmsscs0100Service).updateSessionForReviewList(anyString(), any(HttpSession.class));

        lmsscs0100Controller.navigateToReviewList(loginRequest, session);

        verify(lmsscs0100Service, times(1)).updateSessionForReviewList(eq(employeeId), eq(session));
    }

    @Test
    void testLogout() {
        LoginInfo loginInfo = new LoginInfo();
        when(lmsscs0100Service.logout(session)).thenReturn(loginInfo);
        // doNothing().when(lmsscs0100Service).logout(any(HttpSession.class));

        lmsscs0100Controller.logout(session);

        verify(lmsscs0100Service, times(1)).logout(eq(session));
    }
}