# Spring Core Example 

## Spring Core
The Core Container of Spring include:
* spring-core
* spring-beans
* spring-context
* spring-context-support
* spring-expression

## Example 
* [010-SpringHelloWorldExample](010-SpringHelloWorldExample/)
* [020-SpringConfigExample](020-SpringConfigExample/)
* [030-SpringSeparateXmlConfigExample](030-SpringSeparateXmlConfigExample/)
* [040-SpringBeanPropertyExample](040-SpringBeanPropertyExample/)
* [050-SpringElExample](050-SpringElExample/)
* [060-SpringContextAwareExample](060-SpringContextAwareExample/)
* [070-SpringApplicationListenerExample](070-SpringApplicationListenerExample/)
* [080-SpringAopExample](080-SpringAopExample/)

## Inversion of Control Container

### ApplicationContext
ApplicationContext represents the Spring IoC Container. It would responsbile for initiating, configuring beans inside the Container.

### Spring Bean LifeCycle API
InitializingBean and DisposableBean Interface would specify the method, afterPropertiesSet() and destroy() when bean initiation and destruction.

@PostConstruct and @PreDestroy are annotation suggested by J2EE specification for standizing the method callback when bean initiation and destruction.

### Aware 
It is a functionality provided by Spring to acquire Infrastucture event.
* ApplicationContextAware
* ApplicationEventPublisherAware
* ServletContextAware
The above is just a few aware provided. Visit official documentation is required for detail.


# Reference
* https://docs.spring.io/spring/docs/current/spring-framework-reference/
* https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#spring-core