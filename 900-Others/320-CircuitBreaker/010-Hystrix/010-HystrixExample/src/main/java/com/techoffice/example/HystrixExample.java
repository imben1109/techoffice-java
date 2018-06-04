package com.techoffice.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import rx.Observable;
import rx.functions.Action1;

public class HystrixExample extends HystrixCommand<String> {

    private final String name;
    
    public HystrixExample(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }


	@Override
	protected String run() throws Exception {
        return "Hello " + name + "!";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		String string = new HystrixExample("Bob").execute();
		System.out.println(string);
		Future<String> future = new HystrixExample("Bob").queue();
		System.out.println(future.get());
		Observable<String> observable = new HystrixExample("Bob").observe();
		observable.subscribe(new Action1<String>(){
			public void call(String t) {
				System.out.println(t);
			}
		});
		
	}
}
