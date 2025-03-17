package com.ctc.lmsscs0100.controller;

import com.ctc.lmsscs0100.model.LoginInfo;
import com.ctc.lmsscs0100.model.LoginRequest;
import com.ctc.lmsscs0100.service.Lmsscs0100Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        loginRequest.setEmployeeId("testEmployeeId");

        doNothing().when(lmsscs0100Service).updateSessionForSearch(anyString(), any(HttpSession.class));

        lmsscs0100Controller.navigateToSearch(loginRequest, session);

        verify(lmsscs0100Service, times(1)).updateSessionForSearch(eq("testEmployeeId"), eq(session));
    }

    @Test
    void testNavigateToReviewList() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmployeeId("testEmployeeId");

        doNothing().when(lmsscs0100Service).updateSessionForReviewList(anyString(), any(HttpSession.class));

        lmsscs0100Controller.navigateToReviewList(loginRequest, session);

        verify(lmsscs0100Service, times(1)).updateSessionForReviewList(eq("testEmployeeId"), eq(session));
    }

    @Test
    void testLogout() {
        doNothing().when(lmsscs0100Service).logout(any(HttpSession.class));

        lmsscs0100Controller.logout(session);

        verify(lmsscs0100Service, times(1)).logout(eq(session));
    }
}