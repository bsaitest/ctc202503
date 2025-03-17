package com.ctc.lmsscs0100.model;

import java.io.Serializable;

/**
 * ログイン情報モデルクラス
 */
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String employeeId;      // ログイン社員ID
    private String companyId;       // ログイン社員会社ID
    private String organizationId;  // ログイン社員組織ID

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}