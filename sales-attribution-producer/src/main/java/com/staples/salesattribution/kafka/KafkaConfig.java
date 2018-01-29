package com.staples.salesattribution.kafka;

import org.apache.log4j.Logger;
/**
 * @author rayni002 
 *This Class contains the method which is used 
 *for the loading of Kafka properties.
 */
public class KafkaConfig {

	final static Logger logger = Logger.getLogger(KafkaConfig.class);
	
	private static KafkaConfig instance = null;
	
	private static String topicName = null;
	private static String brokerList = null;
	private static String serializerClass = null;
	private static String reqAck = null;
	
	private KafkaConfig() {
		// Ensures instantiation cannot be done from outside
	}
	
	public static KafkaConfig getInstance() {
		if (instance == null) {
			instance = new KafkaConfig();			
		}
		return instance;
	}
		
	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		KafkaConfig.topicName = topicName;
	}

	public String getBrokerList() {
		return brokerList;
	}

	public void setBrokerList(String brokerList) {
		KafkaConfig.brokerList = brokerList;
	}

	public String getSerializerClass() {
		return serializerClass;
	}

	public void setSerializerClass(String serializerClass) {
		KafkaConfig.serializerClass = serializerClass;
	}

	public String getReqAck() {
		return reqAck;
	}

	public void setReqAck(String reqAck) {
		KafkaConfig.reqAck = reqAck;
	}
	
}