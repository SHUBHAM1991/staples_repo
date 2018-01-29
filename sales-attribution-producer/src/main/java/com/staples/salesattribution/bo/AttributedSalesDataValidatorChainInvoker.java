package com.staples.salesattribution.bo;

import org.apache.log4j.Logger;

import com.staples.salesattribution.dto.AttributedSalesInfo;

public class AttributedSalesDataValidatorChainInvoker {

	final static Logger logger = Logger.getLogger(AttributedSalesDataValidatorChainInvoker.class);

	public AttributedSalesDataValidatorChainInvoker() {

	}

	public AttributedSalesInfo validateAttributedSalesData(AttributedSalesInfo attribtdSalesInfo) {

		// initialize the chain
		AttributedSalesDataValidatorChain nullMemNoVldtr = new NullMemberNumberValidator();
		AttributedSalesDataValidatorChain negMemNoVldtr = new NegativeMemberNumberValidator();
		AttributedSalesDataValidatorChain negStoreNoVldtr = new NegativeStoreNumberValidator();
		AttributedSalesDataValidatorChain nullCpnAmtVldtr = new NullCouponAmtValidator();
		AttributedSalesDataValidatorChain nullDiscAmtVldtr = new NullDiscountAmtValidator();
		AttributedSalesDataValidatorChain nullExtendedPriceValdtr = new NullExtendedPriceValidator();
		AttributedSalesDataValidatorChain nullSkuVldtr = new NullSkuValidator();
		AttributedSalesDataValidatorChain nullTranTypeVldtr = new NullTranTypeValidator();
		AttributedSalesDataValidatorChain nullUnitCostVldtr = new NullUnitCostAmtValidator();
		AttributedSalesDataValidatorChain zeroSkuQtyVldtr = new ZeroSkuQuantityValidator();
		AttributedSalesDataValidatorChain numericTranIdVldtr = new NumericTranIdValidator();
		AttributedSalesDataValidatorChain numericOrderNoVldtr = new NumericOrderNoValidator();

		logger.debug(Thread.currentThread().getName() + "::Chain objects instantiated");

		// set the chain of validation
		// synchronized (attribtdSalesInfo) {
		nullMemNoVldtr.setNextValidator(nullCpnAmtVldtr);
		nullCpnAmtVldtr.setNextValidator(nullDiscAmtVldtr);
		nullDiscAmtVldtr.setNextValidator(nullExtendedPriceValdtr);
		nullExtendedPriceValdtr.setNextValidator(nullSkuVldtr);
		nullSkuVldtr.setNextValidator(nullTranTypeVldtr);
		nullTranTypeVldtr.setNextValidator(nullUnitCostVldtr);
		nullUnitCostVldtr.setNextValidator(negStoreNoVldtr);
		negStoreNoVldtr.setNextValidator(negMemNoVldtr);
		negMemNoVldtr.setNextValidator(zeroSkuQtyVldtr);
		zeroSkuQtyVldtr.setNextValidator(numericTranIdVldtr);
		numericTranIdVldtr.setNextValidator(numericOrderNoVldtr);

		logger.debug(Thread.currentThread().getName() + "::Chain link set for ::" + attribtdSalesInfo.toString());

		// initiate validation request
		logger.debug(Thread.currentThread().getName() + "**** Calling validator chain on****"
				+ attribtdSalesInfo.toString());
		nullMemNoVldtr.validate(attribtdSalesInfo);
		logger.debug(Thread.currentThread().getName() + "**** Finished validator chain on****"
				+ attribtdSalesInfo.toString());
		// } // end of synchronized

		// release objects
		negMemNoVldtr = null;
		negStoreNoVldtr = null;
		nullCpnAmtVldtr = null;
		nullDiscAmtVldtr = null;
		nullExtendedPriceValdtr = null;
		nullMemNoVldtr = null;
		nullSkuVldtr = null;
		nullTranTypeVldtr = null;
		nullUnitCostVldtr = null;
		zeroSkuQtyVldtr = null;
		numericTranIdVldtr = null;
		numericOrderNoVldtr = null;

		return attribtdSalesInfo;

	}

}
