package ${metaMap.basePackage}.dao;

import java.util.List;

import ${metaMap.basePackage}.criteria.${javaClassName}Criteria;
import ${metaMap.basePackage}.entity.${javaClassName};
import ${metaMap.basePackage}.key.${javaClassName}Key;

public interface ${javaClassName}Dao {

	public List<${javaClassName}> search(${javaClassName}Criteria ${uncaptialJavaClassName}Criteria);
	public ${javaClassName} find(${javaClassName}Key ${uncaptialJavaClassName}Key);
	public int insert(${javaClassName} ${uncaptialJavaClassName});
	public int update(${javaClassName} ${uncaptialJavaClassName});
	public int delete(${javaClassName}Key ${uncaptialJavaClassName}Key);
	
}