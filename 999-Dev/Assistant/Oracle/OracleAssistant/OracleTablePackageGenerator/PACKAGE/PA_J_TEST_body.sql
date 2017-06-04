CREATE OR REPLACE PACKAGE BODY PA_J_TEST AS 

  PROCEDURE P_INS_TEST (
    P_IN_ID         NUMBER    ,
    P_IN_AGE        NUMBER    ,
    P_IN_ADDRESS    VARCHAR2  ,
    P_IN_PHONE      VARCHAR2  
  ) AS 
  BEGIN
    INSERT INTO TEST (
      ID,
      AGE,
      ADDRESS,
      PHONE
    ) VALUES (
      P_IN_ID   ,
      P_IN_AGE  ,
      P_IN_ADDRESS,
      P_IN_PHONE
    );
  END;


  PROCEDURE P_SEA_TEST ( 
    P_IN_ID               IN  NUMBER    ,
    P_IN_AGE              IN  NUMBER    ,
    P_IN_ADDRESS          IN  VARCHAR2  ,
    P_IN_PHONE            IN  VARCHAR2  ,
    P_IN_CURRENT_PAGE     IN  NUMBER    ,
    P_IN_PAGE_SIZE        IN  NUMBER    ,
    P_OUT_RESULT_CUR      OUT SYS_REFCURSOR
  ) AS
  BEGIN
    OPEN P_OUT_RESULT_CUR FOR 
      SELECT * FROM (
        SELECT
          ID,
          AGE,
          ADDRESS,
          PHONE,
          rownum row_num,
          count(1) over () total
        FROM TEST
        WHERE          (P_IN_ID IS NULL OR ID LIKE '%' || P_IN_ID || '%')
          AND          (P_IN_AGE IS NULL OR AGE LIKE '%' || P_IN_AGE || '%')
          AND          (P_IN_ADDRESS IS NULL OR ADDRESS LIKE '%' || P_IN_ADDRESS || '%')
          AND          (P_IN_PHONE IS NULL OR PHONE LIKE '%' || P_IN_PHONE || '%')
      )  
      WHERE 1 = 1
        AND (P_IN_PAGE_SIZE IS NULL OR P_IN_CURRENT_PAGE IS NULL 
               OR ROW_NUM 
                 BETWEEN 1 + (P_IN_CURRENT_PAGE - 1) * P_IN_PAGE_SIZE 
                 AND P_IN_CURRENT_PAGE * P_IN_PAGE_SIZE
        )
    ;
  END;
    
    
  

  PROCEDURE P_UPD_TEST ( 
    P_IN_ID         NUMBER    ,
    P_IN_AGE        NUMBER    ,
    P_IN_ADDRESS    VARCHAR2  ,
    P_IN_PHONE      VARCHAR2  
  ) AS
  BEGIN
    UPDATE TEST SET
         ID = P_IN_ID,
         AGE = P_IN_AGE,
         ADDRESS = P_IN_ADDRESS,
         PHONE = P_IN_PHONE
    WHERE ID = P_IN_ID ;
  END;
  

  PROCEDURE P_DEL_TEST ( 
    P_IN_ID         NUMBER    
  ) AS
  BEGIN
    DELETE TEST
      WHERE ID = P_IN_ID ;
  END;
  

END PA_J_TEST;

