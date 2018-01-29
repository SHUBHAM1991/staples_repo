package com.staples.salesattribution.bo;

import java.math.BigInteger;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NegativeMemberNumberValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NegativeMemberNumberValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		BigInteger memberNum = new BigInteger(attrSalesInfo.getMemberNumber());
		if (memberNum.signum() == -1) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NegativeMemberNumberValidator");
		} else {
			logger.debug("Invoking NegativeStoreNumberValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
