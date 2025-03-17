package com.ctc.lmsscs0100.service;

import com.ctc.lmsscs0100.mapper.Lmsscs0100Mapper;
import com.ctc.lmsscs0100.model.LoginInfo;
import com.ctc.lmsscs0100.model.OrganizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * ログインスタブ画面のサービスクラス
 */
@Service
public class Lmsscs0100Service {

    private static final String SESSION_LOGIN_INFO = "loginInfo";
    private static final String MAIN_DUTY_FLAG = "0"; // 主務フラグ

    @Autowired
    private Lmsscs0100Mapper lmsscs0100Mapper;

    /**
     * 初期表示処理
     * @param session HTTPセッション
     * @return ログイン情報
     */
    public LoginInfo initialize(HttpSession session) {
        LoginInfo loginInfo = (LoginInfo) session.getAttribute(SESSION_LOGIN_INFO);
        if (loginInfo == null) {
            loginInfo = new LoginInfo();
        }
        return loginInfo;
    }

    /**
     * 学習者検索TOPへ画面遷移の際のセッション更新
     * @param employeeId 社員ID
     * @param session HTTPセッション
     */
    public void updateSessionForSearch(String employeeId, HttpSession session) {
        updateLoginSession(employeeId, session);
    }

    /**
     * 要検討リストへ画面遷移の際のセッション更新
     * @param employeeId 社員ID
     * @param session HTTPセッション
     */
    public void updateSessionForReviewList(String employeeId, HttpSession session) {
        updateLoginSession(employeeId, session);
    }

    /**
     * ログアウト処理
     * @param session HTTPセッション
     */
    public void logout(HttpSession session) {
        session.removeAttribute(SESSION_LOGIN_INFO);
    }

    /**
     * セッションのログイン情報を更新する共通メソッド
     * @param employeeId 社員ID
     * @param session HTTPセッション
     */
    private void updateLoginSession(String employeeId, HttpSession session) {
        if (employeeId != null && !employeeId.isEmpty()) {
            OrganizationInfo organizationInfo = lmsscs0100Mapper.getOrganizationInfoByEmployeeId(employeeId, MAIN_DUTY_FLAG);

            if (organizationInfo != null) {
                LoginInfo loginInfo = new LoginInfo();
                loginInfo.setEmployeeId(employeeId);
                loginInfo.setCompanyId(organizationInfo.getCompanyId());
                loginInfo.setOrganizationId(organizationInfo.getOrgId());
                session.setAttribute(SESSION_LOGIN_INFO, loginInfo);
            }
        }
    }
}