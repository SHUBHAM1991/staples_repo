package com.staples.salesattribution.service;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staples.salesattribution.dao.AttributedSalesInfoDao;
/**
 * @author rayni002
 *This class autowires CouponLineItemAssociationDao and
 *call it's method to update the Indicator.
 */
@Service
public class AttributedSalesInfoService {

	final static Logger logger = Logger.getLogger(AttributedSalesInfoService.class);

	@Autowired
	private AttributedSalesInfoDao attributedSalesInfoDao;

	public void updateSalesTranDetRewardSentIndicator(Set<String> listForIndUpdate) {
		attributedSalesInfoDao.updateSalesTranDetRewardSentIndicator(listForIndUpdate);
	}
}
