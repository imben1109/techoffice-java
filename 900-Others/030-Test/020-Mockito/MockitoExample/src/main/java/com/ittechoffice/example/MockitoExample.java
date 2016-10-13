package com.ittechoffice.example;

public class MockitoExample {
	
	private MockitoExampleService mockitoExampleService;
	
	public MockitoExample(MockitoExampleService mockitoExampleService){
		this.mockitoExampleService = mockitoExampleService;
	}
	
	public int run(){
		return mockitoExampleService.getInteger();
	}
}
