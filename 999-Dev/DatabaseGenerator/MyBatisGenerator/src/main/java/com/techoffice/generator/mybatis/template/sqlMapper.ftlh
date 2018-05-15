<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC '-//mybatis.org//DTD Mapper 3.0//EN'
  'http://mybatis.org/dtd/mybatis-3-mapper.dtd'>
  
<mapper namespace="${metaMap.basePackage}.dao.${javaClassName}Dao">

<#include "sqlmapper/resultMap.ftlh">


<#include "sqlmapper/criteria.ftlh">


<#include "sqlmapper/search.ftlh">


<#include "sqlmapper/find.ftlh">


<#include "sqlmapper/insert.ftlh">


<#include "sqlmapper/update.ftlh">


<#include "sqlmapper/delete.ftlh">


</mapper>



