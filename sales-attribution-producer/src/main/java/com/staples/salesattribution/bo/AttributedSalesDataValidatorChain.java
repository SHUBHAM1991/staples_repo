package com.staples.salesattribution.bo;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public interface AttributedSalesDataValidatorChain {

	void setNextValidator(AttributedSalesDataValidatorChain nextValidator);

	AttributedSalesInfo validate(AttributedSalesInfo attrSalesInfo);

}
