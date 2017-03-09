package com.techoffice.example;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.techoffice.example.dao.TestDao;

@Component
public class Appl {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@Autowired
	private TestDao testDao;
	
    @Bean(name="jCacheManager")
    public CacheManager cacheManager() {
	    CachingProvider provider = Caching.getCachingProvider();  
	    CacheManager cacheManager = provider.getCacheManager();   
	    MutableConfiguration<Object, Object> configuration =
		        new MutableConfiguration<Object, Object>()  
		            .setTypes(Object.class, Object.class)   
		            .setStoreByValue(false)   
		            .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));  
	    cacheManager.createCache("test", configuration); 
	    return cacheManager;
    }

	
	public void run(){
		System.out.println("Spring Cache Example");
		String firstOne = testDao.get();
		testDao.get();
		System.out.println("The Second one is retrieved from Cache. That is why not system print");
		testDao.put();
		System.out.println("The Update Cache Value: " + testDao.get() + " . The Original Value: " + firstOne);
	}
	
	public static void main(String[] args){
		Appl appl = context.getBean(Appl.class);
		appl.run();
		
	}
}
