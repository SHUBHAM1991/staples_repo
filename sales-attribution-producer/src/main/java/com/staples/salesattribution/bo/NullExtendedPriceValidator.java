package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NullExtendedPriceValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NullExtendedPriceValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (null == attrSalesInfo.getExtendedPriceAmt() || "".equals(attrSalesInfo.getExtendedPriceAmt())
				|| "null".equals(attrSalesInfo.getExtendedPriceAmt())) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NullExtendedPriceValidator");
		} else {
			logger.debug("Invoking NullMemberNumberValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
