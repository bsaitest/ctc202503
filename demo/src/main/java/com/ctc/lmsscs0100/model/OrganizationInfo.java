package com.ctc.lmsscs0100.model;

/**
 * 組織情報モデルクラス
 */
public class OrganizationInfo {
    
    /** 会社ID */
    private String companyId;
    
    /** 組織ID */
    private String orgId;
 
  
    
    /**
     * 会社IDを取得
     * 
     * @return 会社ID
     */
    public String getCompanyId() {
        return companyId;
    }
    
    /**
     * 会社IDを設定
     * 
     * @param companyId 会社ID
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    
    /**
     * 組織IDを取得
     * 
     * @return 組織ID
     */
    public String getOrgId() {
        return orgId;
    }
    
    /**
     * 組織IDを設定
     * 
     * @param orgId 組織ID
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
   
}
