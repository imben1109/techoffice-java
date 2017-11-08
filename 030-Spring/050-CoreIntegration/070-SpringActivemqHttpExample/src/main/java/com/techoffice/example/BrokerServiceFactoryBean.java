package com.techoffice.example;

import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Spring Factory Bean for ActiveMQ Broker Service.
 * 
 * @author imben1109
 * @revision 1.0
 */
public class BrokerServiceFactoryBean implements FactoryBean<BrokerService>, InitializingBean{
	/**
	 * ActiveMQ Broker Service.
	 * It manage the life cycle. 
	 */
	private BrokerService brokerService;
	
	/**
	 * Bind Address of Transport Connector 
	 */
	private String uri;
	
	/**
	 * Method invoked after properties set. 
	 * 
	 * Bind address to a connector of Active MQ Broker and start the broker.
	 */
	public void afterPropertiesSet() throws Exception {
		if (brokerService == null){
			brokerService = new BrokerService();
			brokerService.addConnector(uri);
			brokerService.start();
		}
	}

	/**
	 * Get ActiveMQ Broker Service
	 */
	public BrokerService getObject() throws Exception {
		return brokerService;
	}

	/**
	 * Get Class Type of Broker Service
	 */
	public Class<BrokerService> getObjectType() {
        return BrokerService.class;
	}

	/**
	 * Check if Spring Bean is Singleton
	 */
	public boolean isSingleton() {
		return true;
	}
	
	/**
	 * Set Bind Address of Connector of ActiveMQ Broker Service
	 * @param uri
	 */
	public void setUri(String uri){
		this.uri = uri;
	}
}
