<select id="getOrganizationInfoByEmployeeId" resultType="OrganizationInfo">
    SELECT 
        um.company_id AS companyId,
        um.unit_id AS orgId
    FROM 
        unitbelong_mstr ubm
    JOIN 
        unit_mstr um ON ubm.company_unit_id = um.unit_mstr_id
    WHERE 
        ubm.emp_id = #{employeeId}
        AND ubm.super_unit_id = '0'
</select>