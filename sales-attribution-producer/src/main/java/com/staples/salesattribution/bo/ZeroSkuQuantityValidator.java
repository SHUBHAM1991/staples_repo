package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class ZeroSkuQuantityValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(ZeroSkuQuantityValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (Integer.parseInt(attrSalesInfo.getSkuQuantity()) == 0) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside ZeroSkuQuantityValidator");
		} else {
			logger.debug("Invoking NumericTranIdValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
