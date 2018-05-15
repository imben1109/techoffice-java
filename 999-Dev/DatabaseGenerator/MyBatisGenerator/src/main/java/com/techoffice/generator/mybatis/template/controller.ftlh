package ${metaMap.basePackage}.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ${metaMap.basePackage}.criteria.${javaClassName}Criteria;
import ${metaMap.basePackage}.entity.${javaClassName};
import ${metaMap.basePackage}.key.${javaClassName}Key;
import ${metaMap.basePackage}.service.${javaClassName}Service;


@Controller
@RequestMapping(value = "/${uncaptialJavaClassName}")
public class ${javaClassName}Controller{
	
	@Autowired
	private ${javaClassName}Service ${uncaptialJavaClassName}Service;
	
	@RequestMapping(value = "/search", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<${javaClassName}> search(@Valid @RequestBody ${javaClassName}Criteria ${uncaptialJavaClassName}Citeria){
		return ${uncaptialJavaClassName}Service.search(${uncaptialJavaClassName}Citeria);
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ${javaClassName} find(@Valid @RequestBody ${javaClassName}Key ${uncaptialJavaClassName}Key){
		return ${uncaptialJavaClassName}Service.find(${uncaptialJavaClassName}Key);
	}
	
	@RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void insert(@Valid @RequestBody ${javaClassName} ${uncaptialJavaClassName}){
		${uncaptialJavaClassName}Service.insert(${uncaptialJavaClassName});
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void update(@Valid @RequestBody ${javaClassName} ${uncaptialJavaClassName}){
		${uncaptialJavaClassName}Service.update(${uncaptialJavaClassName});
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void delete(@Valid @RequestBody ${javaClassName}Key ${uncaptialJavaClassName}Key){
		${uncaptialJavaClassName}Service.delete(${uncaptialJavaClassName}Key);
	}

}