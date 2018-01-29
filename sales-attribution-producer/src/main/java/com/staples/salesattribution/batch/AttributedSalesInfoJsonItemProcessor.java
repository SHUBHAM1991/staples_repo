package com.staples.salesattribution.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

import com.google.gson.Gson;
import com.staples.salesattribution.bo.AttributedSalesDataValidatorChainInvoker;
import com.staples.salesattribution.dto.AttributedSalesInfo;

/**
 * @author rayni002 This Class describes the processing of SalesAttributionInfo
 *         object. process() method is used for the processing of it.
 */
public class AttributedSalesInfoJsonItemProcessor implements ItemProcessor<AttributedSalesInfo, String> {

	final static Logger logger = Logger.getLogger(AttributedSalesInfoJsonItemProcessor.class);
	private final static Gson gson = new Gson();
	/*
	 * process method takes the LineItemCouponInfo object as input and generates
	 * String .
	 */
	@Override
	public String process(AttributedSalesInfo item) throws Exception {
		logger.debug(Thread.currentThread().getName() + "::item in JSON Processor="+item);
		
		String salesInfoJson = "";
		AttributedSalesInfo vldtdAttrbtdSalesInfo = null;
		// validate the attributed sales data
		AttributedSalesDataValidatorChainInvoker vldtnInvoker = new AttributedSalesDataValidatorChainInvoker();
		//synchronized (vldtnInvoker) {
			vldtdAttrbtdSalesInfo = vldtnInvoker.validateAttributedSalesData(item);

			logger.debug(Thread.currentThread().getName() + "::Vldtd Sales Info:: " + vldtdAttrbtdSalesInfo);

			/*
			 * for testing purpose to bypass data validation - the below line
			 * shud be commented b4 prod move
			 * */
			// vldtdAttrbtdSalesInfo.setStale(false);

			if (!vldtdAttrbtdSalesInfo.isStale()) {
				//Gson gson = new Gson();
				salesInfoJson = gson.toJson(vldtdAttrbtdSalesInfo);
				
				//gson = null;
			}
		//}// end of synchronized
		
		vldtdAttrbtdSalesInfo = null;
		vldtnInvoker = null;
		logger.info(Thread.currentThread().getName() + "::Transformed JSON:: " + salesInfoJson);

		return salesInfoJson;
	}

}
