package com.techoffice;

import com.google.gson.Gson;
import com.techoffice.model.Car;

public class App {

	public static void main(String[] args){
		String json = "{\"brand\":\"Jeep\", \"doors\": 3}";

		Gson gson = new Gson();

		Car car = gson.fromJson(json, Car.class);
		System.out.println(car.getBrand());
		System.out.println(car.getDoors());
	}
}
