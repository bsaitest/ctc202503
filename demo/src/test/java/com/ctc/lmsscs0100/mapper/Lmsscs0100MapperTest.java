package com.ctc.lmsscs0100.mapper;

import org.apache.ibatis.session.SqlSession;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.ctc.lmsscs0100.model.OrganizationInfo;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class Lmsscs0100MapperTest {

    @Autowired
    private Lmsscs0100Mapper lmsscs0100Mapper;

    @Autowired
    private SqlSession sqlSession;

    @BeforeEach
    void setUp() {
        // テストデータのセットアップなどを行う
    }

    @Test
    void testGetOrganizationInfoByEmployeeId() {
        String employeeId = "e01";
        String mainDutyFlag = "0";

        OrganizationInfo organizationInfo = lmsscs0100Mapper.getOrganizationInfoByEmployeeId(employeeId, mainDutyFlag);

        assertNotNull(organizationInfo);
        System.out.println(organizationInfo.getCompanyId());
        System.out.println(organizationInfo.getOrgId());
        assertEquals("c01", organizationInfo.getCompanyId());
        assertEquals("org01", organizationInfo.getOrgId());
    }
}