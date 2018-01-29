package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NullCouponAmtValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NullCouponAmtValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (null == attrSalesInfo.getCouponAmt() || "".equals(attrSalesInfo.getCouponAmt())
				|| "null".equals(attrSalesInfo.getCouponAmt())) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NullCouponAmtValidator");
		} else {
			logger.debug("Invoking NullDiscountAmtValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
