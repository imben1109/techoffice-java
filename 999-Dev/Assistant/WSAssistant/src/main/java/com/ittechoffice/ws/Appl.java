package com.ittechoffice.ws;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * This Program implements the steps in http://stackoverflow.com/questions/17525260/how-to-clone-a-websphere-8-profile.

 * It aims to automated the profile clone process 
 * 
 * Steps
 * 1. clone profile
 * 2. update setupCmdLine.bat
 * 3. update ssl.client.props
 * 4. update firststeps.bat
 * 5. update profileRegistry.xml
 * 6. update profile.bat in fsdb
 * 7. update variables.xml
 * 
 * @author Ben_c
 *
 */
public class Appl {
	private String appServerPath;
	private String profilePath;
	private String oldProfileName;
	private String newProfileName;
	
	public static final String PROFILE_SETUP_CMD_LINE_BAT_PATH = "bin/setupCmdLine.bat";
	public static final String PROFILE_SSL_CLIENT_PROPS_PATH = "properties/ssl.client.props";
	public static final String PROFILE_FIRST_STEPS_BAT_PATH = "firststeps/firststeps.bat";
	
	public static final String APPSERVER_PROFILE_REGISTRY_XML_PATH = "properties/profileRegistry.xml";
	public static final String APPSERVER_PROFILE_DEFAULT = "profileTemplates/default";
	public static final String APPSERVER_FSDB_FOLDER_PATH = "properties/fsdb";
	
	public static final String PROFILE_CONFIG_CELLS = "config/cells";
	public static final String PROFILE_CONFIG_CELLS_NODES = "nodes";
	public static final String PROFILE_VARIBALE_XML_PATH = "variables.xml";
	
	
	public Appl(String profilePath, String oldProfileName, String newProfileName){
		this.appServerPath = new File(profilePath).getParent();

		this.profilePath = profilePath;
		this.oldProfileName = oldProfileName;
		this.newProfileName = newProfileName;
	}
	
	public void cloneProfile() throws IOException{
		File oldProfileFile = new File(profilePath, oldProfileName);
		File newProfileFile = new File(profilePath, newProfileName);
		if (newProfileFile.exists()){
			throw new IOException(newProfileFile.getPath() + " already exists");
		}
		FileUtils.copyDirectory(oldProfileFile, newProfileFile);
		System.out.println(newProfileFile.getPath() + " is cloned from " + newProfileFile.getPath());
	}
	
	public void updateSetupCmdLine() throws IOException{
		File setupCmdLineBat = new File(profilePath + "/" + newProfileName + "/" + PROFILE_SETUP_CMD_LINE_BAT_PATH);
		String fileContent = FileUtils.readFileToString(setupCmdLineBat, "UTF-8");
		File oldProfileFile = new File(profilePath, oldProfileName);
		File newProfileFile = new File(profilePath, newProfileName);
		String replacedFileContent = fileContent.replace(oldProfileFile.getPath(), newProfileFile.getPath());
		FileUtils.writeStringToFile(setupCmdLineBat, replacedFileContent, "UTF-8");
		System.out.println(newProfileFile.getPath() + " Updated");
	}
	
	public void updateSslClientProps() throws IOException{
		File sslClientProps = new File(profilePath + "/" + newProfileName + "/" + PROFILE_SSL_CLIENT_PROPS_PATH);
		String fileContent = FileUtils.readFileToString(sslClientProps, "UTF-8");
		File oldProfileFile = new File(profilePath, oldProfileName);
		File newProfileFile = new File(profilePath, newProfileName);
		String replacedFileContent = fileContent.replace(oldProfileFile.getPath(), newProfileFile.getPath());
		replacedFileContent = replacedFileContent.replace(oldProfileFile.getPath().replace("\\", "/"), newProfileFile.getPath().replace("\\", "/"));
		FileUtils.writeStringToFile(sslClientProps, replacedFileContent, "UTF-8");
		System.out.println(sslClientProps.getPath() + " Updated");
	}
	
