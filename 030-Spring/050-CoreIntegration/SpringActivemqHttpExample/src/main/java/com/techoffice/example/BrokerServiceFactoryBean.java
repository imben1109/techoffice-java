package com.techoffice.example;

import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class BrokerServiceFactoryBean implements FactoryBean<BrokerService>, InitializingBean{
	private BrokerService brokerService;
	private String uri;
	
	public void afterPropertiesSet() throws Exception {
		if (brokerService == null){
			brokerService = new BrokerService();
			brokerService.addConnector(uri);
			brokerService.start();
		}
	}

	public BrokerService getObject() throws Exception {
		return brokerService;
	}

	public Class<BrokerService> getObjectType() {
        return BrokerService.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
	public void setUri(String uri){
		this.uri = uri;
	}
}
