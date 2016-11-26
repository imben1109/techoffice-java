# User Managed Cache
It is a cache which is not managed by CacheManager. In some certain situation, cache manager has no added value. It would include method local cache, thread local cache and life cycle of cache is shorter than application lifecycle.

## Disk Persistent Cache
The cache can be persisted to disk stage. Ehcache provide interface named PersistentUserManagedCache