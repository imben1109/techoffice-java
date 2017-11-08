CREATE OR REPLACE PACKAGE BODY PA_J_TEST_SCALE AS 

  PROCEDURE P_INS_TEST_SCALE (
    P_IN_ID         NUMBER    
  ) AS 
  BEGIN
    INSERT INTO TEST_SCALE (
      ID
    ) VALUES (
      P_IN_ID   
    );
  END;


  PROCEDURE P_SEA_TEST_SCALE ( 
    P_IN_ID               IN  NUMBER    ,
    P_IN_CURRENT_PAGE     IN  NUMBER    ,
    P_IN_PAGE_SIZE        IN  NUMBER    ,
    P_OUT_RESULT_CUR      OUT SYS_REFCURSOR
  ) AS
  BEGIN
    OPEN P_OUT_RESULT_CUR FOR 
      SELECT * FROM (
        SELECT
          ID,
          rownum row_num,
          count(1) over () total
        FROM TEST_SCALE
        WHERE          (P_IN_ID IS NULL OR ID LIKE '%' || P_IN_ID || '%')
      )  
      WHERE 1 = 1
        AND (P_IN_PAGE_SIZE IS NULL OR P_IN_CURRENT_PAGE IS NULL 
               OR ROW_NUM 
                 BETWEEN 1 + (P_IN_CURRENT_PAGE - 1) * P_IN_PAGE_SIZE 
                 AND P_IN_CURRENT_PAGE * P_IN_PAGE_SIZE
        )
    ;
  END;
    
    
  

  PROCEDURE P_UPD_TEST_SCALE ( 
    P_IN_ID         NUMBER    
  ) AS
  BEGIN
    UPDATE TEST_SCALE SET
         ID = P_IN_ID
    WHERE ID = P_IN_ID ;
  END;
  

  PROCEDURE P_DEL_TEST_SCALE ( 
    P_IN_ID         NUMBER    
  ) AS
  BEGIN
    DELETE TEST_SCALE
      WHERE ID = P_IN_ID ;
  END;
  

END PA_J_TEST_SCALE;

