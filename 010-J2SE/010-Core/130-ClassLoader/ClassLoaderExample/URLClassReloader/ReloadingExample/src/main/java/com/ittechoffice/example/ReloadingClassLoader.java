package com.ittechoffice.example;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReloadingClassLoader extends ClassLoader{

	private String classPath;
	
	public ReloadingClassLoader(String classPath) {
		this.classPath = classPath;
	}
	
	
    public Class<?> loadClass(String name) throws ClassNotFoundException {
    	
    	System.out.println("Loading Class: " + name);
    	String namePath = name.replaceAll("\\.", "\\\\") + ".class";
    	String classFilePath = classPath + namePath ;
    	File classFile = new File(classFilePath);
    	Class<?> loadedClass;
        try {
			FileInputStream fis = new FileInputStream(classFile);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int data = fis.read();
            while(data != -1){
                buffer.write(data);
                data = fis.read();
            }
            fis.close();
            byte[] classData = buffer.toByteArray();
            loadedClass = this.defineClass(name, classData, 0, classData.length);
		} catch (FileNotFoundException e) {
			try{
				return super.loadClass(name);
			}catch (ClassNotFoundException classNotFoundException){
				throw new ClassNotFoundException();	
			}
		} catch (IOException e) {
			throw new ClassNotFoundException();
		}
        System.out.println("reloaded");
        return loadedClass;
    }
}
