package ${metaMap.basePackage}.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ${metaMap.basePackage}.criteria.${javaClassName}Criteria;
import ${metaMap.basePackage}.dao.${javaClassName}Dao;
import ${metaMap.basePackage}.entity.${javaClassName};
import ${metaMap.basePackage}.key.${javaClassName}Key;

@Service
public class ${javaClassName}Service{
	
	@Autowired
	private ${javaClassName}Dao ${uncaptialJavaClassName}Dao;
	
	public List<${javaClassName}> search(${javaClassName}Criteria ${uncaptialJavaClassName}Criteria){
		return ${uncaptialJavaClassName}Dao.search(${uncaptialJavaClassName}Criteria);
	}
	
	public ${javaClassName} find(${javaClassName}Key ${uncaptialJavaClassName}Key){
		return ${uncaptialJavaClassName}Dao.find(${uncaptialJavaClassName}Key);
	}
	
	public int insert(${javaClassName} ${uncaptialJavaClassName}){
		return ${uncaptialJavaClassName}Dao.insert(${uncaptialJavaClassName});
	}
	
	public int update(${javaClassName} ${uncaptialJavaClassName}){
		return ${uncaptialJavaClassName}Dao.update(${uncaptialJavaClassName});
	}
	
	public int delete(${javaClassName}Key ${uncaptialJavaClassName}Key){
		return ${uncaptialJavaClassName}Dao.delete(${uncaptialJavaClassName}Key);
	}
}