	public void updateFirststeps() throws IOException{
		File firstStepsBat = new File(profilePath + "/" + newProfileName + "/" + PROFILE_FIRST_STEPS_BAT_PATH);
		String fileContent = FileUtils.readFileToString(firstStepsBat, "UTF-8");
		File oldProfileFile = new File(profilePath, oldProfileName);
		File newProfileFile = new File(profilePath, newProfileName);
		String replacedFileContent = fileContent.replace(oldProfileFile.getPath(), newProfileFile.getPath());
		FileUtils.writeStringToFile(firstStepsBat, replacedFileContent, "UTF-8");
		System.out.println(firstStepsBat.getPath() + " Updated");
	}
	
	public void updateProfileRegistry() throws IOException{
		File registryXml = new File(appServerPath, APPSERVER_PROFILE_REGISTRY_XML_PATH);
		String fileContent = FileUtils.readFileToString(registryXml, "UTF-8");
		String templateStr = "    <profile isAReservationTicket=\"false\" isDefault=\"false\" name=\"%s\" path=\"%s\" template=\"%s\"/>\r\n</profiles>";
		String formatStr = String.format(templateStr, newProfileName, 
				new File(profilePath, newProfileName).getPath(), 
				new File(appServerPath, APPSERVER_PROFILE_DEFAULT).getPath());
		String replacedFileContent = fileContent.replace("</profiles>", formatStr);
		FileUtils.writeStringToFile(registryXml, replacedFileContent, "UTF-8");
		System.out.println(registryXml.getPath() + " Updated");
	}
	
	public void cloneProfileBat() throws IOException{
		File oldProfileBat = new File(appServerPath + "/" + APPSERVER_FSDB_FOLDER_PATH, oldProfileName + ".bat");
		File newProfileBat = new File(appServerPath + "/" + APPSERVER_FSDB_FOLDER_PATH, newProfileName + ".bat");
		FileUtils.copyFile(oldProfileBat, newProfileBat);
		System.out.println(newProfileBat.getPath() + " is cloned from " + oldProfileBat.getPath());
	}
	
	public void updateProfileBat() throws IOException{
		File newProfileBat = new File(appServerPath + "/" + APPSERVER_FSDB_FOLDER_PATH, newProfileName + ".bat");
		String fileContent = FileUtils.readFileToString(newProfileBat, "UTF-8");
		File oldProfileFile = new File(profilePath, oldProfileName);
		File newProfileFile = new File(profilePath, newProfileName);
		String replacedFileContent = fileContent.replace(oldProfileFile.getPath(), newProfileFile.getPath());
		FileUtils.writeStringToFile(newProfileBat, replacedFileContent, "UTF-8");
		System.out.println(newProfileBat.getPath() + " Updated");
	}
	
	public void updateVariables() throws IOException{
		File newProfileFile = new File(profilePath, newProfileName);
		File configCellsFolder = new File(newProfileFile, PROFILE_CONFIG_CELLS);
		File cellFolder = configCellsFolder.listFiles()[0];
		File nodesFolder = new File(cellFolder, PROFILE_CONFIG_CELLS_NODES);
		File nodeFolder = nodesFolder.listFiles()[0];
		File varaibleXml = new File(nodeFolder, PROFILE_VARIBALE_XML_PATH);
		String fileContent = FileUtils.readFileToString(varaibleXml, "UTF-8");
		File oldProfileFile = new File(profilePath, oldProfileName);
		String replacedFileContent = fileContent.replace(oldProfileFile.getPath(), newProfileFile.getPath());
		FileUtils.writeStringToFile(varaibleXml, replacedFileContent, "UTF-8");
		System.out.println(varaibleXml.getPath() + " Updated");
	}
	
	public static void main(String[] args) throws IOException{
		Appl appl = new Appl("D:\\WebSphere\\AppServer\\profiles", "AppSrv03", "EMS2");
		appl.cloneProfile();
		appl.updateSetupCmdLine();
		appl.updateSslClientProps();
		appl.updateFirststeps();
		appl.updateProfileRegistry();
		appl.cloneProfileBat();
		appl.updateProfileBat();
		appl.updateVariables();
	}
}
