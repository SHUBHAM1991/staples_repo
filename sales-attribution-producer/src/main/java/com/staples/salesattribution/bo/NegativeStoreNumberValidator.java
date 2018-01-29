package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NegativeStoreNumberValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NegativeStoreNumberValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (Integer.parseInt(attrSalesInfo.getStoreNum()) <= 0) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NegativeStoreNumberValidator");
		} else {
			logger.debug("Invoking NullCouponAmtValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
