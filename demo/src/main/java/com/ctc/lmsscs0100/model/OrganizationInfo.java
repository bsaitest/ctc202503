package com.ctc.lmsscs0100.model;

/**
 * 組織情報モデルクラス
 */
public class OrganizationInfo {
    
    /** 会社ID */
    private String companyId;
    
    /** 組織ID */
    private String orgId;
    
    /** 社員ID */
    private String employeeId;
    
    /** 主務兼務フラグ */
    private String mainDutyFlag;
    
    /**
     * デフォルトコンストラクタ
     */
    public OrganizationInfo() {
    }
    
    /**
     * コンストラクタ
     * 
     * @param companyId 会社ID
     * @param orgId 組織ID
     * @param employeeId 社員ID
     * @param mainDutyFlag 主務兼務フラグ
     */
    public OrganizationInfo(String companyId, String orgId, String employeeId, String mainDutyFlag) {
        this.companyId = companyId;
        this.orgId = orgId;
        this.employeeId = employeeId;
        this.mainDutyFlag = mainDutyFlag;
    }
    
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
    
    /**
     * 社員IDを取得
     * 
     * @return 社員ID
     */
    public String getEmployeeId() {
        return employeeId;
    }
    
    /**
     * 社員IDを設定
     * 
     * @param employeeId 社員ID
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    /**
     * 主務兼務フラグを取得
     * 
     * @return 主務兼務フラグ
     */
    public String getMainDutyFlag() {
        return mainDutyFlag;
    }
    
    /**
     * 主務兼務フラグを設定
     * 
     * @param mainDutyFlag 主務兼務フラグ
     */
    public void setMainDutyFlag(String mainDutyFlag) {
        this.mainDutyFlag = mainDutyFlag;
    }
}
