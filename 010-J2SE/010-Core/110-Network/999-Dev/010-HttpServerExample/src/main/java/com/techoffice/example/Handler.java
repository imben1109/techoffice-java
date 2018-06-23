package com.techoffice.example;

public class Handler {

	public void process(Request request, Response response){
		try{
			String content = request.getContent();			
			System.out.println(content);
			response.print("Testing");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
