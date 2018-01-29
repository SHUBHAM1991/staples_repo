package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NullTranTypeValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NullTranTypeValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (null == attrSalesInfo.getTranType() || "".equals(attrSalesInfo.getTranType())
				|| "null".equals(attrSalesInfo.getTranType())) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NullTranTypeValidator");
		} else {
			logger.debug("Invoking NullUnitCostAmtValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
