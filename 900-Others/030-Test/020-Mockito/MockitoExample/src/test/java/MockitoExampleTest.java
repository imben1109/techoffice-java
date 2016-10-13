import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ittechoffice.example.MockitoExample;
import com.ittechoffice.example.MockitoExampleService;


public class MockitoExampleTest {
	
	@Test
	public void run(){
		MockitoExampleService mockitoExampleService = Mockito.mock(MockitoExampleService.class);
		Mockito.when(mockitoExampleService.getInteger()).thenReturn(100);
		MockitoExample mockitoExample = new MockitoExample(mockitoExampleService);
		int result = mockitoExample.run();
		Assert.assertEquals(result, 100);
	}
	
}
