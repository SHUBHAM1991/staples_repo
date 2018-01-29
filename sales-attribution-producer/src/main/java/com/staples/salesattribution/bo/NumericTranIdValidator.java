package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NumericTranIdValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NumericTranIdValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (!(attrSalesInfo.getTranId().matches("[0-9]+"))) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NumericTranIdValidator");
		} else {
			logger.debug("Invoking NumericOrderNoValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
