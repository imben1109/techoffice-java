# AspectJ
In order to run with AspectJ, Javaagent should be used. 

-javaagent:<path>\<aspectjweaver>.jar

Besides, aop.xml should be placed in <classPath>/META-INF/aop.xml

aop.xml
```
<aspectj>
  <aspects>
   <aspect name ="com.techoffice.example.ApplAspect"/>
  </aspects>
 
  <weaver options="-verbose -debug -showWeaveInfo">
   <include within ="com.techoffice..*"/>
  </weaver>
 
</aspectj>
```

