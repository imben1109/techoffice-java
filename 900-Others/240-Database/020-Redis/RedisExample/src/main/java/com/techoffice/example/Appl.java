package com.techoffice.example;

import redis.clients.jedis.Jedis;

/**
 * Redis is an open source in-memory data store which can be used as a database, cache, and message broker.
 * @author Ben_c
 *
 */
public class Appl {
	public static void main(String[] args){
	      Jedis jedis = new Jedis("localhost"); 
	      System.out.println("Connection to server sucessfully"); 
	      //check whether server is running or not 
	      System.out.println("Server is running: "+jedis.ping()); 
	      
	      jedis.set("Test", "Testing Value"); 
	      System.out.println("Stored string in redis:: "+ jedis.get("Test")); 

	}
}
