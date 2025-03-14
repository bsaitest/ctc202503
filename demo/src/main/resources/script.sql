-- PostgreSQL Table Creation Scripts for LMS Database

-- Table: unit_mstr (組織マスタ)
CREATE TABLE unit_mstr (
    unit_mstr_id SERIAL,
    company_id VARCHAR(10) NOT NULL,
    unit_id VARCHAR(10) NOT NULL,
    unit_name VARCHAR(50),
    super_unit_id INTEGER,
    create_datetime DATE,
    create_user_id VARCHAR(10),
    create_program_id VARCHAR(20),
    update_datetime DATE,
    update_user_id VARCHAR(10),
    update_program_id VARCHAR(20),
    PRIMARY KEY (unit_mstr_id),
    CONSTRAINT fk_unit_mstr_super_unit_id FOREIGN KEY (super_unit_id) REFERENCES unit_mstr (unit_mstr_id)
);
COMMENT ON TABLE unit_mstr IS '組織マスタ';

-- Table: emp_mstr (社員マスタ)
CREATE TABLE emp_mstr (
    emp_id VARCHAR(10),
    emp_rank_id VARCHAR(10),
    emp_num VARCHAR(10),
    speciality_id VARCHAR(10),
    join_date DATE,
    create_datetime DATE,
    create_user_id VARCHAR(10),
    create_program_id VARCHAR(20),
    update_datetime DATE,
    update_user_id VARCHAR(10),
    update_program_id VARCHAR(20),
    PRIMARY KEY (emp_id)
);
COMMENT ON TABLE emp_mstr IS '社員マスタ';

-- Table: unitbelong_mstr (所属マスタ)
CREATE TABLE unitbelong_mstr (
    unitbelong_mstr_id SERIAL,
    emp_id VARCHAR(10) NOT NULL,
    company_unit_id INTEGER NOT NULL,
    post_role_id VARCHAR(10),
    super_unit_id VARCHAR(255) NOT NULL,
    create_datetime DATE,
    create_user_id VARCHAR(10),
    create_program_id VARCHAR(20),
    update_datetime DATE,
    update_user_id VARCHAR(10),
    update_program_id VARCHAR(20),
    PRIMARY KEY (unitbelong_mstr_id),
    CONSTRAINT fk_unitbelong_mstr_emp_id FOREIGN KEY (emp_id) REFERENCES emp_mstr (emp_id),
    CONSTRAINT fk_unitbelong_mstr_company_unit_id FOREIGN KEY (company_unit_id) REFERENCES unit_mstr (unit_mstr_id)
);
COMMENT ON TABLE unitbelong_mstr IS '所属マスタ';