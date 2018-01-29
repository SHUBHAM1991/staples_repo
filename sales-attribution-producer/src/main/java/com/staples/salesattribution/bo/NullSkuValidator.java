package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NullSkuValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NullSkuValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (null == attrSalesInfo.getSkuNum() || "".equals(attrSalesInfo.getSkuNum())
				|| "null".equals(attrSalesInfo.getSkuNum())) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NullSkuValidator");
		} else {
			logger.debug("Invoking NullTranTypeValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
