package com.techoffice.oracle.daogen.generator;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.sun.codemodel.JClass;
import com.sun.codemodel.JClassAlreadyExistsException;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JMethod;
import com.sun.codemodel.JMod;
import com.sun.codemodel.JPackage;

public class DaoGenGenerator {
	 
	private JCodeModel codeModel;
	private JDefinedClass interfaceClass;
	
	public DaoGenGenerator(String packageName, String interfaceName) throws JClassAlreadyExistsException{
		 codeModel = new JCodeModel();
		 JPackage jPackage = codeModel._package(packageName);
		 interfaceClass = jPackage._interface(interfaceName);	
	}
	
	 public void addMethod(String methodName){
		 JMethod method = interfaceClass.method(JMod.PUBLIC, codeModel.VOID, methodName);
		 JClass mapClass = codeModel.ref(Map.class);
		 JClass detailMapClass = mapClass.narrow(String.class, Object.class);
		 method.param(detailMapClass, "map");
	 }
	 
	 public void addSearchMethod(String methodName){
		 JMethod method = interfaceClass.method(JMod.PUBLIC, codeModel.ref(Map.class).narrow(String.class, Object.class), methodName);
		 JClass mapClass = codeModel.ref(Map.class);
		 JClass detailMapClass = mapClass.narrow(String.class, Object.class);
		 method.param(detailMapClass, "map");
	 }
	 
	 public JDefinedClass generateCode(File file) throws IOException{
		 codeModel.build(file);
		 return interfaceClass;
	 }

}
