package com.techoffice;

import com.google.gson.Gson;
import com.techoffice.model.Car;

public class App {

	public static void main(String[] args){
		Car car = new Car();
		car.brand = "Rover";
		car.doors = 5;

		Gson gson = new Gson();

		String json = gson.toJson(car);
		System.out.println(json);
	}
}
