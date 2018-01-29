package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NumericOrderNoValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NumericOrderNoValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		String orderNum = attrSalesInfo.getOrderNum();
		
		if (!(orderNum.startsWith("POS."))) {
			if (!(orderNum.matches("[0-9]+"))) {
				attrSalesInfo.setStale(true);
				logger.debug("Inside NumericOrderNoValidator");
			}
		} /*
			 * else { attrSalesInfo = this.validator.validate(attrSalesInfo); }
			 */

		return attrSalesInfo;

	}

}
