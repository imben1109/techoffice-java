
@Service
public class ${javaClassName}Service{
	
	private ${javaClassName}Dao ${uncaptialJavaClassName}Dao;
	
	public List${javaClassName} search(${javaClassName}Criteria ${uncaptialJavaClassName}Criteria){
		return ${uncaptialJavaClassName}Dao.search(${uncaptialJavaClassName}Criteria);
	}
	
	public ${javaClassName} find(${javaClassName}Key ${uncaptialJavaClassName}Key){
		return ${uncaptialJavaClassName}Dao.find(${uncaptialJavaClassName}Key);
	}
	
	public int insert(${javaClassName} ${uncaptialJavaClassName}){
		return ${uncaptialJavaClassName}Dao.find(${uncaptialJavaClassName});
	}
	
	public int insert(${javaClassName} ${uncaptialJavaClassName}){
		return ${uncaptialJavaClassName}Dao.update(${uncaptialJavaClassName});
	}
	
	public int delete(${javaClassName} ${uncaptialJavaClassName}Key){
		return ${uncaptialJavaClassName}Dao.delete(${uncaptialJavaClassName}Key);
	}
}