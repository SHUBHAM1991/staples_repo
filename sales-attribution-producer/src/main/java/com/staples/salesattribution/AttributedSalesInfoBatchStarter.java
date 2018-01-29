package com.staples.salesattribution;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.staples.salesattribution.kafka.KafkaConfig;
/**
 * @author rayni002 
 * AttributedSalesInfoBatchStarter class is main class . It calls the run method which
 * configures the JobLauncher and run it.
 */

public class AttributedSalesInfoBatchStarter 
{
	final static Logger logger = Logger.getLogger(AttributedSalesInfoBatchStarter.class);
	
	public static void main( String[] args )
    {   
        AttributedSalesInfoBatchStarter objAttribtdSalesBtchStrt = new AttributedSalesInfoBatchStarter();
        objAttribtdSalesBtchStrt.run("");
    	
        objAttribtdSalesBtchStrt = null;
    }
    
    @SuppressWarnings("resource")
	private void run(String strInput) {

    	ApplicationContext context = null;
    	
    	try {
	    	logger.info( "Starting Sales Attribution Producer Batch for input " + strInput +" !!" );
	    	
	    	String[] springConfig = {"META-INF/spring/batch/jobs/job-attributed-sales-data-transfer.xml"};
	    	context = new ClassPathXmlApplicationContext(springConfig);
	
	    	JobLauncher jobLauncher = (JobLauncher) context.getBean("attributedSalesDataTransferJobLauncher");
	    	Job job = (Job) context.getBean("attributedSalesDataTransferJob");

    		//get Kafka config singleton instance and load the Kafka properties
	    	loadKafkaProperties();
    		
    		//JobParameters param = new JobParametersBuilder().addString("cpnSrlCode", strInput).toJobParameters();
    		JobParameters param = new JobParameters();	
    		JobExecution execution = jobLauncher.run(job, param);
    		logger.info("Exit Status : " + execution.getStatus());
    		logger.info("Exit Errors : " + execution.getAllFailureExceptions());
    		
    		//success
    		System.exit(0);
    	} catch (Exception e) {
    		//failure
    		logger.error("Encountered Error during batch execution", e);
    		System.exit(-1);
    	}
    	
    	context = null;
    	logger.info("Batch Ended !!");
      }
    
    /*
	 * loadKafkaProperties method used for the loading of the Kafka properties
	 * like Broker List Topic name.
	 */
	private void loadKafkaProperties() {
		//get Kafka config singleton instance and load the properties
		KafkaConfig kfkConf = KafkaConfig.getInstance();
		
		final Properties kafkaProp = new Properties();
		try (final InputStream stream =
		           this.getClass().getClassLoader().getResourceAsStream("KafkaTopic.properties")) {
			kafkaProp.load(stream);		
			
			logger.debug("Topic:" + kafkaProp.getProperty("TOPIC_NAME"));
			logger.debug("Broker List:" + kafkaProp.getProperty("BROKER_LIST"));
			logger.debug("Serializer Class:" + kafkaProp.getProperty("SERIALIZER_CLASS"));
			logger.debug("Req Ack:" + kafkaProp.getProperty("REQUEST_ACK"));
			
			//set the Kafka properties in class attributes
			kfkConf.setTopicName(kafkaProp.getProperty("TOPIC_NAME"));
			kfkConf.setBrokerList(kafkaProp.getProperty("BROKER_LIST"));
			kfkConf.setSerializerClass(kafkaProp.getProperty("SERIALIZER_CLASS"));
			kfkConf.setReqAck(kafkaProp.getProperty("REQUEST_ACK"));
		} catch (IOException e) {
			logger.error("Error while loading Kafka properties:" + e);
			e.printStackTrace();
		}			
	}
}
