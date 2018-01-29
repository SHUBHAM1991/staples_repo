package com.staples.salesattribution.batch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.staples.salesattribution.kafka.KafkaConfig;
import com.staples.salesattribution.kafka.AttributedSalesInfoKafkaProducer;
/**
 * @author rayni002
 *This class configures the Kafka and creates instance of it.
 *It calls the Producer's method for further publishing
 */
public class AttributedSalesInfoItemWriter implements ItemWriter<String> {

	final static Logger logger = Logger.getLogger(AttributedSalesInfoItemWriter.class);
	
	@Autowired
	private AttributedSalesInfoKafkaProducer attributedSalesInfoKafkaProducer;	
	/*
	 * write method takes the input as list of String and pass this list to
	 * publish .
	 */
	@Override
	public void write(List<? extends String> items) throws Exception {
		/*KafkaConfig kfkConf = KafkaConfig.getInstance();	
		String topic = kfkConf.getTopicName();*/
		logger.debug(Thread.currentThread().getName() + "::processing in ItemWriter "+items);
		attributedSalesInfoKafkaProducer.publishMessage(items);
	}
	
}
	

