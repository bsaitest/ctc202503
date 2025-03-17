package com.ctc.lmsscs0100.model;

/**
 * 組織情報モデルクラス
 */
public class OrganizationInfo {
    private String companyId;   // 会社ID
    private String orgId;       // 組織ID

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}