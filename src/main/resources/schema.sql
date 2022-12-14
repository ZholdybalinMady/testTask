CREATE OR REPLACE TABLE EMPLOYEE (
    MITARBEITER_ID INTEGER   NOT NULL AUTO_INCREMENT,
    TEAM_ID INTEGER   NOT NULL,
    SALARY INTEGER,
    PRIMARY KEY(MITARBEITER_ID)
);
CREATE OR REPLACE TABLE WORK_PERIOD(
    ID INTEGER   NOT NULL AUTO_INCREMENT,
    EMPLOYEE_MITARBEITER_ID INTEGER,
    TEAM_ID INTEGER NOT NULL,
    WORK_DATE TIMESTAMP,
    WORK_YEAR INTEGER,
    WORK_MONTH INTEGER,
    DAY_SALARY FLOAT,
    PRIMARY KEY(ID),
   FOREIGN KEY (EMPLOYEE_MITARBEITER_ID) REFERENCES EMPLOYEE(MITARBEITER_ID)
);
