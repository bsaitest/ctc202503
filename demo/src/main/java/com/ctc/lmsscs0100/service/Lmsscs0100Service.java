package com.ctc.lmsscs0100.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.lmsscs0100.mapper.Lmsscs0100Mapper;
import com.ctc.lmsscs0100.model.LoginInfo;
import com.ctc.lmsscs0100.model.OrganizationInfo;

import jakarta.servlet.http.HttpSession;


@Service
public class Lmsscs0100Service {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Lmsscs0100Mapper lmsscs0100Mapper;

    public LoginInfo initialize(HttpSession session) {
        // 初期表示処理
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        if (loginInfo == null) {
            loginInfo = new LoginInfo();
        }
        logger.info(loginInfo.getEmployeeId() + " is logged in.");
        return loginInfo;
    }

    public LoginInfo updateSessionForSearch(String employeeId, HttpSession session) {
        LoginInfo loginInfo = new LoginInfo();
        if (employeeId != null && !employeeId.isEmpty()) {
            OrganizationInfo organizationInfo = lmsscs0100Mapper.getOrganizationInfoByEmployeeId(employeeId, "0");

            if (organizationInfo != null) {
                loginInfo.setEmployeeId(employeeId);
                loginInfo.setCompanyId(organizationInfo.getCompanyId());
                loginInfo.setOrganizationId(organizationInfo.getOrgId());
                session.setAttribute("loginInfo", loginInfo);
            }
        }
        logger.info(loginInfo.getEmployeeId() + " is logged in.");
        return loginInfo;
    }

    public LoginInfo updateSessionForReviewList(String employeeId, HttpSession session) {
        LoginInfo loginInfo = new LoginInfo();
        if (employeeId != null && !employeeId.isEmpty()) {
            OrganizationInfo organizationInfo = lmsscs0100Mapper.getOrganizationInfoByEmployeeId(employeeId, "0");

            if (organizationInfo != null) {
                loginInfo.setEmployeeId(employeeId);
                loginInfo.setCompanyId(organizationInfo.getCompanyId());
                loginInfo.setOrganizationId(organizationInfo.getOrgId());
                session.setAttribute("loginInfo", loginInfo);
            }
        }
        logger.info(loginInfo.getEmployeeId() + " is logged in.");
        return loginInfo;
    }

    public LoginInfo logout(HttpSession session) {
        // ログアウト処理
        LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
        if(loginInfo != null) {
            logger.info(loginInfo.getEmployeeId() + " is logged out.");
        }
        session.removeAttribute("loginInfo");
        return new LoginInfo();
    }
}