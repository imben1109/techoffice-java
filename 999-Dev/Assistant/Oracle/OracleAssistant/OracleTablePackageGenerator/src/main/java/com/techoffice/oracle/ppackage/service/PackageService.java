package com.techoffice.oracle.ppackage.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techoffice.oracle.constant.PackageConstant;
import com.techoffice.oracle.ppackage.generator.PackageBodyGenerator;
import com.techoffice.oracle.ppackage.generator.PackageSpecGenerator;

@Service
public class PackageService {
	
	@Autowired
	private PackageBodyGenerator packageBodyGenerator;
	
	@Autowired
	private PackageSpecGenerator packageSpecGenerator;
	
	public void generatePackage(String tableName) throws IOException{
		String packageBody = packageBodyGenerator.generatePackageBody(tableName);
//		System.out.println(packageBody);
		String packageSpec = packageSpecGenerator.generatePackageSpec(tableName);
//		System.out.println(packageSpec);
		File output = new File("PACKAGE");
		if (!output.exists()){
			output.mkdir();
		}
		File bodyFile = new File(output, PackageConstant.PACKAGE_PREFIX + "_" + tableName + "_body.sql");
		File specFile = new File(output, PackageConstant.PACKAGE_PREFIX + "_" + tableName + "_spec.sql");

		FileWriter bodyFileWriter = new FileWriter(bodyFile);
		bodyFileWriter.write(packageBody);
		bodyFileWriter.close();
		
		FileWriter specFileWriter = new FileWriter(specFile);
		specFileWriter.write(packageSpec);
		specFileWriter.close();
	}
}
