package com.staples.salesattribution.kafka;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.staples.salesattribution.service.AttributedSalesInfoService;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * @author rayni002 This class set the Kafka configuration and publish the
 *         messages one by one using the publish message.
 */
@Component
public class AttributedSalesInfoKafkaProducer {

	final static Logger logger = Logger.getLogger(AttributedSalesInfoKafkaProducer.class);
	// private static Producer<String, String> producer;
	// private static Properties kafkaProps;

	@Autowired
	AttributedSalesInfoService attributedSalesInfoSvc;

	/*
	 * publishMessage takes the list of String as argument and publish it one by
	 * one.
	 */
	public void publishMessage(List<? extends String> msgsJson) {
		logger.debug(Thread.currentThread().getName() + "::List received for Msg publishing=" + msgsJson);
		Set<String> setForIndUpdate = new HashSet<String>();
		Producer<String, String> kafkaProducer = getProducer();

		KafkaConfig kfkConf = KafkaConfig.getInstance();
		String topic = kfkConf.getTopicName();

		for (String salesInfoJson : msgsJson) {
			if (null != salesInfoJson && !("".equals(salesInfoJson)) && !("null".equals(salesInfoJson))) {
				String runtime = new Date().toString();
				logger.info(Thread.currentThread().getName() + "::Msg @ Topic::" + topic + "@" + runtime + " :: "
						+ salesInfoJson);
				// synchronized (listForIndUpdate) {
				KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, salesInfoJson);
				kafkaProducer.send(data);

				setForIndUpdate.add(salesInfoJson);
				logger.debug(Thread.currentThread().getName() + "::after adding to List for update size is="
						+ setForIndUpdate.size() + "<-->" + salesInfoJson);
				// }// end of synchronized
			} // end of if
		} // end of for

		attributedSalesInfoSvc.updateSalesTranDetRewardSentIndicator(setForIndUpdate);
		setForIndUpdate.clear();
		kafkaProducer.close();

		// release the objects
		kafkaProducer = null;
		setForIndUpdate = null;
	}

	/*
	 * setKafkarConfiguration sets the Kafka configuration based on different
	 * properties .
	 */
	private Producer<String, String> getProducer() {

		Properties kafkaProps = new Properties();
		KafkaConfig kfkConf = KafkaConfig.getInstance();
		kafkaProps.put("metadata.broker.list", kfkConf.getBrokerList());
		kafkaProps.put("serializer.class", kfkConf.getSerializerClass());
		/**
		 * 1 means the producer receives an acknowledgment once the lead replica
		 * has received the data. This option provides better durability as the
		 * client waits until the server acknowledges the request as successful.
		 */
		kafkaProps.put("request.required.acks", kfkConf.getReqAck());

		return new Producer<String, String>(new ProducerConfig(kafkaProps));

	}

}
