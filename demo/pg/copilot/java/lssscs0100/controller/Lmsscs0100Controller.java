package com.ctc.lmsscs0100.controller;

import com.ctc.lmsscs0100.model.LoginRequest;
import com.ctc.lmsscs0100.model.LoginInfo;
import com.ctc.lmsscs0100.service.Lmsscs0100Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * ログインスタブ画面のコントローラークラス
 */
@RestController
@RequestMapping("/lmsscs0100")
public class Lmsscs0100Controller {

    @Autowired
    private Lmsscs0100Service lmsscs0100Service;

    /**
     * 初期表示処理
     * @param session HTTPセッション
     * @return ログイン情報
     */
    @PostMapping(value = "/init", produces = "application/json")
    public LoginInfo init(HttpSession session) {
        return lmsscs0100Service.initialize(session);
    }

    /**
     * 学習者検索TOPへ画面遷移
     * @param loginRequest ログインリクエスト
     * @param session HTTPセッション
     */
    @PostMapping(value = "/navigateToSearch", produces = "application/json")
    public void navigateToSearch(@RequestBody LoginRequest loginRequest, HttpSession session) {
        lmsscs0100Service.updateSessionForSearch(loginRequest.getEmployeeId(), session);
    }

    /**
     * 要検討リストへ画面遷移
     * @param loginRequest ログインリクエスト
     * @param session HTTPセッション
     */
    @PostMapping(value = "/navigateToReviewList", produces = "application/json")
    public void navigateToReviewList(@RequestBody LoginRequest loginRequest, HttpSession session) {
        lmsscs0100Service.updateSessionForReviewList(loginRequest.getEmployeeId(), session);
    }

    /**
     * ログアウト処理
     * @param session HTTPセッション
     */
    @PostMapping(value = "/logout", produces = "application/json")
    public void logout(HttpSession session) {
        lmsscs0100Service.logout(session);
    }
}