package com.ctc.lmsscs0100.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ctc.lmsscs0100.model.OrganizationInfo;

/**
 * ログインスタブ画面のマッパーインターフェース
 */
@Mapper
public interface Lmsscs0100Mapper {
    /**
     * 社員IDに基づいて組織情報を取得
     * @param employeeId 社員ID
     * @param mainDutyFlag 主務兼務フラグ
     * @return 組織情報
     */
    OrganizationInfo getOrganizationInfoByEmployeeId(@Param("employeeId") String employeeId, @Param("mainDutyFlag") String mainDutyFlag);
}