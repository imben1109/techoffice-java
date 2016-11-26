package com.techoffice.example;

import java.io.File;

import org.ehcache.CachePersistenceException;
import org.ehcache.PersistentUserManagedCache;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.builders.UserManagedCacheBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.core.spi.service.LocalPersistenceService;
import org.ehcache.impl.config.persistence.DefaultPersistenceConfiguration;
import org.ehcache.impl.config.persistence.UserManagedPersistenceContext;
import org.ehcache.impl.persistence.DefaultLocalPersistenceService;

public class PersistenceUserManagedCacheExample {
	public static void main(String[] args) throws CachePersistenceException{
		LocalPersistenceService persistenceService = new DefaultLocalPersistenceService(
				new DefaultPersistenceConfiguration(new File("CacheData"))); 
		PersistentUserManagedCache<Long, String> cache = UserManagedCacheBuilder
				.newUserManagedCacheBuilder(Long.class, String.class)
			    .with(new UserManagedPersistenceContext<Long, String>("cache-name", persistenceService)) 
			    .withResourcePools(ResourcePoolsBuilder.newResourcePoolsBuilder()
			            .heap(10L, EntryUnit.ENTRIES)
			            .disk(10L, MemoryUnit.MB, true)) 
			        .build(true);
		cache.put(42L, "The Answer!");
		System.out.println(cache.get(42L));
		cache.close(); 
		cache.destroy(); 

		persistenceService.stop(); 



	}
}
