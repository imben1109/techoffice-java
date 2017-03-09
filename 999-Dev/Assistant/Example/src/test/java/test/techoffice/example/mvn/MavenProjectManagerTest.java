package test.techoffice.example.mvn;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.techoffice.example.ExampleProperty;
import com.techoffice.example.mvn.MavenProjectManager;

public class MavenProjectManagerTest {
	
	@Test
	public void getDummyFileListTest(){
		String exampleHome = ExampleProperty.properties.getProperty(ExampleProperty.EXAMPLE_HOME);

	}
	
	@Test
	public void getMavenProjectListTest(){
		String exampleHome = ExampleProperty.properties.getProperty(ExampleProperty.EXAMPLE_HOME);
	}
}
