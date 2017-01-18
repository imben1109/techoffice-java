package com.ittechoffice.spring.bean;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.FieldSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring bean is a java object in Spring context. It could be inject to another Spring bean through the annotation @autowired. 
 * 
 * @author Ben_c
 *
 */
public class AutowiredBeanHelper {
	
	public static boolean hasAutowired(Annotation[] annotations ){
		for (int i=0; i<annotations.length; i++){
			Annotation annotation = annotations[i];
			if (annotation.annotationType().equals(Autowired.class)){
				return true;
			}
		}
		return false;
	}
	
	public static void listAutowiredField(Class clz){
		Field[] fields = clz.getDeclaredFields();
		for (int i=0; i<fields.length; i++){
			Field field = fields[i];
			Annotation[] annotations = field.getAnnotations();
			if (hasAutowired(annotations)){
				System.out.println(field.getType().getName());
			}
		}
	}
	
	public static void listAutowiredField(JavaClassSource clz){
		List<FieldSource<JavaClassSource>> fields = clz.getFields();
		for(FieldSource<JavaClassSource> field: fields){
			List<AnnotationSource<JavaClassSource>> annotations = field.getAnnotations();
			for (AnnotationSource<JavaClassSource> annotation: annotations){
				if (annotation.getQualifiedName().equals(Autowired.class.getName())){
					System.out.println(field.getName());
				}
			}
		}
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException{
		Path path = Paths.get(AutowiredBeanHelper.class.getClassLoader().getResource(".").toURI());
		File root = path.getParent().getParent().toFile();
		File Testing = new File(root, "/src/main/java/com/ittechoffice/spring/bean/AutowiredBeanHelper.java");
		String content = FileUtils.readFileToString(Testing, "UTF-8");
		JavaClassSource javaClass =
				  Roaster.parse(JavaClassSource.class, content);
		AutowiredBeanHelper.listAutowiredField(javaClass);
	}
}
