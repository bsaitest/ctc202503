package com.ctc.lmsscs0100.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.ctc.lmsscs0100.mapper.Lmsscs0100Mapper;
import com.ctc.lmsscs0100.model.LoginInfo;
import com.ctc.lmsscs0100.model.OrganizationInfo;

import jakarta.servlet.http.HttpSession;

class Lmsscs0100ServiceTest {

    @Mock
    private Lmsscs0100Mapper lmsscs0100Mapper;

    @Mock
    private HttpSession session;

    @InjectMocks
    private Lmsscs0100Service lmsscs0100Service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInitialize() {
        LoginInfo loginInfo = new LoginInfo();
        when(session.getAttribute("loginInfo")).thenReturn(loginInfo);

        LoginInfo result = lmsscs0100Service.initialize(session);

        assertNotNull(result);
        assertEquals(loginInfo, result);
    }

    @Test
    void testUpdateSessionForSearch() {
        String employeeId = "e01";
        OrganizationInfo organizationInfo = new OrganizationInfo();
        organizationInfo.setCompanyId("c01");
        organizationInfo.setOrgId("org01");

        when(lmsscs0100Mapper.getOrganizationInfoByEmployeeId(employeeId, "0")).thenReturn(organizationInfo);

        LoginInfo result = lmsscs0100Service.updateSessionForSearch(employeeId, session);

        assertNotNull(result);
        assertEquals(employeeId, result.getEmployeeId());
        assertEquals("c01", result.getCompanyId());
        assertEquals("org01", result.getOrganizationId());
        verify(session, times(1)).setAttribute(eq("loginInfo"), any(LoginInfo.class));
    }

    @Test
    void testUpdateSessionForReviewList() {
        String employeeId = "e01";
        OrganizationInfo organizationInfo = new OrganizationInfo();
        organizationInfo.setCompanyId("c01");
        organizationInfo.setOrgId("org01");

        when(lmsscs0100Mapper.getOrganizationInfoByEmployeeId(employeeId, "0")).thenReturn(organizationInfo);

        LoginInfo result = lmsscs0100Service.updateSessionForReviewList(employeeId, session);

        assertNotNull(result);
        assertEquals(employeeId, result.getEmployeeId());
        assertEquals("c01", result.getCompanyId());
        assertEquals("org01", result.getOrganizationId());
        verify(session, times(1)).setAttribute(eq("loginInfo"), any(LoginInfo.class));
    }

    @Test
    void testLogout() {
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setEmployeeId("e01");
        when(session.getAttribute("loginInfo")).thenReturn(loginInfo);

        LoginInfo result = lmsscs0100Service.logout(session);

        assertNotNull(result);
        assertNull(result.getEmployeeId());
        verify(session, times(1)).removeAttribute("loginInfo");
    }
}