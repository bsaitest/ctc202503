package com.ctc.lmsscs0100.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ctc.lmsscs0100.model.OrganizationInfo;

@Mapper
public interface Lmsscs0100Mapper {
    OrganizationInfo getOrganizationInfoByEmployeeId(@Param("employeeId") String employeeId, @Param("flag") String flag);
}