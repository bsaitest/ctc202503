package com.ctc.lmsscs0100.model;

/**
 * ログインリクエストモデルクラス
 */
public class LoginRequest {
    private String employeeId;  // 社員ID

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}