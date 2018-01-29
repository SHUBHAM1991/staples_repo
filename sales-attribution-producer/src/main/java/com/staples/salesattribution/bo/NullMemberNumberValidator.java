package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NullMemberNumberValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NullMemberNumberValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (null == attrSalesInfo.getMemberNumber() || "".equals(attrSalesInfo.getMemberNumber())
				|| "null".equals(attrSalesInfo.getMemberNumber())) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NullMemberNumberValidator");
		} else {
			logger.debug("Invoking NullSkuValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
