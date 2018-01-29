package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class NullUnitCostAmtValidator implements AttributedSalesDataValidatorChain {

	final static Logger logger = Logger.getLogger(NullUnitCostAmtValidator.class);
	private AttributedSalesDataValidatorChain validator;

	@Override
	public void setNextValidator(AttributedSalesDataValidatorChain nextValidator) {
		this.validator = nextValidator;
	}

	@Override
	public AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo) {

		if (null == attrSalesInfo.getUnitCost() || "".equals(attrSalesInfo.getUnitCost())
				|| "null".equals(attrSalesInfo.getUnitCost())) {
			attrSalesInfo.setStale(true);
			logger.debug("Inside NullUnitCostAmtValidator");
		} else {
			logger.debug("Invoking ZeroSkuQuantityValidator");
			attrSalesInfo = this.validator.validate(attrSalesInfo);
		}

		return attrSalesInfo;

	}

}
