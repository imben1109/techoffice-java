# Quartz Config Example
In this example, it would show how to use quartz.properties as a configuration for Quartz Schedular.

```
// Load Quartz config from quartz.properties
Properties prop = new Properties();
InputStream is = Appl.class.getClassLoader().getResourceAsStream("quartz.properties");
prop.load(is);
SchedulerFactory schedulerFactory = new StdSchedulerFactory(prop);
```