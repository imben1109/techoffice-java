CREATE OR REPLACE PACKAGE PA_J_TEST AS 

  PROCEDURE P_INS_TEST (
    P_IN_ID         NUMBER    ,
    P_IN_AGE        NUMBER    ,
    P_IN_ADDRESS    VARCHAR2  ,
    P_IN_PHONE      VARCHAR2  
  ) ; 


  PROCEDURE P_SEA_TEST ( 
    P_IN_ID               IN  NUMBER    ,
    P_IN_AGE              IN  NUMBER    ,
    P_IN_ADDRESS          IN  VARCHAR2  ,
    P_IN_PHONE            IN  VARCHAR2  ,
    P_IN_CURRENT_PAGE     IN  NUMBER    ,
    P_IN_PAGE_SIZE        IN  NUMBER    ,
    P_OUT_RESULT_CUR      OUT SYS_REFCURSOR
  ) ;

  PROCEDURE P_UPD_TEST ( 
    P_IN_ID         NUMBER    ,
    P_IN_AGE        NUMBER    ,
    P_IN_ADDRESS    VARCHAR2  ,
    P_IN_PHONE      VARCHAR2  
  ) ;

  PROCEDURE P_DEL_TEST ( 
    P_IN_ID         NUMBER    
  ) ;
  

END PA_J_TEST;

