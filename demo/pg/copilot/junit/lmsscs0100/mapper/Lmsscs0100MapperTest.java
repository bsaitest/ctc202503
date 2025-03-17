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
        String employeeId = "testEmployeeId";
        String mainDutyFlag = "0";

        OrganizationInfo organizationInfo = lmsscs0100Mapper.getOrganizationInfoByEmployeeId(employeeId, mainDutyFlag);

        assertNotNull(organizationInfo);
        assertEquals("testCompanyId", organizationInfo.getCompanyId());
        assertEquals("testOrgId", organizationInfo.getOrgId());
    }
}