package test.techoffice.example.mvn.service;

import java.util.List;

import org.junit.Test;

import com.techoffice.example.mvn.ApplProperty;
import com.techoffice.example.mvn.model.Model;
import com.techoffice.example.mvn.service.MavenProjectService;

public class MavenProjectServiceTest {
	
	@Test
	public void getMavenProjectModelList() throws Exception{
		String home = ApplProperty.getExampleHome();
		MavenProjectService mavenProjectService = new MavenProjectService();
		List<Model> modelList = mavenProjectService.getMavenProjectModelList(home);
		for (Model model: modelList){
			System.out.println(model.getArtifactId());
		}
	}
}
