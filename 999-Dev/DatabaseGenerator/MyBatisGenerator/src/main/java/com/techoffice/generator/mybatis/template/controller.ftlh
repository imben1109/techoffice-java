
@Controller
@RequestMapping(value = "/${uncaptialJavaClassName}")
public class ${javaClassName}Service{
	
	private ${javaClassName}Service ${uncaptialJavaClassName}Service;
	
	@RequestMapping(value = "/search${JavaClassName}", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<${JavaClassName}> search${JavaClassName}(@Valid @RequestBody ${JavaClassName}Criteria ${uncaptialJavaClassName}Citeria){
		return ${uncaptialJavaClassName}Service.search(${uncaptialJavaClassName}Citeria);
	}
	
	@RequestMapping(value = "/find", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ${JavaClassName} find(@Valid @RequestBody ${JavaClassName}Key ${uncaptialJavaClassName}Key){
		return ${uncaptialJavaClassName}Service.find(${uncaptialJavaClassName}Key);
	}
	
	@RequestMapping(value = "/insert", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void insert(@Valid @RequestBody ${JavaClassName} ${uncaptialJavaClassName}){
		${uncaptialJavaClassName}Service.insert(${uncaptialJavaClassName});
	}
	
	@RequestMapping(value = "/update", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void update(@Valid @RequestBody ${JavaClassName} ${uncaptialJavaClassName}){
		${uncaptialJavaClassName}Service.update(${uncaptialJavaClassName});
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.POST}, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public void delete(@Valid @RequestBody ${JavaClassName}Key ${uncaptialJavaClassName}Key){
		${uncaptialJavaClassName}Service.update(${uncaptialJavaClassName}Key);
	}

}