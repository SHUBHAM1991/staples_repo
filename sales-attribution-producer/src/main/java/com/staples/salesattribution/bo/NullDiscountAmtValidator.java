package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NullDiscountAmtValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NullDiscountAmtValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (null == attrSalesInfo.getDiscAmt() || "".equals(attrSalesInfo.getDiscAmt())
				|| "null".equals(attrSalesInfo.getDiscAmt())) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NullDiscountAmtValidator");
		} else {
			logger.debug("Invoking NullExtendedPriceValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
