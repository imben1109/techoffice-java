package com.techoffice.generator.mybatis.config;

import java.io.File;
import java.util.Properties;

import com.techoffice.database.dao.config.BaseConfig;
import com.techoffice.database.dao.model.Entity;
import com.techoffice.generator.mybatis.ControllerGenerator;
import com.techoffice.generator.mybatis.CriteriaGenerator;
import com.techoffice.generator.mybatis.DaoGenerator;
import com.techoffice.generator.mybatis.EntityGenerator;
import com.techoffice.generator.mybatis.KeyGenerator;
import com.techoffice.generator.mybatis.ServiceGenerator;
import com.techoffice.generator.mybatis.SqlMapperGenerator;
import com.techoffice.generator.mybatis.base.SimpleEntityTemplateGenerator;

public class MyBatisGeneratorConfig {

	public static Properties prop = null;
	private static final String PATH = "mybatis.generator.path";
	private static final String PACKAGE_BASE		 = "mybatis.generator.package.base";
	private static final String PACKAGE_ENTITY 		 = "mybatis.generator.package.entity";
	private static final String PACKAGE_CRITERIA     = "mybatis.generator.package.criteria";
	private static final String PACKAGE_KEY          = "mybatis.generator.package.key";
	private static final String PACKAGE_SERVICE      = "mybatis.generator.package.service";
	private static final String PACKAGE_CONTROLLER   = "mybatis.generator.package.controller";
	private static final String PACKAGE_DAO 		 = "mybatis.generator.package.dao";
	private static final String PACKAGE_SQLMAPPER    = "mybatis.generator.package.sqlmapper";
	
	static {
		prop = BaseConfig.getProperties();
	}
	
	public static String getPath(){
		return prop.getProperty(PATH);
	}
	
	public static String getBasePackage(){
		return prop.getProperty(PACKAGE_BASE);
	}
	
	public static String getEntityPackage(){
		return prop.getProperty(PACKAGE_ENTITY);
	}
	
	public static String getEntityFolder(){
		return getEntityPackage().replace(".", "/");
	}
	
	public static String getCriteriaPackage(){
		return prop.getProperty(PACKAGE_CRITERIA);
	}
	
	public static String getCriteriaFolder(){
		return getCriteriaPackage().replace(".", "/");
	}
	
	public static String getKeyPackage(){
		return prop.getProperty(PACKAGE_KEY);
	}
	
	public static String getKeyFolder(){
		return getKeyPackage().replace(".", "/");
	}
	
	public static String getServicePackage(){
		return prop.getProperty(PACKAGE_SERVICE);
	}
	
	public static String getServiceFolder(){
		return getServicePackage().replace(".", "/");
	}
	
	public static String getControllerPackage(){
		return prop.getProperty(PACKAGE_CONTROLLER);
	}
	
	public static String getControllerFolder(){
		return getControllerPackage().replace(".", "/");
	}
	
	public static String getDaoPackage(){
		return prop.getProperty(PACKAGE_DAO);
	}
	
	public static String getDaoFolder(){
		return getDaoPackage().replace(".", "/");
	}
	
	public static String getSqlmapperPackage(){
		return prop.getProperty(PACKAGE_SQLMAPPER);
	}
	
	public static String getSqlmapperFolder(){
		return getSqlmapperPackage().replace(".", "/");
	}
	
	public static String getPackage(SimpleEntityTemplateGenerator generator){
		if (generator instanceof CriteriaGenerator){
			return getCriteriaFolder();
		}else if (generator instanceof DaoGenerator){
			return getDaoFolder();
		}else if (generator instanceof EntityGenerator){
			return getEntityFolder();
		}else if (generator instanceof KeyGenerator){
			return getKeyFolder();
		}else if (generator instanceof ServiceGenerator){
			return getServiceFolder();
		}else if (generator instanceof SqlMapperGenerator){
			return getSqlmapperFolder();
		}else if (generator instanceof ControllerGenerator){
			return getControllerFolder();
		}
		return null;
	}
	
	public static File getFile(SimpleEntityTemplateGenerator generator, Entity entity){
		String path = MyBatisGeneratorConfig.getPath();
		File baseFile = new File(path);
		if (generator instanceof CriteriaGenerator){
			File folder = new File(baseFile, getCriteriaFolder());
			String fileName = entity.getJavaClassName() + "Criteria.java";
			return new File(folder, fileName);
		}else if (generator instanceof DaoGenerator){
			File folder = new File(baseFile, getDaoFolder());
			String fileName = entity.getJavaClassName() + "Dao.java";
			return new File(folder, fileName);
		}else if (generator instanceof EntityGenerator){
			File folder = new File(baseFile, getEntityFolder());
			String fileName = entity.getJavaClassName() + ".java";
			return new File(folder, fileName);
		}else if (generator instanceof KeyGenerator){
			File folder = new File(baseFile, getKeyFolder());
			String fileName = entity.getJavaClassName() + "Key.java";
			return new File(folder, fileName);
		}else if (generator instanceof ServiceGenerator){
			File folder = new File(baseFile, getServiceFolder());
			String fileName = entity.getJavaClassName() + "Service.java";
			return new File(folder, fileName);
		}else if (generator instanceof SqlMapperGenerator){
			File folder = new File(baseFile, getSqlmapperFolder());
			String fileName = entity.getJavaClassName() + "Mapper.xml";
			return new File(folder, fileName);
		}else if (generator instanceof ControllerGenerator){
			File folder = new File(baseFile, getControllerFolder());
			String fileName = entity.getJavaClassName() + "Controller.java";
			return new File(folder, fileName);
		}
		return null;
	}
}
