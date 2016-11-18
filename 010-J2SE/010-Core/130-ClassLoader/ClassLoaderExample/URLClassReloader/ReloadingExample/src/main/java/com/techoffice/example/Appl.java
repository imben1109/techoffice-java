package com.ittechoffice.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Appl {
	public static void main(String[] args) throws URISyntaxException, MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{

		Path root = Paths.get(Appl.class.getClassLoader().getResource(".").toURI()).getParent().getParent().getParent();
		Path newClassPath = root.resolve("URLClassLoaderClassesReloadingExample/target/classes/");
		ReloadingClassLoader reloadingClassLoader = new ReloadingClassLoader(newClassPath.toString() + "//");
		Class<?> reloadedExample1Class = reloadingClassLoader.loadClass("com.ittechoffice.example.Example1");
//		Object reloadedExample1 = reloadedExample1Class.newInstance();
//		Method example1ClassSayHiMethod = reloadedExample1Class.getDeclaredMethod("sayHi");
//		example1ClassSayHiMethod.invoke(reloadedExample1);
		Thread.currentThread().setContextClassLoader(reloadingClassLoader);
		
		Class example1Class = Class.forName("com.ittechoffice.example.Example1");
		Object newInstance = example1Class.newInstance();
		Method example1ClassSayHiMethod = example1Class.getDeclaredMethod("sayHi");
		example1ClassSayHiMethod.invoke(newInstance);

	}
}
